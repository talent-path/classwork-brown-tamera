import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'tictactoe-square',
  templateUrl: './tictactoe-square.component.html',
  styleUrls: ['./tictactoe-square.component.css']
})
export class TictactoeSquareComponent implements OnInit {

  @Input() value: string;
  constructor() { }

  ngOnInit(): void {
  }

}
