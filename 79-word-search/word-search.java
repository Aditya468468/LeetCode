class Solution 
{
    public boolean search(int idx,String word,char[][]board,int i,int j, boolean[][]visited)
    {
        int n=board.length;
        int m=board[0].length;
        if(i<0 || i>=n || j<0 || j>=m) return false;
        if(visited[i][j]==true || board[i][j]!=word.charAt(idx)) return false;
        if(idx==word.length()-1)
        {
            return true;
        }

        visited[i][j]=true;

        if(j-1>=0) if(search(idx+1,word,board,i,j-1,visited)) return true;
        if(j+1<m)  if (search(idx+1,word,board,i,j+1,visited)) return true;
        if(i-1>=0) if(search(idx+1,word,board,i-1,j,visited)) return true;
        if(i+1<n)  if(search(idx+1,word,board,i+1,j,visited)) return true;
        //Backtrack.
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
            if(search(0,word,board,i,j,new boolean[n][m])) return true;

        }
        }
        return false;
    }
}