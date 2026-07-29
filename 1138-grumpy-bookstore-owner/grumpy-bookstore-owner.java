class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) 
    {
        //His grumpiness should be min -> Wind with maxSum of size mins
        //Now there can be multiple wind ,choose with maxCustomers.
        int n=customers.length;
        int maxSum=Integer.MIN_VALUE;
        int cust=0;
        int left=0;
        //Whomever i can take,i will take no issues there,
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(grumpy[i]==0)
            {
                ans+=customers[i];
            }
        }
        //Lets just process whom we cant take.

        for(int right=0;right<n;right++)
        {
            if(grumpy[right]==1)
            {
                cust+=customers[right];
            }
            if(right-left+1>minutes)
            {
                if(grumpy[left]==1)
                {
                    cust-=customers[left];
                }
            
                left++;
            }
            if(right-left+1==minutes)
            {
                if(maxSum<cust)
                {
                    maxSum=cust;
                }
            }
            

        }

        ans+=maxSum;

        return ans;
        
    }
}