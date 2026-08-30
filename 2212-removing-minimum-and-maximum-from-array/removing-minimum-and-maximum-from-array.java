class Solution {
    public int minimumDeletions(int[] nums) 
    {
        int maxElem=Integer.MIN_VALUE;
        int minElem=Integer.MAX_VALUE;
        int minIdx=-1;
        int maxIdx=-1;
        int n=nums.length;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>maxElem)
            {
                maxElem=nums[i];
                maxIdx=i;
            }
            if(nums[i]<minElem)
            {
                minElem=nums[i];
                minIdx=i;
            }
        }

       int left=Math.min(maxIdx,minIdx);
       int right=Math.max(maxIdx,minIdx);

       int front=right+1;
       int back=n-left;

       int frontAndBack=(left+1)+(n-right);

       return Math.min(front,Math.min(back,frontAndBack));
    }
        
    }