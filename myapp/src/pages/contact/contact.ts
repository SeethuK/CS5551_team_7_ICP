import { Component } from '@angular/core';
import {AlertController, NavController} from 'ionic-angular';
import {AboutPage} from '../about/about';

@Component({
  selector: 'page-contact',
  templateUrl: 'contact.html'
})
export class ContactPage {
  pwd:string;
  cpwd:string;
  constructor(public navCtrl: NavController, public alertCtrl:AlertController) {

  }
  register1(){
    if(this.pwd==this.cpwd)
    this.navCtrl.push(AboutPage);
    else{
      var alert = this.alertCtrl.create({
        title: "Password should match",
        buttons: ["Ok"]
      });
      alert.present();
    }




  }

}
