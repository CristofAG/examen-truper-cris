import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Orden} from "../models/orden";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class OrdenService {

  constructor(private http: HttpClient) { }

  public saveOrden(orden: Orden) {
    return this.http.post<any>(environment.servicesApi + '/orden', orden);
  }
}
