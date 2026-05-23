class Solution {
    public int minimumSwaps(int[] nums) 
    {
        int n=nums.length;
        int swaps=0;
        int i=0;
        int j=n-1;
        while(j>=0 && nums[j]==0)
        {
            j--;
        }
        while(i<j)
        {
            if(nums[i]==0)
            {
                j--;
                while(j>i && nums[j]==0)
                {
                    j--;
                }
                swaps++;
            }
            i++;

        }

        return swaps;
        
    }
}