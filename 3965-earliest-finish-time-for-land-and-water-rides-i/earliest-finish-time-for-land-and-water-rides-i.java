class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) 
    {
        //Land and then Water
        int minTime=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++)
        {
            int start_t=landStartTime[i];
            int duration=landDuration[i];
            int totalTime=start_t+duration;
            for(int j=0;j<waterStartTime.length;j++)
            {
                int timeCurr=totalTime;
                if(waterStartTime[j]>timeCurr)
                {
                    timeCurr+=(waterStartTime[j]-timeCurr); // Soo  Ride can start.
                }
                timeCurr+=waterDuration[j];
                if(timeCurr<minTime)
                {
                    minTime=timeCurr;
                }
            }
            
        }
        //Water then Land
        for(int i=0;i<waterStartTime.length;i++)
        {
            int start_t=waterStartTime[i];
            int duration=waterDuration[i];
            int totalTime=start_t+duration;
            for(int j=0;j<landStartTime.length;j++)
            {
                int timeCurr=totalTime;
                if(landStartTime[j]>timeCurr)
                {
                    timeCurr+=(landStartTime[j]-timeCurr); // Soo  Ride can start.
                }
                timeCurr+=landDuration[j];
                if(timeCurr<minTime)
                {
                    minTime=timeCurr;
                }
            }
            
        }

        return minTime;
        
    }
}