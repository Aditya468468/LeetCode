class Solution {
    public int[] decrypt(int[] code, int k) 
    {
        int n=code.length;
        int[]ans=new int[n];
        if(k==0)
        {
            return ans;
        }
        int sum=0;
        int left=0;
        boolean parity=k>0;
        if(k<0)
        {
            k=k*(-1);
        }
        for(int right=0;right<2*n;right++)
        {
            sum+=code[right%n];
            
            if(right-left+1>k)
            {
                sum-=code[left%n];
                left++;
            }
            if(right-left+1==k)
            {
                int idx=-1;
                if(!parity)
                {
                  idx=(right+1)%n;
                }
                else
                {
                    idx=(left-1+n)%n;
                }
                ans[idx]=sum;
            }
        }


        return ans;

        
    }
}