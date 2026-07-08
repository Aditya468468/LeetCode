class Solution {
    public int findComplement(int num) 
    {
        int mask=0;
        int temp=num;
        while(temp!=0)
        {
            mask=(mask<<1) | 1;// set bits.
            temp=temp>>1; // Drop the bits.
        }

        return mask^num;  // Toggle the bits

        
    }
}