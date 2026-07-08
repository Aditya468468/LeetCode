class Solution {
    public boolean isPowerOfFour(int n) 
    {
        if(n<=0) return false;
        int mask=0b01010101010101010101010101010101;
        if((n&(n-1))==0 && (n&mask) != 0) return true;
        return false;
        
    }
}