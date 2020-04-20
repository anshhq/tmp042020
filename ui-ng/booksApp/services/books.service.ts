import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class BooksService {
  private host =
    window.location.protocol +
    '//' +
    window.location.hostname +
    ':' +
    window.location.port;
  private booksGetAll = this.host + '/books/';
  private booksGetById = this.host + '/books/:id';
  private booksDelete = this.host + '/books/:id';
  private booksUpdate = this.host + '/books/:id';

  constructor(private http: HttpClient) {}

  getBooksAll(): Observable<any> {
    return this.http.get<any>(this.booksGetAll);
  }
}
