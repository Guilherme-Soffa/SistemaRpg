import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { AntecedenteDTO } from '../modules/antecedente-dto';
import { ClasseDTO } from '../modules/classe-dto';
import { DadosBancoDTO } from '../modules/dados-banco-dto';
import { FichaDTO } from '../modules/ficha-dto';
import { OrigemDTO } from '../modules/origem-dto';
import { RacaDTO } from '../modules/raca-dto';

import { AcompanhamentoService } from '../service/acompanhamento.service';
import { UsuarioDTO } from '../modules/usuario-dto';

@Component({
  selector: 'app-listagem-banco',
  templateUrl: './listagem-banco.component.html',
  styleUrls: ['./listagem-banco.component.scss']
})
export class ListagemBancoComponent implements OnInit {
  usuario: UsuarioDTO;
  personagem: string[];
  classe: ClasseDTO[];
  raca: RacaDTO[];
  origem: OrigemDTO[];
  antecedente: AntecedenteDTO[];
  fichas: DadosBancoDTO;
	activedRoute: ActivatedRoute;
	router: Router;

  displayedColumns1: string[] = ['raca'];
  displayedColumns2: string[] = ['classe'];
  displayedColumns3: string[] = ['antecedente'];
  displayedColumns4: string[] = ['origem'];
  dataSource1: RacaDTO[]
  dataSource2: ClasseDTO[]
  dataSource3: AntecedenteDTO[]
  dataSource4: OrigemDTO[]

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
    ;

      this.usuario = params.usuario;
      this.acompanhamentoService.buscarDadosBanco().subscribe((dados: DadosBancoDTO) =>{

        this.dataSource1 = dados.raca;
        this.dataSource2 = dados.classe;
        this.dataSource3 = dados.antecedente;
        this.dataSource4 = dados.origem;
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
  async redirectToAcompanhamento(){
    await this.router.navigate(["/acompanhamento"],{
      queryParams: {
        usuario: this.usuario
      }
    });
  }
}
