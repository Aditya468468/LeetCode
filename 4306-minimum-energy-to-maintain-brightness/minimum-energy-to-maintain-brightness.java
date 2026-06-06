class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) 
    {
        if(intervals.length==0) return 0;
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
        ArrayList<int[]> list=new ArrayList<>(); 
        //Lets Merge The Intervals.
        for(int i=0;i<intervals.length;i++)
        {
            if(list.isEmpty()) 
            {
                list.add(intervals[i]);
            }
           else if(list.get(list.size()-1)[1]<intervals[i][0])
            {
                list.add(intervals[i]);
            }
            else
            {
                list.get(list.size()-1)[1]=Math.max(intervals[i][1],list.get(list.size()-1)[1]);
            }
        }//Here Intervals are merged.

        //Now lets See, Total Num of Bulbs needed to get brightness
        int total=0;
        int needed=(brightness+2)/3; //Ceil Value.
        if(n%3==0)
        {
            total=n/3;
        }
        else
        {
            total=n/3+1;
        } //Total illumination-> Turning all On using Min Bulds.
        if(needed>total) return -1;
        if(needed<total) total=needed; //Buld needed.
        long min =0;
        for(int i=0;i<list.size();i++)
        {
            int start=list.get(i)[0];
            int end=list.get(i)[1];
            long inter=end-start+1;
            min+=(1L)*(inter)*total;
        }
       
       return min;

        
    }
}