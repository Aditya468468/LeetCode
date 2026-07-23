class Solution {
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        int n=intervals.length;
       
        Arrays.sort(intervals,(a,b)->
        {
            return a[1]-b[1]; // Sort by end time,We keep max Non-overlaps,
            //what get erase is the conflicting overlaps
        });

        int lastEnd=intervals[0][1]; // Finishes the earliest
        int cnt=1;
        for(int i=1;i<n;i++)
        {
            if(lastEnd<=intervals[i][0])
            {
                cnt++; // Non overlaps
                lastEnd=intervals[i][1]; // Next candidate
            }
        }

        return n-cnt; // Total-Non-overlaps=Overlapped
        

        
    }
}