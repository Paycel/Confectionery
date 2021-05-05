import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {User} from './user';
import {Observable} from 'rxjs/Observable';
import {Subject} from "rxjs";

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user).subscribe(() => console.log('send register request'));
  }

  public login(username: string, email: string, password: string) {
    const params = new HttpParams()
      .set('username', username)
      .set('email', email)
      .set('password', password);
    let user: User;
    var subject = new Subject<User>();
    this.getData(params).subscribe((current: User) => {
      user = current;
      subject.next(user);
    });
    return subject.asObservable();
  }

  getData(params: HttpParams) {
    return this.http.get(this.usersUrl, {params});
  }
}
