class Solution {
    public int minCost(int n) 
    {
        int cost=0;
        while(n!=1)
        {
            int x=1;
            int y=(n-1);
            cost+=(x*y);
            n=y;
        }

        return cost;
        
    }
}