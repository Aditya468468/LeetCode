class Solution 
{
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {
        List<int[]> list=new ArrayList<>();
        int i=0;
        int n=intervals.length;

        while(i<n && intervals[i][1]<newInterval[0]) // The Left Halve -> Non-Overlap
        {
            list.add(intervals[i]);
            i++;
        }
        //Merge-> Middle Halve which overlaps
        while(i<n && intervals[i][0]<=newInterval[1])
        {
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            i++;
        }
        list.add(newInterval); // Add the Merged Interval

        while(i<n) // Add The Rest Right Halve
        { 
            list.add(intervals[i]);
            i++;

        }
        // Remember we can do this because ques says we Already Have Non-overlapping
        // intervals, Only adding newInterval may cause Ovelaps.
        
        int[][] ans=new int[list.size()][2];
        int idx=0;
        for(int[] x:list)
        {
            ans[idx++]=x;
        }

        return ans;




        
    }
}