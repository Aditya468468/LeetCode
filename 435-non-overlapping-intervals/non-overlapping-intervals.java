class Solution {
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        int n=intervals.length;
        //Need to calculate overlap intervals.
        Arrays.sort(intervals,(a,b)->
        {
            return a[0]-b[0]; // Sort by start time, Sequential check
        });
        
        int cnt=0; // Counts Overlaps
        int lastEnd=intervals[0][1];
        for(int i=1;i<n;i++)
        {
            if(lastEnd<=intervals[i][0])
            {
                lastEnd=intervals[i][1];
            }
            else
            {
                cnt++; //overlap
                lastEnd=Math.min(intervals[i][1],lastEnd);
            }
        }

        return cnt;


        
    }
}