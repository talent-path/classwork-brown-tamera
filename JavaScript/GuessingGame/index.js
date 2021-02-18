
let secretNum=[];
const GenerateNumber=function(){
 //Generates 4 digit unique number
     //   let arr = [];
        while(secretNum.length < 4){
            let r = Math.floor(Math.random() * 10);
            if(secretNum.indexOf(r) === -1) {
                secretNum.push(r);
            }
        } 
        console.log(secretNum);
        return secretNum.join("");
    }
  
  

let MakeGuess=function(){

    let guessedNumber=Number.parseInt(document.getElementById('userInput').value);
    //convert input to Array
    let userInputArray=Array.from(String(guessedNumber),Number);

    verify(secretNum,userInputArray);
    
    FillBoxes(guessedNumber);
    
}

function verify(secretNum,userInputArray){
        for(let i=0;i<4;i++){
       
       
            //correct
            if(userInputArray[i]===secretNum[i]){
              
                document.getElementById("box"+(i+1)).style.backgroundColor='#1EB300';
               // console.log(document.getElementById("box"(i+1)));
                
            }
            else if( secretNum.includes(userInputArray[i])){
                document.getElementById("box"+(i+1)).style.backgroundColor='#FFFF4D';
            }
            else{
                document.getElementById("box"+(i+1)).style.backgroundColor='#D3212D';
            
            }
        }
    }


function FillBoxes(guessedNumber){

document.getElementById('box1').innerHTML=Math.trunc(Math.trunc(guessedNumber/1000));
document.getElementById('box2').innerHTML=Math.trunc(guessedNumber%1000/100);
document.getElementById('box3').innerHTML=Math.trunc(guessedNumber%100/10);
document.getElementById('box4').innerHTML=Math.trunc(guessedNumber%10);
}

function reset(){
    for(let i=1;i<5;i++){
        document.getElementById('box'+i).style.backgroundColor="white";
        document.getElementById('box'+i).innerHTML="";
        document.getElementById('userInput').value="";
        
    }
    GenerateNumber();
}
GenerateNumber()


