class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {
        // Now comes the fun....
        //Decompose it:- left + overlaps +right , as left and right are already non overlapping, We can safely put them as it is,Only issue is the overlaps,lets just fix it.By mergeing

        List<int[]> list=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        //Left-> left finishes before newInterval starts
        while(i<n && intervals[i][1]<newInterval[0]) 
        {
            list.add(intervals[i]);
            i++;
        }
        // Middle->newIntervals is still didnt finish and intervals starts so we merege them.
        while(i<n && newInterval[1]>=intervals[i][0])
        {
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]); 
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            // Imp need to check start and end both--> [1,3], [2,5]
            i++;
        }
        list.add(newInterval); // add the merege portion
        while(i<n) // Left over Right part is Non-overlap only put them to ans
        {
            list.add(intervals[i]);
            i++;
        }

        int[][] ans=new int[list.size()][2];
        int idx=0;
        for(int[] x:list)
        {
            ans[idx++]=x;
        }

        return ans;


        

        
    }
}