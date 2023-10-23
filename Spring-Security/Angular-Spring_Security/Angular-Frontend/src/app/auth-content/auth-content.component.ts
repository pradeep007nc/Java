import { Observable, of, from } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { AxiosService } from './../services/axios.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-auth-content',
  templateUrl: './auth-content.component.html',
  styleUrls: ['./auth-content.component.css']
})
export class AuthContentComponent {

  data: Observable<string[]> = of([]);

  constructor(private axiosService: AxiosService) {}

  ngOnInit(): void {
    this.data = from(
      this.axiosService.request('GET', '/messages', {})
        .then(response => response.data)
        .catch(error => {
          if (error.response && error.response.status === 401) {
            this.axiosService.setAuthToken(null);
          }

          console.error('Error:', error);
          // Handle other errors appropriately, set a default value or show an error message
          return [];
        })
    );

  }

}
