import { Component } from '@angular/core';
import {AlertController, NavController} from 'ionic-angular';
import{ContactPage} from '../contact/contact';
import{AboutPage} from '../about/about';
@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  uname: string;
  pwd:string;
  constructor(public navCtrl: NavController, public alertctrl:AlertController) {

  }

  login() {
    if (this.uname == "Sireesha" && this.pwd == "Sireesha") {
      this.navCtrl.push(AboutPage);
    }
    else {
      var alert = this.alertctrl.create({
        title: "Please Enter Correct Details",
        buttons: ["Ok"]
      });
      alert.present();
    }
  }

      register(){
    this.navCtrl.push(ContactPage);
  }


}
