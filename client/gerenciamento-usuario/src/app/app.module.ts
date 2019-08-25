import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from './material.module';
import { CadastroUsuarioComponent } from './cadastro-usuario/cadastro-usuario.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxMaskModule } from 'ngx-mask';
import { ListaUsuarioComponent, DialogOverviewExampleDialog } from './lista-usuario/lista-usuario.component';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    CadastroUsuarioComponent,
    ListaUsuarioComponent,
    DialogOverviewExampleDialog
  ],
  entryComponents: [ListaUsuarioComponent, DialogOverviewExampleDialog],
  imports: [
    BrowserModule,
    HttpClientModule,
    MaterialModule,
    BrowserAnimationsModule,
    NgxMaskModule.forRoot(),
    FormsModule,
    ReactiveFormsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
