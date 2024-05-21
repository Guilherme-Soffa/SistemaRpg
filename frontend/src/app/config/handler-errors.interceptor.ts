import { Injectable } from '@angular/core';
import {
    HttpErrorResponse,
    HttpEvent,
    HttpHandler,
    HttpInterceptor,
    HttpRequest,
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { NotificationService } from '../service/notification.service';

@Injectable()
export class HttpErrorInterceptor implements HttpInterceptor {
    constructor(private notificacao: NotificationService) {}

    intercept(
        request: HttpRequest<unknown>,
        next: HttpHandler
    ): Observable<HttpEvent<unknown>> {
        return next.handle(request).pipe(
            catchError((error: HttpErrorResponse) => {
                let errorMessage = '';
                if (error.error instanceof ErrorEvent) {
                    // client-side error
                    errorMessage = `Error: ${error.error.message}`;
                } else {
                    // server-side error
                    if (error?.error?.errors) {
                        for (const erro of error.error.errors) {
                            errorMessage += `${erro.defaultMessage}\n`;
                            this.notificacao.erro(erro.defaultMessage);
                        }
                    } else if (error.error?.message) {
                        errorMessage = error.error.message;
                        this.notificacao.erro(errorMessage);
                    } else {
                        errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
                        this.notificacao.erro(errorMessage);
                    }
                }
                return throwError(errorMessage);
            })
        );
    }
}
