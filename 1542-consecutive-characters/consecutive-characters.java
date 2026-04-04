class Solution {
    public int maxPower(String s) 
    {
        
        if(s.length()==0) return 0;
        int max=1; int len=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i-1)==s.charAt(i))
            {
                len++;
            }
            else
            {
                max=Math.max(max,len);
                len=1;
            }
        }
        max=Math.max(max,len);
        
        return max;
    }
}