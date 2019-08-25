import { Component, OnInit } from '@angular/core';
import { HttpClientService, Usuario, Funcao } from '../service/http-client.service';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css']
})
export class CadastroUsuarioComponent implements OnInit {

  papeis = new FormControl();

  funcoes: Funcao[] = [
    {id: 1, nome_funcao: 'Usuário Comum', papeis:null},
    {id: 2, nome_funcao: 'Administrador', papeis:null}
  ];

  usuario: Usuario = new Usuario( null,"","",null,null, this.funcoes[0]);
  
  

  papeis_list = [
     {id:1, papel:[
      {id: 1, nome_papel: 'Papel 1'},
      {id: 2, nome_papel: 'Papel 2'}
    ]},
    {id:2, papel:[
      {id: 1, nome_papel: 'Administrador 1'},
      {id: 2, nome_papel: 'Administrador 2'}
    ]}
  ];

  papeis_atual = [
      {id: 1, nome_papel: 'Papel 1'},
      {id: 2, nome_papel: 'Papel 2'},
      {id: 1, nome_papel: 'Administrador 1'},
      {id: 2, nome_papel: 'Administrador 2'},
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

  changePapeis(funcao): void {
    var papeis_atual = this.papeis_list.filter(papel_atual => {
       if(papel_atual.id === funcao.id){       
        return papel_atual.papel;
      }
    })
    
  };
}