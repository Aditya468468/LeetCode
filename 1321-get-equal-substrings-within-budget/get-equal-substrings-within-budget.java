class Solution {
    public int equalSubstring(String s, String t, int maxCost) 
    {
        int maxLen=0;
        int left=0;
        int n=s.length();
        int totalCost=0;

        for(int right=0;right<n;right++)
        {
            totalCost+=Math.abs(s.charAt(right)-t.charAt(right));

            while(totalCost>maxCost)
            {
                totalCost-=Math.abs(s.charAt(left)-t.charAt(left));
                // I cant take u anymore sorry.
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }


        return maxLen;


        
    }
}