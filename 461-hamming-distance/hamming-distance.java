class Solution {
    public int hammingDistance(int x, int y) 
    {
        int z=x^y;
        int cnt=0;
        while(z!=0)
        {
            cnt+=z&1;
            z=z>>1;
        }   

        return cnt;
        
    }
}