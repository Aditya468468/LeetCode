class Solution 
{

    public List<List<Integer>> shiftGrid(int[][] grid, int k) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int total=n*m;
        k=k%total;

        while(k!=0)
        {
            for(int j=m-1;j>0;j--)
            {
                for(int i=0;i<n;i++)
                {
                    //swap
                    int temp=grid[i][j-1];
                    grid[i][j-1]=grid[i][j];
                    grid[i][j]=temp;
                }

            }
            //RIGHT Shift 1st cols
            int last=grid[n-1][0];
            for (int i=n-1;i>0;i--) 
            {
                grid[i][0]=grid[i - 1][0];
            }
            grid[0][0]=last;
            k--;
        }
    

        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<m;j++)
            {
                temp.add(grid[i][j]);

            }
            list.add(temp);
        }


        return list;

        
    }
}