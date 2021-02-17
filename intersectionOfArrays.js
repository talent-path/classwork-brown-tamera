var intersection = function(nums1, nums2) {
    
    let nums1Set=new Set(nums1);
   let nums2Set=new Set(nums2);
   
   let Resultarray=[];
   
   for(num of nums1Set){
       if(nums2Set.has(num)){
           Resultarray.push(num);
       }
       
   }
   return Resultarray;
};


// let nums1Set=new Set(num1);
// let nums2Set=new Set(num2);

// let result= new Set([...numsSet1].filter(x=>numsSet2.has(x)));

// return result;
