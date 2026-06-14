class Solution 
{
    private boolean explore(int idx,char[][]board,String word,boolean[][]visited,int i,int j)
    {
        int n=board.length;
        int m=board[0].length;
        if(i<0 || i>=n || j<0 || j>=m) return false;
        if(visited[i][j]) return false;
        if(board[i][j]!=word.charAt(idx)) return false;
        if(idx==word.length()-1) return true; // String Matched.
        visited[i][j]=true;
        boolean find=(explore(idx+1,board,word,visited,i-1,j) ||
                        explore(idx+1,board,word,visited,i+1,j) ||
                        explore(idx+1,board,word,visited,i,j-1) ||
                        explore(idx+1,board,word,visited,i,j+1));
        if(find) return true;
        //Back track.
        visited[i][j]=false;

        return false;

    }
    public boolean exist(char[][] board, String word) 
    {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]!=word.charAt(0)) continue;
                if(explore(0,board,word,new boolean[n][m],i,j))
                {
                    return true;
                }
            }
        }
       return false;
    }
}