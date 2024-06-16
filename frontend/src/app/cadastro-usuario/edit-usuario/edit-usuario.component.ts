import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioDTO } from 'src/app/modules/usuario-dto';
import { CadastroUsuarioService } from 'src/app/service/cadastro-usuario.service';
import { NotificationService } from 'src/app/service/notification.service';

@Component({
  selector: 'app-edit-usuario',
  templateUrl: './edit-usuario.component.html',
  styleUrls: ['./edit-usuario.component.scss']
})
export class EditUsuarioComponent implements OnInit {


  form: FormGroup;
  router: Router;
  activedRoute: ActivatedRoute;
  usuario: UsuarioDTO;
  hide = true;

  constructor(
    router: Router,
    readonly formBuilder: FormBuilder,
    private cadastroUsuarioService: CadastroUsuarioService,
    private notificationService: NotificationService,
    private cadastroService: CadastroUsuarioService,
    activedRoute: ActivatedRoute,
  ) {
    this.router = router;
    this.activedRoute = activedRoute;

  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      usuario: [null, Validators.required],
      password: [null, Validators.required]
    })

    this.activedRoute.queryParams.subscribe(params => {
      this.usuario = params.usuario;
      this.cadastroService.findUsuarioById(params.usuario).subscribe(r => {
        this.form.patchValue({
          usuario: r.usuario,
          password: r.password
        });
      });
    });
  }
  submit() {
    this.form.markAllAsTouched();
    if (this.form.valid) {
      this.trataDados();
      this.cadastroUsuarioService.editarUsuario(this.trataDados()).subscribe(r => {
        this.router.navigate(["/home"],{
            queryParams: {
              usuario: r.id
            }
          });
        this.notificationService.sucesso('Usuario Cadastrado com Sucesso!')
      });
    }
  }
  trataDados(): UsuarioDTO {
    const dados = this.form.controls
    return {
      usuario: dados.usuario.value,
      password: dados.password.value
    } as UsuarioDTO;
  }
}
