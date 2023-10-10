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
      console.log(response)
    }).catch(error => {
      console.log("mama mia")
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
      console.log(response)
    }).catch(error => {
      console.log("mama mia")
    })
  }
}
