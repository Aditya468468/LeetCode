class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int tank=0;
        int n=gas.length;
        int start=0;
        int travelled=0;

        for(int i=0;i<2*n;i++) //Lets see we can complete a circuit or not.
        {
            tank+=(gas[i%n]-cost[i%n]);
            if(tank<0)
            {
                start=(i+1)%n;
                travelled=0;
                tank=0;
            }
            else 
            {
                travelled++;
            }
            if(travelled==n)
            {
                return start;
            }

        }

        return -1;

        
    }
}