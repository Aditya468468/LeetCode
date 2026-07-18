class Solution {
    public int[][] merge(int[][] intervals) 
    {
        Arrays.sort(intervals,(a,b)->
        {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });

        List<int[]> list=new ArrayList<>();
        list.add(intervals[0]);

        for(int i=1;i<intervals.length;i++)
        {
            int []prevInterval=list.get(list.size()-1);
            if(prevInterval[1]>=intervals[i][0])
            {
                prevInterval[1]=Math.max(intervals[i][1],prevInterval[1]);
            }
            else
            {
                list.add(intervals[i]);
            }
        }

        int[][] ans = new int[list.size()][2];
        int idx=0;
        for(int[] x:list)
        {
            ans[idx++]=x;
        } 

        return ans;
        
        
    }
}