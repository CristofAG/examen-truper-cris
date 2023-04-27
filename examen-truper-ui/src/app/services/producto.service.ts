import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Producto} from "../models/producto";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor(private http: HttpClient) { }

  public getProductos() {
    return this.http.get<Producto[]>(environment.servicesApi + '/productos');
  }
}
