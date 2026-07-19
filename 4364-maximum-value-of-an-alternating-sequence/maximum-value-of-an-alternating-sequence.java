class Solution {
    public long maximumValue(int n, int s, int m) 
    {
        if(n==1) return s;
        long a=s+m;
        if(n==2) return a;
        long cd=m-1;
        long nTerm=n/2;
        return a+(nTerm-1)*cd;
        
    }
}