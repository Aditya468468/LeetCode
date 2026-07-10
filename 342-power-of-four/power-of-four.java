class Solution {
    public boolean isPowerOfFour(int n) 
    {
        int mask=0b01010101010101010101010101010101;

        if((n&(n-1))==0 && (n&mask)!=0) return true;
        // Only 1 set Bit and that too at even exp of 2.

        return false;


        
    }
}