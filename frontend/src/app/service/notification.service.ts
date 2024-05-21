import {Injectable} from '@angular/core';
import {ToastrService} from 'ngx-toastr';

/**
 * Service para chamada do serviço de toast do angular.
 */
@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private readonly toastService: ToastrService) {

  }

  sucesso(mensagem: string) {
    this.toastService.success(mensagem, 'Sucesso', {
      positionClass: 'toast-top-center',
    });
  }

  erro(mensagem: string) {
    this.toastService.error(mensagem, 'Erro', {
      positionClass: 'toast-top-center',
    });
  }

  info(mensagem: string) {
    this.toastService.info(mensagem, 'Informação');
  }

  alerta(mensagem: string) {
    this.toastService.warning(mensagem, 'Alerta');
  }

  limpar(){
    this.toastService.clear();
  }
}

