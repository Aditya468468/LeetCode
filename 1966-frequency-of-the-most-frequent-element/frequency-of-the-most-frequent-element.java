class Solution {
    public int maxFrequency(int[] nums, int k) 
    {
        Arrays.sort(nums); // Nearer will Compute first.
        int n=nums.length;
        int maxLen=0;
        int left=0;
        long sum=0;
        for(int right=0;right<n;right++)
        {

            sum+=nums[right];
            // In L len -> All elements same will Have Sum= (len)*MaxElem.
            //As only inc is possible we need to come up till MAX of Array.
            while((long)nums[right]*(right-left+1)>sum+k)
            {
                sum-=nums[left];
                left++;
            }
            int cnt=right-left+1;
            if (cnt>maxLen) maxLen=cnt;

        }

        return maxLen;


        
    }
}