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

    public int check(int row,List<StringBuilder> board)
    {
        if(row==board.size())
        {
           
            return 1;
        }
        int cnt=0;
        for(int col=0;col<board.size();col++)
        {
            if(isPossible(row,col,board))
            {
                 board.get(row).setCharAt(col,'Q');
                cnt+=check(row+1,board);
                board.get(row).setCharAt(col,'.'); //backtrack

            }
        }

        return cnt;
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

        return check(0,board);




        
    
    }
}