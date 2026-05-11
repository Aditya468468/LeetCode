class Solution {
public:
    long long minArraySum(vector<int>& nums) 
    {
        //Logic->
        /*
            Any no-> Easy ..Bound-> Not there,
            a<b && b>a -> I have a use 2 pointers. i.....j....
            More-> Easy.
            nums[i] % nums[j]==0.-->divisibilty.
            [3,6,3,2]-> 6-> 3 and 2..
            //Sum min-> 2.. 8->4 ,2
            -> o(n2)-> 
            -> Min div which is prsent in array.
            -> [3,6,3,2]-Set-> 0(1) ->precompute.
            -> I will find div of x-> 
            we loop-> sqrt(x).
            d1=x--d2=n/x.. 16--> 4
            (2,8)--> a*b=n--> b=n/a
            o(n*sqrt(max(nums))).
        */
        unordered_set<int> set;
        int n=nums.size();
        for(int x:nums)
        {
            set.insert(x);
        }
        long long sum=0;
        for(int i=0;i<n;i++)
        {
            int mini=nums[i];
            for(int j=1;j*j<=nums[i];j++)
            {
                if(nums[i]%j==0)
                {
                    int d1=j;
                    int d2=nums[i]/j;
                    if(set.contains(d1))
                    {
                        mini=min(mini,d1);
                    }
                   if(set.contains(d2))
                   {
                        mini=min(mini,d2);
                   }
                }

            }
            sum+=mini;
        }

        return sum;


        
    }
};