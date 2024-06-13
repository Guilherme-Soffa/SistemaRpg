import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { FichaDTO } from "../modules/ficha-dto";
import { DadosBancoDTO } from "../modules/dados-banco-dto";
import { NotasDTO } from "../modules/notas-dto";
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

  atualizarNotas(id: number, notas: string): Observable<void> {
    const notasDTO:NotasDTO = {id, notas};
    return this.http.post<void>(`/api/salvar-notas`, notasDTO);
  }

  salvarUpload(id: number, file: File): Observable<void> {
    const formData: FormData = new FormData();
    formData.append('image', file, file.name);
    formData.append('id', id.toString());

    return this.http.post<void>(`/api/upload-image`, formData);
  }
}
