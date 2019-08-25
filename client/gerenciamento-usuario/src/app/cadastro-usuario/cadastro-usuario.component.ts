import { Component, OnInit } from '@angular/core';
import { HttpClientService, Usuario } from '../service/http-client.service';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css']
})
export class CadastroUsuarioComponent implements OnInit {

  usuario: Usuario = new Usuario( null,"","",null,null,null);

  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {}
  
  createUsuario(): void {
    this.httpClientService.createUsuario(this.usuario)
        .subscribe( data => {
          alert("Usuario cadastrado");
        });

  };
}