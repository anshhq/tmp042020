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
  public libraries: Array<{
    libraryId: number;
    libraryName: string;
  }> = [];
  public librariesError: string = '';
  private booksAll: Array<{
    bookId: number;
    libraryId: number;
    bookName: string;
  }> = [];
  private booksAllError: string = '';
  public booksCurrent: Array<string> = [];
  public booksCurrentError: string = '';
  public libraryCurrent: string = '';

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
      },
      (error) => {
        this.booksAllError = 'Error: ' + error.status + ', ' + error.statusText;
        console.log(this.booksAllError);
      }
    );
  }

  filterBooksByLibraryId(libraryId: number) {
    this.libraryCurrent = this.libraries.find(
      (o) => o.libraryId === libraryId
    ).libraryName;
    this.booksCurrent = [];
    this.booksAll.forEach((e) => {
      if (e.libraryId === libraryId) {
        this.booksCurrent.push(e.bookName);
      }
    });
  }

  displayBooks(libraryId: number) {
    this.getBooksAll();
    this.filterBooksByLibraryId(libraryId);
    this.ngOnInit();
  }
}
