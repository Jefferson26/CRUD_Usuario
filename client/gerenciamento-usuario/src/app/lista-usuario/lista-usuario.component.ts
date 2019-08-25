import { Component, OnInit } from '@angular/core';
import { HttpClientService, Usuario } from '../service/http-client.service';

@Component({
  selector: 'app-lista-usuario',
  templateUrl: './lista-usuario.component.html',
  styleUrls: ['./lista-usuario.component.css']
})
export class ListaUsuarioComponent implements OnInit {

  usuarios:Usuario[];
  colunas_table: string[] = ['nome', 'cpf', 'nascimento', 'genero', 'funcao', 'acoes'];
  constructor(
    private httpClientService:HttpClientService
  ) { }

  ngOnInit() {
    this.httpClientService.getUsuariosCadastrados().subscribe(
      response =>this.handleSuccessfulResponse(response),
     );
  }

  handleSuccessfulResponse(response){
    this.usuarios=response;
  }

  deleteUsuario(usuario: Usuario): void {
    this.httpClientService.deleteUsuario(usuario)
      .subscribe( data => {
        this.usuarios = this.usuarios.filter(u => u !== usuario);
      })
  };
}
