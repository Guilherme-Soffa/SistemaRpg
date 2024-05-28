import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MAT_FORM_FIELD_DEFAULT_OPTIONS, MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { AcompanhamentoComponent } from './acompanhamento/acompanhamento.component';
import {MatIconModule} from '@angular/material/icon';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CadastroUsuarioComponent } from './cadastro-usuario/cadastro-usuario.component';
import { FichaComponent } from './ficha/ficha.component';
import { LoginUsuarioComponent } from './login-usuario/login-usuario.component';
import { ListagemBancoComponent } from './listagem-banco/listagem-banco.component';
import { HttpErrorInterceptor } from './config/handler-errors.interceptor';
import { MapDialogComponent } from './map-dialog/map-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { TextAreaDialogComponent } from './acompanhamento/dialog/text-area-dialog/text-area-dialog.component';
import { UploadImageDialogComponent } from './acompanhamento/dialog/upload-image-dialog/upload-image-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroUsuarioComponent,
    LoginUsuarioComponent,
    FichaComponent,
    MapDialogComponent,
    AcompanhamentoComponent,
    ListagemBancoComponent,
    MapDialogComponent,
    TextAreaDialogComponent,
    UploadImageDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatDialogModule,
    HttpClientModule,
    FormsModule,
    MatSelectModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatIconModule,
    ToastrModule.forRoot(),
  ],
  providers: [{provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: {appearance: 'fill'}},
  {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpErrorInterceptor,
      multi: true,
  },
],
  bootstrap: [AppComponent]
})
export class AppModule { }
