import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class LibrariesService {
  private port = 8080;
  private apiVersionCommon = '/api/v1';
  private host =
    window.location.protocol +
    '//' +
    window.location.hostname +
    ':' +
    this.port +
    this.apiVersionCommon;
  private librariesGetAll = this.host + '/libraries/';
  private librariesGetById = this.host + '/libraries/:id';
  private librariesDelete = this.host + '/libraries/:id';
  private librariesUpdate = this.host + '/libraries/:id';

  constructor(private http: HttpClient) {}

  getLibraries(): Observable<any> {
    return this.http.get<any>(this.librariesGetAll);
  }
}
