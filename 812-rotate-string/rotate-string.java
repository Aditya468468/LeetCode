class Solution {
    public boolean rotateString(String s, String goal) 
    {
        if(s.length()!=goal.length()) return false;
        String str=s+s;
        int n=str.length();
        int left=0;
        for(int right=0;right<n;right++)
        {
            while(right-left+1>goal.length())
            {
                left++;
            }
            if(right-left+1==goal.length())
            {
                if(goal.equals(str.substring(left,right+1)))
                {
                    return true;
                }
            }
        }

        return false;
        
    }
}