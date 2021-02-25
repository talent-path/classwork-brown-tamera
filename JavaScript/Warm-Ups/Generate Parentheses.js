/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    const result=[];
    helper(result,"",0,0,n);
    return result;
};
let helper=function(result,str,open,close,n){
    if(left == n && right==n ) {
        result.push(str);
        return;
    }
    if(open < n){
        helper(result,str + '(',open+1,close,n);
    }
    if(close<open){
        helper(result,str + ')',open,close+1,n);
    }
}