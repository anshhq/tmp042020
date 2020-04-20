import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { BooksService } from 'services/books.service';
import { LibrariesService } from 'services/libraries.service';

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, HttpClientModule],
  providers: [BooksService, LibrariesService],
  bootstrap: [AppComponent],
})
export class AppModule {}
