class Solution 
{
    public int find(int[][]series,int t)
    {
        int low=0;
        int high=series.length-1;
        while(low<=high)
            {
                int mid=low+(high-low)/2;
                if(series[mid][0]<t)
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
    
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) 
    {
       List<List<Integer>> ans=new ArrayList<>();
        int i=0;
        int j=0;
        int n=series1.length;
        int m=series2.length;
        while(i<n && j<m)
            {
                
                if(series1[i][0]==series2[j][0])
                {
                         List<Integer> temp=new ArrayList<>();
                        temp.add(series1[i][0]);
                        temp.add(series1[i][1]+series2[j][1]);
                        ans.add(temp);
                        i++;
                        j++;
                }
               else if(series1[i][0]<series2[j][0])
                {
                    int idx=find(series2,series1[i][0]);
                    if(idx<m)
                    {
                        List<Integer> temp=new ArrayList<>();
                        temp.add(series1[i][0]);
                        temp.add(series1[i][1]+series2[idx][1]);
                        ans.add(temp);
                    }
                    i++;
                }
                else
                {
                    int idx=find(series1,series2[j][0]);
                    if(idx<n)
                    {
                        List<Integer> temp=new ArrayList<>();
                        temp.add(series2[j][0]);
                        temp.add(series2[j][1]+series1[idx][1]);
                        ans.add(temp);
                    }
                    j++;
                }
                
            }
        while(i<n)
        {
            List<Integer> temp=new ArrayList<>();
            temp.add(series1[i][0]);
            temp.add(series1[i][1]);
            ans.add(temp);
            i++;
            
        }
        while(j<m)
        {
            List<Integer> temp=new ArrayList<>();
            temp.add(series2[j][0]);
            temp.add(series2[j][1]);
            ans.add(temp);
            j++;
            
        }

        return ans;
        
        
    }
}