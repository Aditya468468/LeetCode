class Solution {
    public int minBitFlips(int start, int goal) 
    {
        //Lets see how many bits they diff by
        int num = start^goal;
        //Lets calculate the num of set bits.
        int cnt=0;
        while(num!=0)
        {
            num=num&(num-1);
            cnt++;
        }

        return cnt;
        
    }
}