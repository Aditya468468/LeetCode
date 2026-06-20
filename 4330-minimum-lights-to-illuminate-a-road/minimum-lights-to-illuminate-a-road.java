class Solution {
    public int minLights(int[] lights) 
    {
        int n=lights.length;
        boolean []glow=new boolean[n];
        //Lets just get an Interval which is illuminated.
        List<int[]> intervals=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(lights[i]!=0)
            {
                int v=lights[i];
                int left=Math.max(0,i-v);
                int right=Math.min(n-1,i+v);
                intervals.add(new int[]{left,right});
            }
        }
        intervals.sort((a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[]interval:intervals) {
            if (merged.isEmpty()||merged.get(merged.size()-1)[1]<interval[0]) {
                merged.add(interval);
            } else {
                // Overlap found, update the end boundary of the last interval
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        //Now I have an array glow which tells glow lights 
        int addCnt=0;
        int next=0;
        for(int[]interval:merged)
        {
            if(interval[0]>next)
            {
                int len=interval[0]-next;
                addCnt+=(len+2)/3;
            }
            next=interval[1]+1;
        }
        if (next<n) {
            int len=n-next;
            addCnt+=(len+2)/3;
        }

        return addCnt;
        

            
    }
}