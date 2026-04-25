class Solution {

    public boolean isPossible(int row,int col,List<StringBuilder> board)
    {
        int r=row;
        int c=col;
        //top
        while(r>=0)
        {
            if(board.get(r).charAt(c)=='Q') return false;
            r--;
        }
        r=row;
        c=col;
        //left
        while(r>=0 && c>=0)
        {
            if(board.get(r).charAt(c)=='Q') return false;
            r--;
            c--;
        }
        //right
        r=row;
        c=col;
         while(r>=0 && c<board.get(r).length())
        {
            if(board.get(r).charAt(c)=='Q') return false;
            r--;
            c++;
        }

        return true;


    }

    public void check(int row,List<StringBuilder> board,List<List<String>> ans)
    {
        if(row==board.size())
        {
            List<String> temp = new ArrayList<>();
            for (StringBuilder sb : board) 
            {
                temp.add(sb.toString());
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int col=0;col<board.size();col++)
        {
            if(isPossible(row,col,board))
            {
                board.get(row).setCharAt(col,'Q');
                check(row+1,board,ans);
                board.get(row).setCharAt(col,'.'); //backtrack

            }
        }
    }
    public int totalNQueens(int n) 
    {
        List<StringBuilder> board=new ArrayList<>();

        //Fill board
        for(int i=0;i<n;i++)
        {
            StringBuilder str=new StringBuilder();
            for(int j=0;j<n;j++)
            {
                str.append('.');
            }
            board.add(str);
        }
        List<List<String>> ans=new ArrayList<>();
        check(0,board,ans);


    
        return ans.size();

        
    
    }
}