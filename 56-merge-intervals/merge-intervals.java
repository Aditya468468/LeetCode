class Solution {
    public int[][] merge(int[][] intervals) 
    {
        int n=intervals.length;
        List<int[]> list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->
        {
            if(a[0]!=b[0])
            {
                return a[0]-b[0];
            }
            else
            {
                return a[1]-b[1];
            }

        });
        list.add(intervals[0]);
        for(int i=0;i<n;i++)
        {
            if(!list.isEmpty() && list.get(list.size()-1)[1]<intervals[i][0])
            {
                list.add(intervals[i]);
            }
            else
            {
                list.get(list.size()-1)[1]=Math.max(intervals[i][1],list.get(list.size()-1)[1]);
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