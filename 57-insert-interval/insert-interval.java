class Solution 
{
    public int insertPos(int[][]intervals,int[]newInterval)
    {
        int startTime=newInterval[0];
        int low=0;
        int high=intervals.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(intervals[mid][0]<=startTime)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return low;

    }
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {

        int pos=insertPos(intervals,newInterval);
        ArrayList<int[]> intervalsList=new ArrayList<>();
        for(int []x:intervals)
        {
            intervalsList.add(x);
        }

        intervalsList.add(pos,newInterval);

        //Now just start merging.
        ArrayList<int[]> list=new ArrayList<>();
        list.add(intervalsList.get(0));

        for(int i=1;i<intervalsList.size();i++)
        {
            int[]prevInterval=list.get(list.size()-1);
            
            if(prevInterval[1]>=intervalsList.get(i)[0])
            {
                prevInterval[1]=Math.max(prevInterval[1],intervalsList.get(i)[1]);
            }
            else
            {
                list.add(intervalsList.get(i));
            }

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