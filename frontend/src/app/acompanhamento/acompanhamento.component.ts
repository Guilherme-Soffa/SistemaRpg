import { UsuarioDTO } from './../../modules/usuario-dto';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FichaDTO } from 'src/modules/ficha-dto';
import { AcompanhamentoService } from '../service/acompanhamento.service';
import { AntecedenteDTO } from 'src/modules/antecedente-dto';
import { OrigemDTO } from 'src/modules/origem-dto';
import { RacaDTO } from 'src/modules/raca-dto';
import { ClasseDTO } from 'src/modules/classe-dto';


@Component({
  selector: 'app-acompanhamento',
  templateUrl: './acompanhamento.component.html',
  styleUrls: ['./acompanhamento.component.scss']
})


export class AcompanhamentoComponent implements OnInit {
  usuario: UsuarioDTO;
  personagem: string[];
  classe: ClasseDTO[];
  raca: RacaDTO[];
  origem: OrigemDTO[];
  antecedente: AntecedenteDTO[];
  fichas: FichaDTO[];
	activedRoute: ActivatedRoute;
	router: Router;

  constructor(
	  activedRoute: ActivatedRoute,
    private acompanhamentoService: AcompanhamentoService,
    router: Router,
  ) {
    this.activedRoute = activedRoute;
    this.router = router;
  }

  ngOnInit(): void {
    this.activedRoute.queryParams.subscribe(params => {
      this.usuario = params.usuario;
      this.acompanhamentoService.buscarFichas(params.usuario).subscribe((fichas: FichaDTO[]) =>{
        this.fichas = fichas;
        // fichas.forEach(ficha =>{
        //   this.classe.push(ficha.classe);
        //   this.raca.push(ficha.raca);
        //   this.antecedente.push(ficha.antecedente);
        //   this.origem.push(ficha.origem);
        // })
      })
		});
  }


  async redirectToFichas(){
    await this.router.navigate(["/ficha"],{
      queryParams: {
        usuario: this.usuario
      }
    });
  }

  submit(){
    console.log('paramsssssssss');
  }

}
