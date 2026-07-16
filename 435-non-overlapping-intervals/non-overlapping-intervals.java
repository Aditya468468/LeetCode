
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        
        Arrays.sort(intervals,(a,b)->
        {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int cnt=0;
        int endTime=intervals[0][1];
        for(int i=1;i<intervals.length;i++)
        {
            if(endTime<=intervals[i][0])
            {
                endTime=intervals[i][1]; //Non over-lapping
            }
            else 
            {
                cnt++;
                endTime=Math.min(intervals[i][1],endTime);
            }
        }

        return cnt;
       
    }
}