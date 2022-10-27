import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AcompanhamentoComponent } from './acompanhamento/acompanhamento.component';
import { CadastroUsuarioComponent } from './cadastro-usuario/cadastro-usuario.component';
import { FichaComponent } from './ficha/ficha.component';
import { ListagemBancoComponent } from './listagem-banco/listagem-banco.component';
import { LoginUsuarioComponent } from './login-usuario/login-usuario.component';

const routes: Routes = [
  {
    path: "",
    redirectTo: "/login",
    pathMatch: "full"
  },

  {
  path: "cadastro",
  component: CadastroUsuarioComponent,
  },
  {
    path: "login",
    component: LoginUsuarioComponent,
  },
  {
    path: "acompanhamento",
    component: AcompanhamentoComponent,
  },
  {
    path: "ficha",
    component: FichaComponent,
  },
  {
    path: "listagem-banco",
    component: ListagemBancoComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
