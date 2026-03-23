class Solution {
// private:
// {
//     bool isPossible(vector<int>& candies,long long k,long long candy)
//     {
//         int n=candies.size();
//         long long child=0;
//         for(int i=0;i<n;i++)
//         {
//             child+=candies[i]/candy;
//             if(child>=k) return true;
//         }

//         return false;
//     }

// };
public:
    bool isPossible(vector<int>& candies,long long k,long long candy)
    {
        int n=candies.size();
        long long child=0;
        for(int i=0;i<n;i++)
        {
            child+=candies[i]/candy;
            if(child>=k) return true;
        }

        return false;
    }

    int maximumCandies(vector<int>& candies, long long k) 
    {
        long long low=1;
        long long totalSum=0;
        for(int x:candies)
        {
            totalSum+=x;
        }
        long long high=totalSum/k;
        if(totalSum<k) return 0;
        int ans=0;
        while(low<=high)
        {
            long long mid=low+(high-low)/2;
            if(isPossible(candies,k,mid))
            {
                ans=(int)mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }

        }
        return ans;

        
    }
};