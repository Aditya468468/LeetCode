class Solution {
    public boolean isValidSudoku(char[][] board) 
    {
        HashMap<Integer,Set<Character>> rows=new HashMap<>();
        HashMap<Integer,Set<Character>> cols=new HashMap<>();
        HashMap<Integer,Set<Character>> grid=new HashMap<>();
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
    
                char c=board[i][j];
                if(c=='.') continue;
                if(rows.containsKey(i) && rows.get(i).contains(c)) return false;
                if(cols.containsKey(j) && cols.get(j).contains(c)) return false;
                // i need grid num.
                
                int gridNo = (i/3)*3 + (j/3);;
                if(grid.containsKey(gridNo) &&grid.get(gridNo).contains(c)) return false;
                //Put them
                if(!rows.containsKey(i)) rows.put(i,new HashSet<>());
                if(!cols.containsKey(j)) cols.put(j,new HashSet<>());
                if(!grid.containsKey(gridNo)) grid.put(gridNo,new HashSet<>());
                rows.get(i).add(c);
                cols.get(j).add(c);
                grid.get(gridNo).add(c);


            }

        }

        return true;
        
    }
}