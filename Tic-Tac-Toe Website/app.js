
let player=true;
let status=document.getElementById("PlayerTurnStatus");

    
function Move(buttonId){
    
    let el=document.getElementById(buttonId);
    
    while(player){
    
     status.innerHTML="Your Turn";
    el.style.background= "url('https://image.freepik.com/free-icon/x-symbol_318-1407.jpg') no-repeat 100px";
    el.style.backgroundSize='75px';
    el.style.backgroundRepeat="no-repeat"
    el.style.alignContent="center"
    el.disabled=true;
    


    player=false;
    CheckWinner();
    Move();
    }
    status.innerHTML="Player 2 Turn";
    el.style.background="url('https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Letter_o.svg/1200px-Letter_o.svg.png')";
    el.style.backgroundSize='65px';
    el.style.backgroundRepeat="no-repeat"
    el.style.alignContent="center"
    el.disabled=true;
  
   player=true;
   CheckWinner();
   Move()
   
    
}
function CheckWinner(){
    
}
function ResetGame(){

}
