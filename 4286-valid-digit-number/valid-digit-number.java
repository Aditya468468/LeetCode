class Solution {
    public boolean validDigit(int n, int x) 
    {
       int ld=-1;
       boolean valid=false;
       while(n!=0)
       {
            ld=n%10;
            if(!valid && ld==x)
            {
                valid=true;
            }
            n/=10;
       }
        return valid && ld!=x;
        
        
    }
}