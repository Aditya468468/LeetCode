class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        HashMap<Integer,Set<Integer>> row=new HashMap<>();
        HashMap<Integer,Set<Integer>> col=new HashMap<>();
        HashMap<Integer,Set<Integer>> grid=new HashMap<>();
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='.') continue;
                int num=board[i][j]-'0';
                if(row.containsKey(i) && row.get(i).contains(num)) return false;
                if(col.containsKey(j) && col.get(j).contains(num)) return false;
                int gridNo=(i/3)*3 + j/3;
                if(grid.containsKey(gridNo) && grid.get(gridNo).contains(num))
                {
                    return false;
                }
                if(!row.containsKey(i))
                {
                    row.put(i,new HashSet<>());    
                }
                if(!col.containsKey(j))
                {
                    col.put(j,new HashSet<>());    
                }
                if(!grid.containsKey(gridNo))
                {
                    grid.put(gridNo,new HashSet<>());    
                }
                row.get(i).add(num);
                col.get(j).add(num);
                grid.get(gridNo).add(num);
                
            }
        }

        
        return true;

    }
}