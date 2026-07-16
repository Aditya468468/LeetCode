class Solution {
    public int[][] merge(int[][] intervals) 
    {
        int n=intervals.length;
        if(n==1) return intervals;
        ArrayList<int[]> list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->
        {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        //Non-overlap cond-> a.endTime<b.startTime
        //OverLap--> ~(Non-overlap)--> a.endTime>=b.startTime
        list.add(intervals[0]); //Soo i can have a prev interval.
        
        for(int i=1;i<n;i++)
        {
            int[] prevInterval=list.get(list.size()-1);
            if(prevInterval[1]>=intervals[i][0])
            {
                prevInterval[1]=Math.max(intervals[i][1],prevInterval[1]); // Update the endPoint

            }
            else // Non overlap, Add it 
            {
                list.add(intervals[i]);
            }

        }

        int [][]result=new int[list.size()][2];
        for(int i=0;i<list.size();i++)
        {
            result[i]=list.get(i);
        }
        
        return result;


    }
}