import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AcompanhamentoComponent } from './acompanhamento/acompanhamento.component';
import { CadastroUsuarioComponent } from './cadastro-usuario/cadastro-usuario.component';
import { FichaComponent } from './ficha/ficha.component';
import { ListagemBancoComponent } from './listagem-banco/listagem-banco.component';
import { LoginUsuarioComponent } from './login-usuario/login-usuario.component';
import { HomepageComponent } from './homepage/homepage.component';
import { EditUsuarioComponent } from './cadastro-usuario/edit-usuario/edit-usuario.component';

const routes: Routes = [
  {
    path: "",
    redirectTo: "/home",
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
    path: "home",
    component: HomepageComponent,
  },
  {
    path: "ficha",
    component: FichaComponent,
  },
  {
    path: "listagem-banco",
    component: ListagemBancoComponent,
  },
  {
    path: "editar-usuario",
    component: EditUsuarioComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
