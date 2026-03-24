class Solution {
    public int[][] constructProductMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int size = n * m;
        int mod = 12345;

        int[] arr = new int[size];

        // flatten
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i * m + j] = grid[i][j];
            }
        }

        int[] prefix = new int[size];
        int[] suffix = new int[size];

        // prefix
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = (int)((long)prefix[i - 1] * arr[i - 1] % mod);
        }

        // suffix
        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (int)((long)suffix[i + 1] * arr[i + 1] % mod);
        }

        // build answer
        int[][] ans = new int[n][m];

        for (int i = 0; i < size; i++) {
            int val = (int)((long)prefix[i] * suffix[i] % mod);
            ans[i / m][i % m] = val;
        }

        return ans;
    }
}