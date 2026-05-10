class Solution {
public:
    int countHillValley(vector<int>& nums) 
    {
        int n=nums.size();
        int count=0;

        for(int i=1;i<n-1;i++)
        {
            int left=i-1;
            int right=i+1;
            if(nums[i]==nums[i-1])
            {
                continue; // U see if they are equal measn,its the part
                // of same valley/hill so we dont count it again
                //eg 2 4 1 1 6 5,see idx 3,here its same valley,we dont count it  
            }
            while(left>=0 && nums[i]==nums[left])
            {
                left--; // we will movee,till we get the non-equal neigbours
                        // but only till left>=0 otherwise idx out of bounds 
            }
            while(right<=n-1 && nums[i]==nums[right])
            {
                right++; // we will movee,till we get the non-equal neigbours 
                // we will movee,till we get the non-equal neigbours
                        // but only till right<=n-1 otherwise idx out of bounds 
            }
           
            if (left >= 0 && right <= n-1) 
            {
                 //This is main means lets say if we cant find the left and right,
                 // using our while nd it exceeds there letf and right
                 // means there is no neighbour (non-equal) soo
                 //eg 6 6 6 6 6 5 ..soo by doing this check we are determining
                 // that yes there are non-equal neighbours
                if (nums[i] > nums[left] && nums[i] > nums[right]) {
                    count++; // hill
                } else if (nums[i] < nums[left] && nums[i] < nums[right]) {
                    count++; // valley
                }
                // in other where letf<i && right>i,(vice-versa)
                // its already given it cant be valley or hill.
            }
        }
 
        return count; // Enjoy!
        }
                
    
};