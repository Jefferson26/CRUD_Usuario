import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class Usuario{
  constructor(
    public id:BigInteger,
    public nome:String,
    public cpf:String,
    public dt_nascimento:Date,
    public genero:String,
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
  
  getUsuariosCadastrados(){
    return this.httpClient.get<Usuario[]>('http://localhost:8080');
  }
}
