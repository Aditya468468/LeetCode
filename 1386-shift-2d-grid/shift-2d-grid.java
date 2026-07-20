class Solution 
{

    public List<List<Integer>> shiftGrid(int[][] grid, int k) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int L=n*m;
        k=k%L;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<m;j++)
            {
                temp.add(0);
            }
            list.add(temp);
        }

        for(int i=0;i<n*m;i++)
        {
            int pivot=grid[i/m][i%m];
            int newIdx=(i+k)%L;
            List<Integer> temp=list.get(newIdx/m);
            temp.set(newIdx%m,pivot);
        }

      
        return list;

        
    }
}