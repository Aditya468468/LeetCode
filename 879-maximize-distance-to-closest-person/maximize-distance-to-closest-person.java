class Solution {
    public int maxDistToClosest(int[] seats) 
    {
        int n=seats.length;
        //Lets process the ends.
        int left=0;
        while(left<n && seats[left]!=1)
        {
            left++;
        }
        int max=left;
        int right=n-1;
        while(right>left && seats[right]!=1)
        {
            right--;
        }
        max=Math.max(max,n-right-1);
        
        //Need to process Gaps..btw two points best post is the equibrillum pos.
        // because at there only .. Length from both ends would be same.
        int prev=left;
        for(int i=left+1;i<=right;i++)
        {
            if(seats[i]==1)
            {
                int optimal=(i-prev)/2;
                max=Math.max(optimal,max);
                prev=i;

            }
        }

        return max;


        
        
        
    }
}