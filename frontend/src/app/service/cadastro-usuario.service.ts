import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { UsuarioDTO } from "src/modules/usuario-dto";
@Injectable({ providedIn: "root" })
export class CadastroUsuarioService {
	constructor(private readonly http: HttpClient) {}

  cadastrarUsuario(usuario: UsuarioDTO): Observable<UsuarioDTO> {
    return this.http.post<UsuarioDTO>(`${environment.cadastroApiUrl}/usuario`, usuario);
  }
}