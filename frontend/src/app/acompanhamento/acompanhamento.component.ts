import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { AntecedenteDTO } from 'src/modules/antecedente-dto';
import { ClasseDTO } from 'src/modules/classe-dto';
import { FichaDTO } from 'src/modules/ficha-dto';
import { OrigemDTO } from 'src/modules/origem-dto';
import { RacaDTO } from 'src/modules/raca-dto';

import { AcompanhamentoService } from '../service/acompanhamento.service';
import { UsuarioDTO } from './../../modules/usuario-dto';

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

  displayedColumns: string[] = ['personagem', 'raca', 'classe', 'antecedente', 'origem'];
  dataSource: FichaDTO[] = [];

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
        console.log('aaaaaaaaaa',fichas)
        this.fichas = fichas;
        console.log(this.fichas)
        this.dataSource = this.fichas;
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

  async redirectToLogin(){
    await this.router.navigate(["/login"]);
  }

  async redirectToListagem(){
    await this.router.navigate(["/listagem-banco"],{
      queryParams: {
        usuario: this.usuario
      }
    });
  }
}
