import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NotificationService } from '../service/notification.service';
import { UsuarioDTO } from '../modules/usuario-dto';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {

  activedRoute: ActivatedRoute;
  usuario: UsuarioDTO;

  constructor(
    activedRoute: ActivatedRoute,
    router: Router,
  ) {
    this.activedRoute = activedRoute;
  }
  ngOnInit(): void {

    this.activedRoute.queryParams.subscribe(params => {
      this.usuario = params.usuario;
    });
  }

}
