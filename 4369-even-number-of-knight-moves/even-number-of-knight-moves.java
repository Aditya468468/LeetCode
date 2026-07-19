class Solution {

    int[][] dir = {
        {-2, -1}, {-2, 1},
        {-1, -2}, {-1, 2},
        { 1, -2}, { 1, 2},
        { 2, -1}, { 2, 1}
    };

    boolean[][][] visited = new boolean[8][8][2];
    int targetX,targetY;

    private boolean dfs(int i, int j, int moves) {

        // Out of board
        if (i<0 || i>= 8 || j<0 || j>= 8)
            return false;

        if (visited[i][j][moves%2])
            return false;

        visited[i][j][moves%2] = true;

        if (i==targetX && j==targetY) return moves%2==0; // We reached with even.

        for (int[] d : dir) 
        {
            int ni=i+d[0];
            int nj=j+d[1];

            if (dfs(ni,nj,moves+1)) return true;
        }

        return false;
    }

    public boolean canReach(int[] start, int[] target) 
    {
        targetX=target[0];
        targetY=target[1];
        return dfs(start[0], start[1], 0);
    }

    
}