class Solution {
    public boolean canPlaceFlowers(int[] seats, int n) 
    {
        for(int i=1;i<seats.length;i++)
        {
            if(seats[i] == 1 && seats[i-1] == 1)
            {
                return false;
             }
        } //Checking Validity 
        
        if(n==0) return true;
        int canSit=0;
        for(int i=0;i<seats.length;i++)
        {
        
            if(seats[i]==1) continue;
            int right=0;
            if(i<seats.length-1)
            {
                right=seats[i+1];
            }
            int left=0;
            if(i>0)
            {
                left=seats[i-1];
            }
            if(left==0 && right==0)
            {
                seats[i]=1;
                canSit++;
            }
            if(canSit>=n) return true;
        }
        
        return false;
        
    }
}