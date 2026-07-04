class Solution {
    public boolean isPerfectSquare(int num) 
    {
        long low=1;
        long high=num;
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(1L*mid*mid==num) return true;
            if(1L*mid*mid<num) low=mid+1;
            else high=mid-1;
        }

        return false;

        
    }
}