import { Component, OnInit } from '@angular/core';
import {SucursalService} from "../../services/sucursal.service";
import {Sucursal} from "../../models/sucursal";
import {MatTableDataSource} from "@angular/material/table";
import {Producto} from "../../models/producto";
import {ProductoService} from "../../services/producto.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {OrdenService} from "../../services/orden.service";
import {Orden} from "../../models/orden";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  dataSucursales: Sucursal[] = [];
  dataSourceSucursales!: MatTableDataSource<Sucursal>;
  displayedColumns: string[] = ['sucursal_id', 'nombre'];
  sucursalSeleccionada!: Sucursal;

  dataProductos: Producto[] = [];
  dataSourceProductos!: MatTableDataSource<Producto>;
  displayedColumnsProducto: string[] = ['producto_id', 'codigo', 'descripcion', 'precio', 'modificar'];

  listaProductos: Producto[] = [];
  totalCarrito: number = 0;

  constructor(private sucursalService: SucursalService,
              private productoService: ProductoService,
              private ordenService: OrdenService,
              private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.getDatosSucursales();
  }

  private getDatosSucursales() {
    this.sucursalService.getSucursales().subscribe((response) => {
      this.dataSucursales = response;
      this.dataSourceSucursales = new MatTableDataSource(this.dataSucursales);
    });
  }

  private getDataProductos() {
    this.productoService.getProductos().subscribe((response) => {
      this.dataProductos = response;
      this.dataSourceProductos = new MatTableDataSource(this.dataProductos);
    });
  }

  public selectSucursal(suc: Sucursal) {
    this.sucursalSeleccionada = suc;
    this.getDataProductos();
  }

  public agregaProducto(prod: Producto) {
    this.listaProductos.push(prod);
    this._snackBar.open('¡Producto agregado!', 'Aceptar', {
      duration: 3000
    });
    this.totalCarrito += prod.precio;
  }

  public vaciaCarrito() {
    this.listaProductos = [];
    this.totalCarrito = 0;
  }

  public guardaOrden() {
    if (this.listaProductos.length <= 0) {
      this._snackBar.open('El carrito se encuentrra vacío', 'Cerrar', {
        duration: 3000
      });

      return;
    }

    var precioProductos: number[] = [];
    this.listaProductos.forEach((producto) => precioProductos.push(producto.precio));
    this.totalCarrito = precioProductos.reduce((sumaParcial, precio) => sumaParcial + precio, 0);
    var ordenCarrito: Orden = {
      sucursal_id: this.sucursalSeleccionada.sucursal_id,
      fecha: new Date(Date.now()),
      total: this.totalCarrito,
      productos: this.listaProductos
    };

    console.log("Orden antes de insertar...", ordenCarrito);
    this.ordenService.saveOrden(ordenCarrito).subscribe((response) => {
      console.log("response Orden", response);
    }, error => {
      console.log("Error al registrar la orden")
    });
  }

  public abrirDialogoModificar() {
    // TODO Terminar implementación de diálogo para capturar orden
  }
}
