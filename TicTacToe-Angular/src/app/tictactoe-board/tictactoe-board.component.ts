import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'tictactoe-board',
  templateUrl: './tictactoe-board.component.html',
  styleUrls: ['./tictactoe-board.component.css']
})
export class TictactoeBoardComponent implements OnInit {

 squares:string[];
 winner:string;
 Turn:boolean;
 draw:string;
//  RoundNum:number;
//  numWins:number;
//   numLoss:number;
 



constructor() { }

   ngOnInit(): void {
    // this.RoundNum=this.NumOfRounds();
   this.StartGame();
   }

//    NumOfRounds(): number {
//        let rounds=parseInt(prompt("How many rounds would you like to play?"));
//   while(rounds<= 0 || isNaN(rounds)) {
//   alert("You have to play at least 1 round!");
//    rounds=parseInt(prompt("How many rounds would you like to play?"));
//   }
//    return rounds;
//  }

StartGame():void{
  this.squares=Array(9).fill(null);
  this.winner=null;
  this.Turn=true;
  this.draw=null;
  // this.numWins=0;
  // this.numLoss=0;
  
 
}
get player(){
  return this.Turn ? 'X': 'O';
}
makeMove(pos:number):void{
if(!this.squares[pos]){
this.squares.splice(pos,1,this.player);
this.Turn=!this.Turn;
}
this.winner=this.Won();
this.draw=this.Draw();

}
Won(): string{
  const possibleWinLocations=
  [
    [0,1,2],
    [3,4,5],
    [6,7,8],
    [0,3,6],
    [1,4,7],
    [2,5,8],
    [0,4,8],
    [2,4,6]
  ];
  for(let i=0;i<possibleWinLocations.length;i++){
    const[a,b,c]=possibleWinLocations[i];
    if(this.squares[a]==this.squares[b] 
      && this.squares[a]===this.squares[c]){
        return this.squares[a];
      }
      
    }
 return null;
}
Draw(): string{
  if((!this.squares.includes(null) && this.winner==null)){
    return 'Draw';
  }
  return null;
}
}
