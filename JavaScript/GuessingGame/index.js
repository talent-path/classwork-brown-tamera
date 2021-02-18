
const GenerateNumber=function(){
    const digits = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

    let answer = digits.splice( Math.trunc(Math.random() * (digits.length - 1) + 1 ), 1)[0];
  
    for( let i = 1; i < 4; i++ ){
  
      let randomIndex = Math.trunc(Math.random() * digits.length);
  
      let digit = digits.splice(randomIndex,1)[0];
      answer *= 10;
      answer += digit;
      answer.toString();
  
      //digits.splice(  )
  
  
    }
    console.log(answer);
  
    return answer;
  
  }
  

let MakeGuess=function(){

    let guessedNumber=document.getElementById('userInput').value;
    //convert input to Array
    let userInputArray=Array.from(String(guessedNumber),Number);

   
    FillBoxes(guessedNumber);

    //green #00FF00
    //red #D3212D
    //yellow #FFFF4D

    
}

function FillBoxes(guessedNumber){

document.getElementById('box1').innerHTML=Math.trunc(Math.trunc(guessedNumber/1000));
document.getElementById('box2').innerHTML=Math.trunc(guessedNumber%1000/100);
document.getElementById('box3').innerHTML=Math.trunc(guessedNumber%1000/10);
document.getElementById('box4').innerHTML=Math.trunc(guessedNumber%10);
}
function reset(){
    for(let i=0;i<5;i++){
        document.getElementById('box'+i+1).style.backgroundColor='#FFFFFF';
        document.getElementById('box'+i+1).style.innerHTML="";
        
    }
    GenerateNumber();
}
GenerateNumber()


