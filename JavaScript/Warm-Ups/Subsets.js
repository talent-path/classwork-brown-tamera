/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    let powerSet=[];
  helper(nums,powerSet,[],0);
    return powerSet;

};
function helper(nums,powerSet,currentSet,startingIndex){
    powerSet.push(Array.from(currentSet));
    if(startingIndex==nums.length) return;
    for(let i=startingIndex;i<nums.length;i++){
        currentSet.push(nums[i]);
        helper(nums,powerSet,currentSet,i+1);
        currentSet.pop();
    }
}