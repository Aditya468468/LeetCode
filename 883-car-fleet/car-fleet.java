class Solution {
    private class Pair
    {
        int pos;
        double time;
        
        public Pair(int pos,double time)
        {
            this.pos=pos;
            this.time=time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) 
    {
        int n=position.length;
        Pair[] nums=new Pair[n];
        for(int i=0;i<n;i++)
        {
            int pos=position[i];
            double time=(double)(target-pos)/speed[i];
            nums[i]=new Pair(pos,time);
        }
        Arrays.sort(nums,(a,b)->
        {
            return b.pos-a.pos;
        });
        // Lets See fleets.
        double prevTime=0;
        int fleet=0;
        for(int i=0;i<n;i++)
        {
            double current=nums[i].time;
            if(current>prevTime)
            {
                fleet++;
                prevTime=current;

            }
        }

        return fleet;
        
    }
}

