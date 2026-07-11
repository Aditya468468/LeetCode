class Solution {
    public int minFlips(int a, int b, int c) 
    {
        int flips=0;

        while((a|b)!=c)
        {
            int bitC=(c&(1));
            int bitA=(a&1);
            int bitB=(b&1);
            if(bitC==1)
            {
                if(bitA!=1 && bitB!=1) // We need 1, soo turing any bit On is fine.
                {
                    flips++;
                }
            }
            else if(bitC==0)
            {
                if(bitA==1 && bitB==1) // 1 | 1 =1 soo need to turn both off
                {
                    flips=flips+2;
                }
                else if(bitA==1 && bitB==0) // 1|0-> turn one bit off
                {
                    flips++;
                }
                else if(bitA==0 && bitB==1) // same 
                {
                    flips++;
                }
            }
            a=a>>1;
            b=b>>1;
            c=c>>1;
        }

        return flips;
        
    }
}