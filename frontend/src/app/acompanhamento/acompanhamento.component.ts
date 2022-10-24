import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { FichaDTO } from 'src/modules/ficha-dto';
import { AcompanhamentoService } from '../service/acompanhamento.service';


@Component({
  selector: 'app-acompanhamento',
  templateUrl: './acompanhamento.component.html',
  styleUrls: ['./acompanhamento.component.scss']
})


export class AcompanhamentoComponent implements OnInit {



  personagem: string = 'teste1';
  classe: string = 'teste2';
  raca: string = 'teste3';
  origem: string = 'teste4';
  antecedente: string = 'teste5';
	activedRoute: ActivatedRoute;

  constructor(
	  activedRoute: ActivatedRoute,
    private acompanhamentoService: AcompanhamentoService,
  ) {
    this.activedRoute = activedRoute;
  }

  ngOnInit(): void {
    this.activedRoute.queryParams.subscribe(params => {
      this.acompanhamentoService.buscarFichas(params.id).subscribe((r: FichaDTO) =>{
        const a = r
      })
			console.log('if', params)
		});

  }
  submit(){
    console.log('paramsssssssss');
  }

}
