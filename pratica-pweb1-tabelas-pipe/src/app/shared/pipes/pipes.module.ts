import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {LetraMaiusculaPipe} from './letra-maiuscula.pipe';
import { CpfPipe } from './cpf.pipe';
import { PhonePipePipe } from './phone-pipe.pipe';



@NgModule({
  declarations: [LetraMaiusculaPipe, CpfPipe, PhonePipePipe],
  imports: [
    CommonModule
  ],
  exports: [
    LetraMaiusculaPipe,
    CpfPipe,
    PhonePipePipe
  ]
})
export class PipesModule { }
