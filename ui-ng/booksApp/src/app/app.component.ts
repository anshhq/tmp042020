import { Component, OnInit } from '@angular/core';
import { LibrariesService } from 'services/libraries.service';
import { BooksService } from 'services/books.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  public title = 'booksApp';
  public libraries = [];
  public librariesError: string = '';
  private booksAll = [];
  private booksAllError: string = '';

  constructor(
    private librariesService: LibrariesService,
    private booksService: BooksService
  ) {
    this.getLibrariesAll();
  }

  ngOnInit(): void {
    this.getLibrariesAll();
  }

  getLibrariesAll() {
    this.librariesService.getLibraries().subscribe(
      (data) => {
        this.libraries = data;
        console.log(data);
      },
      (error) => {
        this.librariesError =
          'Error: ' + error.status + ', ' + error.statusText;
      }
    );
  }

  getBooksAll() {
    this.booksService.getBooksAll().subscribe(
      (data) => {
        this.booksAll = data;
        console.log(data);
      },
      (error) => {
        this.booksAllError = 'Error: ' + error.status + ', ' + error.statusText;
      }
    );
  }

  filterBooksByLibraryId() {}
}
