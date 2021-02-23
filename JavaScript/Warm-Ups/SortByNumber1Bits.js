/**
 * @param {number[]} arr
 * @return {number[]}
 */
var sortByBits = function(arr) {
    return arr.sort((a,b)=>bitCount(a)-bitCount(b) || (a-b));

};
const bitCount=function(num){
let count =0;
while(num){
    count+=num & 1;
    num=num >> 1;

}
return count;
}