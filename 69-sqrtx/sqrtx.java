class Solution 
{

    public int mySqrt(int x) 
    {
        long low=0;
        long high=x;
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            long val=mid*mid;
            if(val==x) return (int)mid;
            else if(val<x) low=mid+1;
            else high=mid-1;
        }

        return (int)high;
        
        
    }
}