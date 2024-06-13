import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AntecedenteDTO } from '../modules/antecedente-dto';
import { ClasseDTO } from '../modules/classe-dto';
import { FichaDTO } from '../modules/ficha-dto';
import { OrigemDTO } from '../modules/origem-dto';
import { RacaDTO } from '../modules/raca-dto';

import { MatDialog } from '@angular/material/dialog';
import { UsuarioDTO } from '../modules/usuario-dto';
import { AcompanhamentoService } from '../service/acompanhamento.service';
import { FichaService } from '../service/ficha.service';
import { NotificationService } from '../service/notification.service';
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
  imagePreview: string | ArrayBuffer;

  displayedColumns: string[] = ['upload', 'personagem', 'raca', 'classe', 'antecedente', 'origem', 'id'];
  dataSource: FichaDTO[] = [];

  constructor(
    activedRoute: ActivatedRoute,
    private acompanhamentoService: AcompanhamentoService,
    private changeDetector: ChangeDetectorRef,
    private fichaService: FichaService,
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
      this.acompanhamentoService.buscarFichas(params.usuario).subscribe((fichas: FichaDTO[]) => {
        fichas.map(ficha => {
          if (ficha.imagem) {
            ficha.imagem = 'data:image/jpeg;base64,' + ficha.imagem;
          }
        });
        this.fichas = fichas;
        this.dataSource = this.fichas;
      })
    });
  }

  deletarFicha(id: number) {
    this.acompanhamentoService.apagarFicha(id).subscribe(r => {
      this.notificationService.sucesso('Ficha Apagada!');
      this.dataSource = this.dataSource.filter(x => x.id != id)
    })
  }

  async atualizarFicha(id: number) {
    await this.router.navigate(["/ficha"], {
      queryParams: {
        usuario: this.usuario,
        fichaId: id,
        visualizar: true
      }
    });
  }

  openDialog(id: number, element: any): void {
    const dialogRef = this.dialog.open(TextAreaDialogComponent, {
      width: '900px',
      data: { text: element.notas.notas, id: id }
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.acompanhamentoService.atualizarNotas(id, result).subscribe(r => {
          this.notificationService.sucesso('Notas Atualizada!');
          this.acompanhamentoService.buscarFichas(this.id).subscribe((fichas: FichaDTO[]) => {
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
      if (result) {
        this.acompanhamentoService.salvarUpload(id, result).subscribe(() => {

        });
        this.router.navigate(["/acompanhamento"], {
          queryParams: {
            usuario: this.id
          }
        });
      }
    });
  }
}
