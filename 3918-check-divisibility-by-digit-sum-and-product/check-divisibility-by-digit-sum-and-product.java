class Solution {
    public boolean checkDivisibility(int n) 
    {
        long product=1;
        long sum=0;
        int temp=n;
        while(temp>0)
        {
            int ld=temp%10;
            sum+=ld;
            product*=ld;
            temp/=10;
        }

        return n%(sum+product)==0;

        
    }
}