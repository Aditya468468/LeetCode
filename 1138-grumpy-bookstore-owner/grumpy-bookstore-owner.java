class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) 
    {
        //His grumpiness should be min -> Wind with maxSum of size mins
        //Now there can be multiple wind ,choose with maxCustomers.
        int n=customers.length;
        int maxSum=Integer.MIN_VALUE; //recover
        int cust=0;
        int left=0;
        int ans=0;

        for(int right=0;right<n;right++)
        {
            //Whomever i can take,i will take no issues there,
            if(grumpy[right]==0)
            {
                ans+=customers[right];
            }
            //Lets just process whom we cant take.

            else if(grumpy[right]==1) // If == 0 already taken them.
            {
                cust+=customers[right];
            }
            if(right-left+1>minutes)
            {
                if(grumpy[left]==1) //Remove only if we add
                {
                    cust-=customers[left];
                }
            
                left++;
            }
            if(right-left+1==minutes)
            {
                if(maxSum<cust) // A continious win of Mins with maxCus incoming
                {
                    maxSum=cust;
                }
            }
            

        }

        return ans+maxSum;
        
    }
}