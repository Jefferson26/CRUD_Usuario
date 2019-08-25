import { Component, OnInit } from '@angular/core';
import { HttpClientService, Usuario, Funcao } from '../service/http-client.service';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css']
})
export class CadastroUsuarioComponent implements OnInit {

  usuario: Usuario = new Usuario( null,"","",null,null,null);
  
  funcoes = [
    {id: 1, nome_funcao: 'Usuário Comum'},
    {id: 2, nome_funcao: 'Administrador'},
  ];

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