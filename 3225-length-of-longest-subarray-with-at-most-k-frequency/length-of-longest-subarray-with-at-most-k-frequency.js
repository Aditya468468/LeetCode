/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxSubarrayLength = function(nums, k) 
{
        let map=new Map();
        let maxLen=0;   
        let  n=nums.length;
        let left=0;
        for(let right=0;right<n;right++)
        {
            let num=nums[right];
            map.set(num,(map.get(num) ?? 0)+1);
            while(map.get(num)>k)
            {
                let x=nums[left];
                map.set(x,map.get(x)-1);
                if(map.get(x)==0)
                {
                    map.delete(x);
                }
                left++;
            }
            let len=right-left+1;
            maxLen=Math.max(maxLen,len);
        }


        return maxLen;

    
};