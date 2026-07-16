class Solution {
    public int gcd(int n,int m)
    {
        
        while(n!=0 && m!=0)
        {
            if(n>m)
            {
                n=n%m;
            }
            else
            {
                m=m%n;
            }
        }
        if(n==0) return m;
        else return n;

    }
    public long gcdSum(int[] nums) 
    {
        int mx=Integer.MIN_VALUE;
        int n=nums.length;
        int []prefix=new int[n];
        for(int i=0;i<n;i++)
        {
            if(nums[i]>mx) mx=nums[i];
            int x=gcd(mx,nums[i]);
            prefix[i]=x;
        }
        Arrays.sort(prefix);
        int i=0;
        int j=n-1;
        long sum=0;
        while(i<j)
        {
            int x=gcd(prefix[i],prefix[j]);
            sum+=x;
            i++;
            j--;
        }

        return sum;

        
    }
}