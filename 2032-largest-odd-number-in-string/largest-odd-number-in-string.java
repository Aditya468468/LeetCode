class Solution {
    public String largestOddNumber(String num) 
    {
        int idx=-1;
        int n=num.length();
        for(int i=n-1;i>=0;i--)
        {
            if((num.charAt(i)-'0')%2==1)
            {
                idx=i;
                break;
            }
        }
        if(idx==-1) return "";
        return num.substring(0,idx+1);

        
    }
}