class Solution 
{
    private boolean isValid(char[][] board,int row,int cols,char digit)
    {
        //row check.
        for(int i=0;i<9;i++)
        {
            if(board[i][cols]==digit) return false;
        }
        //col 
        for(int i=0;i<9;i++)
        {
            if(board[row][i]==digit) return false;
        }
        //grid.
        int startRow=(row/3)*3;
        int startCol=(cols/3)*3;
        for(int i=startRow;i<startRow+3;i++)
        {
            for(int j=startCol;j<startCol+3;j++)
            {
                if(board[i][j]==digit) return false;
            }
        }

        return true;
    }
    private boolean check(char[][]board)
    {
    
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    for(char x='1';x<='9';x++)
                    {
                        if(isValid(board,i,j,x))
                        {
                            board[i][j]=x;
                            if(check(board)) return true;
                            else board[i][j]='.';
                        }
                    }
                
                return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) 
    {
         check(board);
        
    }
}