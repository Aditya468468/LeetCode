class Solution {
    public int compareBitonicSums(int[] nums) 
    {
       int n=nums.length;
       long asc=nums[0];
       long desc=0;
       int i;
       for(i=1;i<n;i++)
       {
            if(nums[i-1]<nums[i])
            {
                asc+=nums[i];
            }
            else break;
       }
       
       for(int j=i-1;j<n;j++)
       {
            desc+=nums[j];
       }

       if(asc>desc) return 0;
       else if(desc>asc) return 1;
       else return -1;
        
        
        
    }
}