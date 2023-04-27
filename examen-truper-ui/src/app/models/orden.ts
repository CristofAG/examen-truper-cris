import {Producto} from "./producto";

export interface Orden {
  orden_id?: number,
  fecha: Date,
  total: number,
  sucursal_id?: number,
  productos?: Producto[]
}
