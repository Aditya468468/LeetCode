class Solution {
    private boolean search(int idx,char[][]board,int i,int j,String word)
    {
        if(board[i][j]!=word.charAt(idx) || board[i][j]=='#') return false;
        if(idx==word.length()-1)
        {
            return true;
        }
        //if(board[i][j]!=word.charAt(idx) || board[i][j]=='#') return false;
        //Lets take calls to 4-direction.
        int n=board.length;
        int m=board[0].length;
        char temp=board[i][j];
        board[i][j]='#'; // used.
        boolean ans=false;
        //top
        boolean top;
        if(i-1>=0) top=search(idx+1,board,i-1,j,word); else top=false;
        boolean down;
        if(i+1<n) down=search(idx+1,board,i+1,j,word); else down=false;
        boolean left;
        if(j-1>=0) left=search(idx+1,board,i,j-1,word); else left=false;
        boolean right;
        if(j+1<m) right=search(idx+1,board,i,j+1,word); else right=false;

        ans=(top || down || left || right);
        board[i][j]=temp; //back-track;

        return ans;


    }
    public boolean exist(char[][] board, String word) 
    {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(search(0,board,i,j,word)) return true;
                }
            }
        }

        return false;
        
    }
}