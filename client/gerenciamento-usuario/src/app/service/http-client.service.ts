import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class Usuario{
  constructor(
    public id:BigInteger,
    public nome:String,
    public cpf:String,
    public dt_nascimento:Date,
    public genero:GeneroEnum,
    public funcao:Funcao
  ) {}
}

export enum GeneroEnum {
  Masculino = 1,
  Feminino = 2,
  Indefinido = 3,
}

export class Funcao{
  constructor(
    public id:BigInteger,
    public nome_funcao:String,
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient:HttpClient
  ) { 
     }
  
  public getUsuariosCadastrados(){
    return this.httpClient.get<Usuario[]>('http://localhost:8080');
  }

  public deleteUsuario(usuario) {
    return this.httpClient.delete<Usuario>("http://localhost:8080/"+ usuario.id);
  }

  public createUsuario(usuario) {
    return this.httpClient.post<Usuario>("http://localhost:8080/", usuario);
  }
}
