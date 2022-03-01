import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuComponent } from './menu/menu.component';
import {MatMenuModule} from "@angular/material/menu";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule} from "@angular/material/button";

@NgModule({
    imports: [
        CommonModule,
        MatMenuModule,
        BrowserAnimationsModule,
        MatButtonModule,
    ],
    exports: [
        MenuComponent
    ],
    declarations: [MenuComponent]
})
export class LayoutModule { }