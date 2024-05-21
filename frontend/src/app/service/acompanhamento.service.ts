import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { FichaDTO } from "../modules/ficha-dto";
import { DadosBancoDTO } from "../modules/dados-banco-dto";
@Injectable({ providedIn: "root" })
export class AcompanhamentoService {
	constructor(private readonly http: HttpClient) {}

  buscarFichas(id: number): Observable<FichaDTO[]> {
    return this.http.get<FichaDTO[]>(`/api/buscar-fichas/${id}`);
  }

  buscarDadosBanco(): Observable<DadosBancoDTO> {
    return this.http.get<DadosBancoDTO>(`/api/buscar-dados-banco/`);
  }

  apagarFicha(id:number): Observable<void>{
    return this.http.delete<void>(`/api/${id}`);
  }

}
