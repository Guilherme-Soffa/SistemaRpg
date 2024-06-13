import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, catchError, throwError } from "rxjs";
import { RacasClassesDTO } from "../modules/racas-classes-dto";
import { ClasseDTO } from "../modules/classe-dto";
import { FichaDTO } from "../modules/ficha-dto";
import { OrigensAntecedentesDTO } from "../modules/origens-antecedentes-dto";
import { RacaDTO } from "../modules/raca-dto";
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

  atualizarFicha(ficha: FichaDTO): Observable<FichaDTO> {
    return this.http.post<FichaDTO>(`/api/atualizar-ficha`,ficha);
  }

  apiElfica(): Observable<void>{
    return this.http.get<void>(`https://api.fungenerators.com/name/generate?category=elf&limit=20`).pipe(
      catchError((error: HttpErrorResponse) => {
        let errorMessage = 'Unknown error occurred';
        if (error.status === 0) {
          errorMessage = 'limit overused'; // Customize your error message here
        }
        return throwError(errorMessage);
      })
    );
  }

  findById(id: number): Observable<FichaDTO> {
    return this.http.get<FichaDTO>(`/api/buscar-ficha/${id}`);
  }
}
