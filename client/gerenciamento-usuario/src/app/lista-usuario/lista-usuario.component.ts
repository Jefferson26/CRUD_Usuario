import { Component, OnInit, Inject, Input } from '@angular/core';
import { HttpClientService, Usuario } from '../service/http-client.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatTableDataSource} from '@angular/material';

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
  dataSource: any;

  @Input() usuarios:Usuario[];
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
    this.dataSource = new MatTableDataSource(this.usuarios);
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

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
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