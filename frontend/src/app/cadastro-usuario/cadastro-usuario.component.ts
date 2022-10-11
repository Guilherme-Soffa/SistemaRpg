import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UsuarioDTO } from '../../modules/usuario-dto';
import { CadastroUsuarioService } from '../service/cadastro-usuario.service';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.scss']
})
export class CadastroUsuarioComponent implements OnInit {

  form: FormGroup;

  constructor(
    readonly formBuilder: FormBuilder,
    private cadastroUsuarioService: CadastroUsuarioService,
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      usuario: [null],
      password: [null]
    })
  }
  submit(){
    this.trataDados();
    this.cadastroUsuarioService.cadastrarUsuario(this.trataDados()).subscribe();
    console.log('enviado!',this.trataDados())
  }
  trataDados(): UsuarioDTO{
    const dados = this.form.controls
    return {
      nome: dados.usuario.value,
      password: dados.password.value
    } as UsuarioDTO;
  }
}
