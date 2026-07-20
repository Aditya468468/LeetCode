class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        int n = grid.size();
        int m = grid[0].size();
        int L = n * m;
        k = k % L;

        vector<vector<int>> result(n, vector<int>(m, 0));

        for (int i = 0; i < L; i++) {
            int pivot = grid[i / m][i % m];
            int newIdx = (i + k) % L;
            result[newIdx / m][newIdx % m] = pivot;
        }

        return result;
    }
};