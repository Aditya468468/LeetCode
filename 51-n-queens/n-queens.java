class Solution 
{
    private boolean isPossible(char [][]board,int x,int y)
    {
        //Col.
        int m=board.length;
        int n=m;
        for(int i=x-1;i>=0;i--)
        {
            if(board[i][y]=='Q') return false;
        }
        //Col.
        // for(int i=0;i<m;i++)
        // {
        //     if(i==y) continue;
        //     if(board[x][i]=='Q') return false;
        // }
        int r=x-1;
        int c=y-1;
        //Anti
        while(r>=0 && c>=0)
        {
            if(board[r][c]=='Q') return false;
            c--;
            r--;
        }
         r=x-1;
         c=y+1;
        // Diag
        while(r>=0 && c<m)
        {
            if(board[r][c]=='Q') return false;
            c++;
            r--;
        }

        return true;
    }
    public void explore(int row,char[][]board,List<List<String>> ans,List<String> list)
    {
        int n=board.length;
        if(list.size()==board.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(row>=n) return; // row-Boundary.
        for(int i=0;i<n;i++) //Loop will ensure col Boundary
        {
            if(isPossible(board,row,i))
            {
                board[row][i]='Q';
                StringBuilder str=new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(j==i) str.append('Q');
                    else str.append('.');
                }
                list.add(str.toString());
                explore(row+1,board,ans,list);
                list.remove(list.size()-1);
                board[row][i]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) 
    {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        } // board is ready.
        List<List<String>> ans=new ArrayList<>();
        explore(0,board,ans,new ArrayList<>());
        
        return ans;
        
    }
}