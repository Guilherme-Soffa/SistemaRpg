import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FichaDTO } from 'src/app/modules/ficha-dto';
import { AcompanhamentoService } from 'src/app/service/acompanhamento.service';
import { FichaService } from 'src/app/service/ficha.service';
import { NotificationService } from 'src/app/service/notification.service';

@Component({
  selector: 'app-upload-image-dialog',
  templateUrl: './upload-image-dialog.component.html',
  styleUrls: ['./upload-image-dialog.component.scss']
})
export class UploadImageDialogComponent implements OnInit {
  selectedFile: File;
  imagePreview: string | ArrayBuffer;

  constructor(
    private fichaService: FichaService,
    public dialogRef: MatDialogRef<UploadImageDialogComponent>,
    public notificationService: NotificationService,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit(): void {
    this.fichaService.findById(this.data.id).subscribe((ficha: FichaDTO) => {
      this.imagePreview = 'data:image/jpeg;base64,' + ficha.imagem;
    });
  }


  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];

    // Set a file size limit of 1MB
    const fileSizeLimit = 1024 * 1024;

    if (this.selectedFile.size > fileSizeLimit) {
      this.notificationService.erro('File size should not exceed 1MB!')
      return;
    }

    const reader = new FileReader();
    reader.onload = () => {
      this.imagePreview = reader.result as string;
    };
    reader.readAsDataURL(this.selectedFile);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
