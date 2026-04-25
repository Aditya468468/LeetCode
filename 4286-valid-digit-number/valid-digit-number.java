class Solution {
    public boolean validDigit(int n, int x) 
    {
        int digits=(int)Math.log10(n);
        int first=(int)(n / Math.pow(10, digits));
        if(first==x) return false;

       boolean valid=false;
       while(n!=0)
       {
            int ld=n%10;
            if(!valid && ld==x)
            {
                valid=true;
            }
            n/=10;
       }
        return valid;
        
        
    }
}