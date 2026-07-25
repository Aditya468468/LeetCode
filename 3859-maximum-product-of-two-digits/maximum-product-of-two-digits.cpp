class Solution {
public:
    int maxProduct(int n) 
    {
        int max=INT_MIN;
        int smax=INT_MIN;

        while(n!=0)
        {
            int ld=n%10;
            if(max<ld)
            {
                smax=max;
                max=ld;
            }
            else if(smax<ld)
            {
                smax=ld;
            }
            n=n/10;
        }

        return max*smax;
        
    }
};