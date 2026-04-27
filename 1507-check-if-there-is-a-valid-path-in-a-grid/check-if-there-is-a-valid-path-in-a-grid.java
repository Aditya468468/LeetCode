import java.util.*;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Map<Integer, int[][]> map = new HashMap<>();
        map.put(1, new int[][]{{0,1},{0,-1}});
        map.put(2, new int[][]{{1,0},{-1,0}});
        map.put(3, new int[][]{{0,-1},{1,0}});
        map.put(4, new int[][]{{0,1},{1,0}});
        map.put(5, new int[][]{{0,-1},{-1,0}});
        map.put(6, new int[][]{{0,1},{-1,0}});

        boolean[][] visited = new boolean[m][n];

        return dfs(0, 0, grid, visited, map);
    }

    private boolean dfs(int r, int c, int[][] grid, boolean[][] visited,
                        Map<Integer, int[][]> map) {

        int m = grid.length, n = grid[0].length;

        if (r == m - 1 && c == n - 1) return true;

        visited[r][c] = true;

        for (int[] d : map.get(grid[r][c])) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc]) continue;

            // 🔁 reverse connection check
            for (int[] back : map.get(grid[nr][nc])) {
                if (nr + back[0] == r && nc + back[1] == c) {
                    if (dfs(nr, nc, grid, visited, map)) return true;
                }
            }
        }

        return false;
    }
}