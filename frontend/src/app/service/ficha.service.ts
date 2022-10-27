import { RacaDTO } from './../../modules/raca-dto';
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { FichaDTO } from "src/modules/ficha-dto";
import { RacasClassesDTO } from "src/modules/racas-classes-dto";
import { ClasseDTO } from 'src/modules/classe-dto';
import { OrigensAntecedentesDTO } from 'src/modules/origens-antecedentes-dto';
@Injectable({ providedIn: "root" })
export class FichaService {
	constructor(private readonly http: HttpClient) {}

  buscarRacaClasse(): Observable<RacasClassesDTO> {
    return this.http.get<RacasClassesDTO>(`/api/buscar-raca-classe`);
  }

  buscarOrigemAntecedente(raca: RacaDTO, classe: ClasseDTO): Observable<OrigensAntecedentesDTO> {
    return this.http.get<OrigensAntecedentesDTO>(`/api/buscar-origem-antecedente/${raca.id}/${classe.id}`);
  }

  cadastrarFicha(ficha: FichaDTO): Observable<FichaDTO> {
    return this.http.post<FichaDTO>(`/api/cadastrar-ficha`,ficha);
  }

}
