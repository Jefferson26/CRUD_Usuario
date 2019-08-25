import { Component, OnInit, Inject } from '@angular/core';
import { HttpClientService, Usuario } from '../service/http-client.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

export interface DialogData {
  nome: string;
  cpf: string;
  funcao: string;
  papeis: [];
}

@Component({
  selector: 'app-lista-usuario',
  templateUrl: './lista-usuario.component.html',
  styleUrls: ['./lista-usuario.component.css']
})

export class ListaUsuarioComponent implements OnInit {

  usuarios:Usuario[];
  colunas_table: string[] = ['nome', 'cpf', 'nascimento', 'genero', 'funcao', 'acoes'];
  constructor(
    private httpClientService:HttpClientService,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.httpClientService.getUsuariosCadastrados().subscribe(
      response => {
        this.handleSuccessfulResponse(response);
      });
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

  openDialog(usuario: Usuario): void {
    const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
      width: '850px',
      data: {usuario: usuario}
    });
  }
}


@Component({
  selector: 'edit-usuario',
  templateUrl: 'edit-usuario.html',
  styleUrls: ['./edit-usuario.css']
})
export class DialogOverviewExampleDialog {

  constructor(
    public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}