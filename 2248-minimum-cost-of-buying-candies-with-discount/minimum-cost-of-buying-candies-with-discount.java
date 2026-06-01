class Solution {
    public int minimumCost(int[] cost) 
    {
        int n=cost.length;
        int totalCost=0;
        Arrays.sort(cost);
        if(n==1) return cost[0];
        if(n==2) return cost[0]+cost[1]; // Handled the Edge cases.
        for(int i=n-1;i>=0;i-=3)
        {
            totalCost+=(cost[i]);
            if(i-1>=0) totalCost+=cost[i-1];
        }

        return totalCost;
        
    }
}