import { Component, Input, OnInit } from '@angular/core';
import { Bishop } from '../Chess/Pieces/Bishop';
import { Piece, PieceType } from '../Chess/Pieces/Piece';

@Component({
  selector: 'chess-square',
  templateUrl: './chess-square.component.html',
  styleUrls: ['./chess-square.component.css']
})
export class ChessSquareComponent implements OnInit {
  @Input()squarePiece:Piece=new Bishop(true);
  imagesrc:string="./assets/";
  @Input()row:number=0;
  @Input()col:number=0;
  islightSquare:boolean;

  constructor() { }

  ngOnInit(): void {
    if(this.squarePiece==null){
      this.imagesrc="";
    }
    else{

    this.imagesrc+=this.squarePiece.isWhite ? 'w': 'b';
    switch(this.squarePiece.kind){
        case PieceType.Bishop: this.imagesrc+='B'; break;
        case PieceType.King: this.imagesrc+='K'; break;
        case PieceType.Knight:this.imagesrc+='N'; break;
        case PieceType.Pawn:this.imagesrc+='P'; break;
        case PieceType.Queen:this.imagesrc+='Q'; break;
        case PieceType.Rook: this.imagesrc+='R'; break;
    }
    this.imagesrc+='.png';

      
  }
  this.islightSquare=((this.row + this.col) % 2 ===0);
  
}
  }


