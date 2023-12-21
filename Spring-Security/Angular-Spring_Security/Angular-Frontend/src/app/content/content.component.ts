import { Component } from '@angular/core';
import { AxiosService } from '../services/axios.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent {

  contentToShow: string = "welcome";

  constructor(private axiosService: AxiosService){}

  showComponent(contentToShow: string) : void{
    this.contentToShow = contentToShow;
  }

  onLogin(input: any): void{
    this.axiosService.request(
      "POST",
      "/login",
      {
        login: input.login,
        password: input.password
      }
    ).then(response => {
      this.axiosService.setAuthToken(response.data.token);
      this.contentToShow = "messages";
    }).catch(error => {
            this.axiosService.setAuthToken(null);
            this.contentToShow = "welcome";
    })
  }


  onRegister(input: any): void{
    this.axiosService.request(
      "POST",
      "/register",
      {
        firstName: input.firstName,
        lastName: input.lastName,
        login: input.login,
        password: input.password
      }
    ).then(response => {
      this.axiosService.setAuthToken(response.data.token);
      this.contentToShow = "messages";
    }).catch(
      error => {
        this.axiosService.setAuthToken(null);
        this.contentToShow = "welcome";
    }
    )
  }
}
