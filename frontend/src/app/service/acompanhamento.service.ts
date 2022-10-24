import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { FichaDTO } from "src/modules/ficha-dto";
@Injectable({ providedIn: "root" })
export class AcompanhamentoService {
	constructor(private readonly http: HttpClient) {}

  buscarFichas(id: number): Observable<FichaDTO> {
    return this.http.get<FichaDTO>(`/api/buscar-fichas/${id}`);
  }

}
