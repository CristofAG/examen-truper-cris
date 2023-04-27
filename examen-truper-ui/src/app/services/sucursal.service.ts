import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Sucursal} from "../models/sucursal";

@Injectable({
  providedIn: 'root'
})
export class SucursalService {

  constructor(private http: HttpClient) { }

  public getSucursales() {
    return this.http.get<Sucursal[]>(environment.servicesApi + '/sucursales');
  }
}
