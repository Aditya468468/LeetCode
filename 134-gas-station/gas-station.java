class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int n=gas.length;
        int start=0;
        int totalFuel=0;
        int travelled=0;

        for(int i=0;i<2*n;i++)
        {
            totalFuel+=gas[i%n];
            if(totalFuel<cost[i%n]) // We cant go to next
            {
                start=(i+1)%n;
                totalFuel=0;
                travelled=0;
            }
            else
            {
                totalFuel-=cost[i%n];
                travelled++;
            }
            if(travelled==n) return start;
           
        }

        return -1;
        
    }
}