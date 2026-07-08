class Solution {
    public int minBitFlips(int start, int goal) 
    {
        int z=start^goal;
        int cnt=0; 
        while(z!=0) // count set bits 
        {
            cnt+=z&1;
            z=z>>1;
        }   

        return cnt;
        
    }
}

        
    