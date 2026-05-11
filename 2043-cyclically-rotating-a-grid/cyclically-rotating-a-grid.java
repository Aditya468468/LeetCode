class Solution 
{
    private void fill(int[][]grid,List<Integer> list,int top,int bottom,int left,int right)
    {
            int idx=0;

            for(int i=left;i<=right;i++)
            {
                grid[top][i]=list.get(idx++);
            }
            top++;
            for(int i=top;i<=bottom;i++)
            {
               grid[i][right]=list.get(idx++);
            }
            right--;
            for(int i=right;i>=left;i--)
            {
                   grid[bottom][i]=list.get(idx++);
            }
            bottom--;
            for(int i=bottom;i>=top;i--)
            {
                grid[i][left]=list.get(idx++);
            }
            left++;
    
    }
    private void helper(List<Integer> list,int i,int j)
    {
        while(i<j)
        {
            int temp=list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
    }
    private void rotate(List<Integer> list,int k)
    {
        int n=list.size();
        k=k%n;
        helper(list,0,n-1);
        helper(list,0,n-k-1);
        helper(list,n-k,n-1);
        
    }
    public int[][] rotateGrid(int[][] grid, int k) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=m-1;
        
        while(top<bottom && left<right)
        {
            int t=top;
            int b=bottom;
            int r=right;
            int l=left;
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=left;i<=right;i++)
            {
                list.add(grid[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++)
            {
                list.add(grid[i][right]);
            }
            right--;
            
            
                for(int i=right;i>=left;i--)
                {
                    list.add(grid[bottom][i]);
                }
                bottom--;
            
            
            
                for(int i=bottom;i>=top;i--)
                {
                    list.add(grid[i][left]);
                }
                left++;
            

            rotate(list,k);
            fill(grid,list,t,b,l,r);

        }
        

        return grid;
    }
}