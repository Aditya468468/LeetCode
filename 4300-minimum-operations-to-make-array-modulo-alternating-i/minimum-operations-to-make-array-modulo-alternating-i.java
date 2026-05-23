class Solution {

    private int check(int[]nums,int k, int x,int y)
    {
        //x->even, y-->odd.
        //Now we can either inc or dec-> Need Min soo we check Min of both ops.
        // Look for 11%4=3--> we need 0..soo either we do 11-3=8 or 11+(4-3)=12
        // (-)-> 3, (+)-> 1..Min ==1.
        int ops=0;
        for(int i=0;i<nums.length;i++)
        {

            if(i%2==0)
            {
                if(nums[i]%k!=x)
                {
                    int rem=nums[i]%k;
                    int a=Math.abs(x-rem);
                    int b=Math.abs(k-a);
                    ops+=Math.min(a,b);
                }

            }
            else
            {
                if(nums[i]%k!=y)
                {
                    int rem=nums[i]%k;
                    int a=Math.abs(y-rem);
                    int b=Math.abs(k-a);
                    ops+=Math.min(a,b);
                }

            }
        }
        return ops;
    }
    public int minOperations(int[] nums, int k) 
    {
        int minOps=Integer.MAX_VALUE;
        //There could be Multiple poss of x ,y..
        // We Fix x-(some), y can be anything btw 0 to k.
        //Used hint-> Told we can process All possibilties.
        
        for(int i=0;i<k;i++)
        {
            for(int j=0;j<k;j++)
            {
                if(i == j) continue;
                int ans=check(nums,k,i,j);
                if(ans<minOps) minOps=ans;

            }
        }

        return minOps;
        
    }
}