import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [
    './app.component.css'
  ]
})
export class AppComponent {
  key = 'menu';
  title = "Welcome | Food EZ";
  compNumber = 0;

  public change_outlet(event: any){
    if (event.hasOwnProperty('key') && event.hasOwnProperty('title'))
      switch (event.key){
        case 'menu': this.compNumber = 0; break;
        case 'about-us': this.compNumber = 1; break;
        case 'products': this.compNumber = 2; break;
        case 'contact-us': this.compNumber = 3; break;
      }
      this.title = event['title'];
  }
}
