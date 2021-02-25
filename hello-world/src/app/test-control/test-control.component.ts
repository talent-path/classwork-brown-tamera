import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'test-control',
  templateUrl: './test-control.component.html',
  styleUrls: ['./test-control.component.css']
})
export class TestControlComponent implements OnInit {

  imageSrc:String="https://nick.mtvnimages.com/uri/mgid:arc:content:nick.com:9cd2df6e-63c7-43da-8bde-8d77af9169c7?quality=0.7";
  defaultImage:boolean=true;
  constructor() { }

  ngOnInit(): void {
  }
  OnClick(): void {
    
    this.imageSrc="https://upload.wikimedia.org/wikipedia/en/thumb/4/44/SpongeBob_SquarePants_characters_promo.png/370px-SpongeBob_SquarePants_characters_promo.png";
  }
  
}
