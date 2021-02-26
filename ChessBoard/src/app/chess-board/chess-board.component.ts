import { Component, OnInit } from '@angular/core';
import { Board, ChessBoard } from '../Chess/Board';

@Component({
  selector: 'chess-board',
  templateUrl: './chess-board.component.html',
  styleUrls: ['./chess-board.component.css']
})
export class ChessBoardComponent implements OnInit {
  board: Board= new ChessBoard();
  constructor() { }

  ngOnInit(): void {
  }

}
