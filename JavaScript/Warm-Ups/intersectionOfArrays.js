var intersection = function(nums1, nums2) {
    
    document.get
    let nums1Set=new Set(nums1);
   let nums2Set=new Set(nums2);
   
   let Resultarray=[];
   
   for(num of nums1Set){
       if(nums2Set.has(num)){
           Resultarray.push(num);
       }
       
   }
   console.log(Resultarray);
}
