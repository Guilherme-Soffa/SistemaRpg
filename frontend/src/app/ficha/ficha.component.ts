import { OrigemDTO } from './../../modules/origem-dto';
import { AntecedenteDTO } from './../../modules/antecedente-dto';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClasseDTO } from 'src/modules/classe-dto';
import { RacaDTO } from 'src/modules/raca-dto';
import { FichaService } from '../service/ficha.service';
import { UsuarioDTO } from 'src/modules/usuario-dto';
import { FichaDTO } from 'src/modules/ficha-dto';


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
  racaSelecionada: RacaDTO;
  classeSelecionada: ClasseDTO;
  form: FormGroup;

  constructor(
    activedRoute: ActivatedRoute,
    readonly formBuilder: FormBuilder,
    private fichaService: FichaService,
    router: Router,
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
      personagem: [null, Validators.required],
    })

    this.fichaService.buscarRacaClasse().subscribe(r=>{
      this.racas = r.racas
      this.classes = r.classes
    });

    this.activedRoute.queryParams.subscribe(params => {
      this.usuarioId = params.usuario;
		});
  }

  submit(){
    console.log(this.trataDados())
    this.fichaService.cadastrarFicha(this.trataDados()).subscribe(r=>{
      this.router.navigate(["/acompanhamento"],{
        queryParams: {
          usuario: this.usuarioId
        }
      });
    });
  }

  async voltar(){
    await this.router.navigate(["/acompanhamento"],{
      queryParams: {
        usuario: this.usuarioId
      }
    });
  }

  trataDados(): FichaDTO{
    const dados =  this.form.controls;
    const usuario: UsuarioDTO = {
      id: this.usuarioId,
      usuario: '',
      password:'',
    }
    return {
      usuario: usuario,
      raca: dados.raca.value,
      classe: dados.classe.value,
      origem: dados.origem.value,
      antecedente: dados.antecedente.value,
    }as FichaDTO;

  }

  buscaOrigemAntecedente(event: any){
    if(this.form.controls.raca.value != null && this.form.controls.classe.value != null ){
      this.fichaService.buscarOrigemAntecedente(this.form.controls.raca.value, this.form.controls.classe.value).subscribe(r=>{
        this.origens = r.origens;
        this.antecedentes = r.antecedentes;
      })
    }
  }
}
