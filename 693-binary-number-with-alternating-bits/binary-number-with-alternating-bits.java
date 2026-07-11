class Solution {
    public boolean hasAlternatingBits(int n) 
    {
        boolean isSetBit = ((n&1)==1);
        n=n>>1;
    
        while(n!=0)
        {
            if(isSetBit)
            {
                if((n&1)!=0) return false;
                isSetBit=false;
            }
            else if(!isSetBit)
            {
                if((n&1)==0) return false;
                isSetBit=true;
            }
            n=n>>1;
        }

        return true;
        
        
    }
}