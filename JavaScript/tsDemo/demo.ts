let boolVariable : boolean = false;

let numVariable : number = 50;

let strVariable : string = "Bob";

let oldArray : string[] = [ "Alice", "Bob", "Christina", "Dave", "Elizabether", "Frank" ];

let tupleVar : [number, string, boolean];

tupleVar = [5, "Robert", false];

enum StreetLight {
    Red,
    Yellow,
    Green
}

let streetLightVar : StreetLight = StreetLight.Yellow;

// "any" basically puts us back in old JS times
let anyVar : any = 5;

anyVar = "Bob";
numVariable = anyVar;


let objVariable : object = {};
//objVariable.newProp = 5;


interface TicTacToePlayer{
    name : string;
    turn : boolean;
}


function printPlayerName( player : TicTacToePlayer ) : string {
    console.log( player.name );
    return player.name;
}


interface Student {
    studentId?: number,     //this field is optional, because when we add a student we don't have the id until the api gives it
    name : string
}

let s : Student = { name : "David" };

let optionalVar : Partial<Student> = {};
optionalVar.name = "David";
optionalVar.studentId = 5;

//not allowed because Student doesn't have this
//optionalVar.newProp = 5;


//still not allowed because Student doesn't have this
//let studentWithExtra : Student = { name: "Bob", newProp: 5 };

interface GoodStudent extends Student {

    completedProjectName: string

}

//let readOnlyVar : GoodStudent = { name: "Bob" };

//not allowed because we've already set it
//even though we don't HAVE TO set it right away, if we don't...we never can
//readOnlyVar.studentId = 7;


class TalentPathStudent implements GoodStudent{
    studentId: number;
    name: string;
    completedProjectName : string;
    constructor( id : number, name : string ){
        this.studentId = id;
        this.name = name;
    }

    printName() : void {
        console.log( this.name );

    }
}

let tpStudent : TalentPathStudent = new TalentPathStudent( 5, "Bob" );

//tpStudent = { studentId: 7, name: "Tamera"};

//console.log( tpStudent.completedProjectName );

tpStudent.completedProjectName = "typescript hello world";


interface Runnable {
    run( printMessage: string );
}

let testRunnable : Runnable = {
    run : function( printMessage : string ){
        console.log( printMessage );

        return 0;

    }
}

// let allEqual : (a : number, b : number , c : number) => boolean;

// allEqual = function( a : number, b : number, c: number ) : boolean {
//     return true;
// }

// allEqual = function( a: number, b: number, c: number ) : boolean {
//     return false;
// }

// allEqual = function( ) : boolean {
//     return true;
// }


type OneDigitNumber = 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9;

let num : OneDigitNumber = 5;
//num = 10;  //not allowed

//this is allowed...scary
num += 1;

let addTwoNumbers = function(a : OneDigitNumber, b : OneDigitNumber ) : OneDigitNumber {

    return (a + b) as OneDigitNumber;
}

console.log( addTwoNumbers( 5, 6 ) );


type LightStatus = "red" | "yellow" | "green" | 5;

let currentLight : LightStatus = "red";

currentLight += " arrow";




let mixedTypeVariable : string | Student | null;

mixedTypeVariable = "Bob";
mixedTypeVariable = tpStudent;









