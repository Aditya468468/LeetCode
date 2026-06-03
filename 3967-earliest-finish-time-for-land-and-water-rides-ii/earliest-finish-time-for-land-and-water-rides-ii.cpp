class Solution {
public:
    long long solveOrder(vector<int>& s1, vector<int>& d1,
                         vector<int>& s2, vector<int>& d2) {
        int m = s2.size();

        vector<pair<int,int>> rides;
        for (int i = 0; i < m; i++) {
            rides.push_back({s2[i], d2[i]});
        }

        sort(rides.begin(), rides.end());

        vector<int> start(m);
        vector<long long> prefDur(m);
        vector<long long> suffFinish(m);

        for (int i = 0; i < m; i++) {
            start[i] = rides[i].first;
        }

        prefDur[0] = rides[0].second;
        for (int i = 1; i < m; i++) {
            prefDur[i] = min(prefDur[i - 1],
                             (long long)rides[i].second);
        }

        suffFinish[m - 1] =
            (long long)rides[m - 1].first + rides[m - 1].second;

        for (int i = m - 2; i >= 0; i--) {
            suffFinish[i] = min(
                suffFinish[i + 1],
                (long long)rides[i].first + rides[i].second
            );
        }

        long long ans = LLONG_MAX;

        for (int i = 0; i < (int)s1.size(); i++) {
            long long finish = (long long)s1[i] + d1[i];

            int pos = upper_bound(start.begin(), start.end(), finish)
                      - start.begin();

            if (pos > 0) {
                ans = min(ans, finish + prefDur[pos - 1]);
            }

            if (pos < m) {
                ans = min(ans, suffFinish[pos]);
            }
        }

        return ans;
    }

    int earliestFinishTime(vector<int>& landStartTime,
                           vector<int>& landDuration,
                           vector<int>& waterStartTime,
                           vector<int>& waterDuration) {

        long long ans1 = solveOrder(
            landStartTime, landDuration,
            waterStartTime, waterDuration
        );

        long long ans2 = solveOrder(
            waterStartTime, waterDuration,
            landStartTime, landDuration
        );

        return (int)min(ans1, ans2);
    }
};