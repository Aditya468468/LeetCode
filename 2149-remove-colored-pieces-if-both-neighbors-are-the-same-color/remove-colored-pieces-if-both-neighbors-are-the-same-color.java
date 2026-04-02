class Solution {
    public boolean winnerOfGame(String colors) 
    {
        char []nums=colors.toCharArray();
        int n=nums.length;
        int cntA=0;
        int cntB=0;
        for(int i=1;i<n-1;i++)
        {
            if(nums[i]=='A')
            {
                if(nums[i-1]=='A' && nums[i+1]=='A')
                {
                    cntA++;
                }
            }
            else
            {
                if(nums[i-1]=='B' && nums[i+1]=='B')
                {
                    cntB++;
                }

            }
            
        }
        if(cntA>cntB) return true;
        else return false;
        
    }
}