import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { AntecedenteDTO } from '../modules/antecedente-dto';
import { ClasseDTO } from '../modules/classe-dto';
import { FichaDTO } from '../modules/ficha-dto';
import { OrigemDTO } from '../modules/origem-dto';
import { RacaDTO } from '../modules/raca-dto';

import { AcompanhamentoService } from '../service/acompanhamento.service';
import { NotificationService } from '../service/notification.service';
import { UsuarioDTO } from '../modules/usuario-dto';
import { MatDialog } from '@angular/material/dialog';
import { TextAreaDialogComponent } from './dialog/text-area-dialog/text-area-dialog.component';
import { UploadImageDialogComponent } from './dialog/upload-image-dialog/upload-image-dialog.component';

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
  id: number;

  displayedColumns: string[] = ['upload', 'personagem', 'raca', 'classe', 'antecedente', 'origem', 'id'];
  dataSource: FichaDTO[] = [];

  constructor(
	  activedRoute: ActivatedRoute,
    private acompanhamentoService: AcompanhamentoService,
    router: Router,
    public dialog: MatDialog,
    private notificationService: NotificationService,
  ) {
    this.activedRoute = activedRoute;
    this.router = router;
  }

  ngOnInit(): void {
    this.activedRoute.queryParams.subscribe(params => {
      this.usuario = params.usuario;
      this.id = params.usuario;
      this.acompanhamentoService.buscarFichas(params.usuario).subscribe((fichas: FichaDTO[]) =>{
        this.fichas = fichas;
        this.dataSource = this.fichas;
      })
		});
  }

  deletarFicha(id:number){
    this.acompanhamentoService.apagarFicha(id).subscribe(r=>{
      this.notificationService.sucesso('Ficha Apagada!');
      this.dataSource = this.dataSource.filter(x => x.id != id)
    })
  }

  async atualizarFicha(id:number){
    await this.router.navigate(["/ficha"],{
      queryParams: {
        usuario: this.usuario,
        visualizar: true
      }
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

  openDialog(id: number, element:any): void {
    const dialogRef = this.dialog.open(TextAreaDialogComponent, {
      width: '900px',
      data: { text: element.notas.notas, id: id}
    });
    dialogRef.afterClosed().subscribe(result => {
      if(result){
        this.acompanhamentoService.atualizarNotas(id, result).subscribe(r=>{
          this.notificationService.sucesso('Notas Atualizada!');
          this.acompanhamentoService.buscarFichas(this.id).subscribe((fichas: FichaDTO[]) =>{
            this.fichas = fichas;
            this.dataSource = this.fichas;
          })
        });
      }
    });
  }

  openUploadDialog(id: number): void {
    const dialogRef = this.dialog.open(UploadImageDialogComponent, {
      width: '500px',
      data: { id: id }
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result){
        // handle the result here
      }
    });
  }
}
