import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioDTO } from '../modules/usuario-dto';
import { CadastroUsuarioService } from '../service/cadastro-usuario.service';
import { NotificationService } from '../service/notification.service';

@Component({
  selector: 'app-login-usuario',
  templateUrl: './login-usuario.component.html',
  styleUrls: ['./login-usuario.component.scss']
})
export class LoginUsuarioComponent implements OnInit {

  form: FormGroup;

	router: Router;

  constructor(
    readonly formBuilder: FormBuilder,
    private cadastroUsuarioService: CadastroUsuarioService,
	  router: Router,
    private notificationService: NotificationService,
    ) {

    this.router = router;
  }

  ngOnInit(): void {

    this.form = this.formBuilder.group({
      usuario: [null, Validators.required],
      password: [null, Validators.required]
    })
  }
  submit(){
    this.form.markAllAsTouched();
    if(this.form.valid){
      this.trataDados();
      this.cadastroUsuarioService.logarUsuario(this.trataDados()).subscribe(r=>{
        if(r != null){
          this.notificationService.sucesso('Usuario Logado!')
          this.router.navigate(["/home"],{
              queryParams: {
                usuario: r.id
              }
            });
        }else{
          this.notificationService.erro('Senha ou Usuário errado!')
        }
      });
    }else{
      this.notificationService.erro('Senha ou Usuário errado!')
    }
  }
  trataDados(): UsuarioDTO{
    const dados = this.form.controls
    return {
      usuario: dados.usuario.value,
      password: dados.password.value
    } as UsuarioDTO;
  }

}
