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

        int validMaxIdx=Math.min(maxIdx+1,n-maxIdx);
        int validMinIdx=Math.min(minIdx+1,n-minIdx);

        return Math.min(validMaxIdx+validMinIdx,Math.min(Math.max(maxIdx+1,minIdx+1),Math.max(n-maxIdx,n-minIdx)));
    }
        
    }