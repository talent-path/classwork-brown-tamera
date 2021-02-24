var boolVariable = false;
var numVariable = 50;
var strVariable = "Bob";
var oldArray = ["Alice", "Bob", "Christina", "Dave", "Elizabether", "Frank"];
var tupleVar;
tupleVar = [5, "Robert", false];
var StreetLight;
(function (StreetLight) {
    StreetLight[StreetLight["Red"] = 0] = "Red";
    StreetLight[StreetLight["Yellow"] = 1] = "Yellow";
    StreetLight[StreetLight["Green"] = 2] = "Green";
})(StreetLight || (StreetLight = {}));
var streetLightVar = StreetLight.Yellow;
// "any" basically puts us back in old JS times
var anyVar = 5;
anyVar = "Bob";
numVariable = anyVar;
var objVariable = {};
function printPlayerName(player) {
    console.log(player.name);
    return player.name;
}
var s = { name: "David" };
var optionalVar = {};
optionalVar.name = "David";
optionalVar.studentId = 5;
//let readOnlyVar : GoodStudent = { name: "Bob" };
//not allowed because we've already set it
//even though we don't HAVE TO set it right away, if we don't...we never can
//readOnlyVar.studentId = 7;
var TalentPathStudent = /** @class */ (function () {
    function TalentPathStudent(id, name) {
        this.studentId = id;
        this.name = name;
    }
    TalentPathStudent.prototype.printName = function () {
        console.log(this.name);
    };
    return TalentPathStudent;
}());
var tpStudent = new TalentPathStudent(5, "Bob");
//tpStudent = { studentId: 7, name: "Tamera"};
//console.log( tpStudent.completedProjectName );
tpStudent.completedProjectName = "typescript hello world";
var testRunnable = {
    run: function (printMessage) {
        console.log(printMessage);
        return 0;
    }
};
var num = 5;
//num = 10;  //not allowed
//this is allowed...scary
num += 1;
var addTwoNumbers = function (a, b) {
    return (a + b);
};
console.log(addTwoNumbers(5, 6));
