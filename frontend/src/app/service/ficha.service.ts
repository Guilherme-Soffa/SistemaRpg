import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { FichaDTO } from "src/modules/ficha-dto";
import { RacasClassesDTO } from "src/modules/racas-classes-dto";
@Injectable({ providedIn: "root" })
export class FichaService {
	constructor(private readonly http: HttpClient) {}

  buscarRacaClasse(): Observable<RacasClassesDTO> {
    return this.http.get<RacasClassesDTO>(`/api/buscar-raca-classe`);
  }

}
