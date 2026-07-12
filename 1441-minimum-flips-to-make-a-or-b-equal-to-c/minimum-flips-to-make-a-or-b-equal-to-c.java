class Solution {
    public int minFlips(int a, int b, int c) 
    {
        int minFlips=0;
        while((a|b)!=c)
        {
            int bitA=(a&1);
            int bitB=(b&1);
            int bitC=(c&1); //These Tells, does that bit, it 0 or 1 

            //Lets process
            if(bitC==1) //Turn Any One Bit 1
            {
                if(bitA!=1 && bitB!=1) minFlips+=1;
            }
            else if(bitC==0) // Turn both Bit 0.
            {
                if(bitA==1 && bitB==1) minFlips+=2; // need to turn off 2
                else if(bitA==1 && bitB==0) minFlips+=1; // Need to turn 1
                else if(bitA==0 && bitB==1) minFlips+=1; // Need to turn 1
            }
            a=a>>1;
            b=b>>1;
            c=c>>1;  // Drop bits.
        }

        return minFlips;
        
    }
}