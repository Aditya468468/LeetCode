class Solution {
    public boolean isValidSudoku(char[][] board) 
    {
        HashMap<Integer,Set<Character>> rows=new HashMap<>();
        HashMap<Integer,Set<Character>> cols=new HashMap<>();
        HashMap<List<Integer>,Integer> gridMap=new HashMap<>();
        HashMap<Integer,Set<Character>> grid=new HashMap<>();
        gridMap.put(List.of(0,0),1);
        gridMap.put(List.of(0,1),2);
        gridMap.put(List.of(0,2),3);
        gridMap.put(List.of(1,0),4);
        gridMap.put(List.of(1,1),5);
        gridMap.put(List.of(1,2),6);
        gridMap.put(List.of(2,0),7);
        gridMap.put(List.of(2,1),8);
        gridMap.put(List.of(2,2),9);
        
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
                int gridRow=i/3;
                int gridCols=j/3;
                List<Integer> list=new ArrayList<>(List.of(gridRow,gridCols));
                int gridNo=gridMap.get(list);
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