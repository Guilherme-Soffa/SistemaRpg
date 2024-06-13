import { NotificationService } from './../service/notification.service';
import { OrigemDTO } from '../modules/origem-dto';
import { AntecedenteDTO } from '../modules/antecedente-dto';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClasseDTO } from '../modules/classe-dto';
import { RacaDTO } from '../modules/raca-dto';
import { FichaService } from '../service/ficha.service';
import { UsuarioDTO } from '../modules/usuario-dto';
import { FichaDTO } from '../modules/ficha-dto';
import { MatDialog } from '@angular/material/dialog';
import { MapDialogComponent } from '../map-dialog/map-dialog.component';



@Component({
  selector: 'app-ficha',
  templateUrl: './ficha.component.html',
  styleUrls: ['./ficha.component.scss']
})
export class FichaComponent implements OnInit {


  router: Router;
  personagem: string;
  racas: RacaDTO[] = [];
  classes: ClasseDTO[] = [];
  origens: OrigemDTO[] = [];
  antecedentes: AntecedenteDTO[] = [];
  activedRoute: ActivatedRoute;
  usuarioId: number;
  usuario: UsuarioDTO;
  fichaId: number;
  visualizar: boolean;
  racaSelecionada: RacaDTO;
  classeSelecionada: ClasseDTO;
  form: FormGroup;
  nomesElficosBuscados: any;
  idFicha: number;

  constructor(
    activedRoute: ActivatedRoute,
    readonly formBuilder: FormBuilder,
    private fichaService: FichaService,
    private notificationService: NotificationService,
    router: Router,
    public dialog: MatDialog
  ) {
    this.activedRoute = activedRoute;
    this.router = router;
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      raca: [null, Validators.required],
      classe: [null, Validators.required],
      antecedente: [null, Validators.required],
      origem: [null, Validators.required],
      nomePersonagem: [null, Validators.required],
    });

    this.activedRoute.queryParams.subscribe(params => {
      this.usuarioId = params.usuario;
      this.usuario = params.usuario;
      this.visualizar = params.visualizar;
      this.fichaId = params.fichaId;
    });

    // this.fichaService.apiElfica().subscribe((r: any) => {
    //   this.nomesElficosBuscados = r.contents.names;
    // });

    this.fichaService.buscarRacaClasse().subscribe(r => {
      this.racas = r.racas;
      this.classes = r.classes;
    });

    if (this.visualizar) {
      this.editarFicha();
    }

  }

  submit() {
    if (this.form.valid) {
      this.fichaService.cadastrarFicha(this.trataDados()).subscribe(r => {
        this.notificationService.sucesso('Cadastro de ficha realisado com sucesso!');
        this.router.navigate(["/acompanhamento"], {
          queryParams: {
            usuario: this.usuarioId
          }
        });
      });
    } else {
      this.form.markAllAsTouched();
      this.notificationService.erro('Preencha todos os campos obrigatórios')
    }
  }

  atualizarFicha() {
    if (this.form.valid) {
      this.fichaService.atualizarFicha(this.trataDados()).subscribe(() => {
        this.notificationService.sucesso('Ficha Atualizada!');
        this.router.navigate(["/acompanhamento"], {
          queryParams: {
            usuario: this.usuarioId
          }
        });
      });
    } else {
      this.form.markAllAsTouched();
      this.notificationService.erro('Preencha todos os campos obrigatórios')
    }
  }

  editarFicha() {
    this.fichaService.findById(this.fichaId).subscribe((ficha: FichaDTO) => {

      this.idFicha = ficha.id
      const data = this.form.controls;
      data.nomePersonagem.setValue(ficha.personagem);

      const raca = this.racas.find(r => r.raca === ficha.raca.raca);
      data.raca.setValue(raca);

      const classe = this.classes.find(r => r.classe === ficha.classe.classe);
      data.classe.setValue(classe);
      this.buscaOrigemAntecedente(data,ficha);


    });
  }

  async voltar() {
    await this.router.navigate(["/acompanhamento"], {
      queryParams: {
        usuario: this.usuarioId
      }
    });
  }

  openDialog(): void {
    this.dialog.open(MapDialogComponent, { width: '800px' });
  }

  trataDados(): FichaDTO {
    const dados = this.form.controls;
    const usuario: UsuarioDTO = {
      id: this.usuarioId,
      usuario: '',
      password: '',
    }
    return {
      id: this.idFicha,
      usuario: usuario,
      personagem: dados.nomePersonagem.value,
      raca: dados.raca.value,
      classe: dados.classe.value,
      origem: dados.origem.value,
      antecedente: dados.antecedente.value,
    } as FichaDTO;

  }

  gerarNomes() {
    const numero = Math.floor(Math.random() * this.nomesElficosBuscados.length);
    this.form.controls.nomePersonagem.setValue(this.nomesElficosBuscados[numero]);
  }

  buscaOrigemAntecedente(data?: any, ficha?: any) {
    if (this.form.controls.raca.value != null && this.form.controls.classe.value != null) {
      this.fichaService.buscarOrigemAntecedente(this.form.controls.raca.value, this.form.controls.classe.value).subscribe(r => {
        this.origens = r.origens;
        this.antecedentes = r.antecedentes;
        if(this.visualizar){

          const origem = this.origens.find(o => o.origem === ficha.origem.origem);
          data.origem.setValue(origem);

          const antecedente = this.antecedentes.find(a => a.antecedente === ficha.antecedente.antecedente);
          data.antecedente.setValue(antecedente);
        }
      });
    }
  }

}
