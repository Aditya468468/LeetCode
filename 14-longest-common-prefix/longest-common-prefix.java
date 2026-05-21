class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        String ref=strs[0];
        int match=ref.length();
        for(int i=1;i<strs.length;i++)
        {
            String s=strs[i];
            int j=0;
            while(j<ref.length() && j<s.length())
            {
                if(ref.charAt(j)!=s.charAt(j))
                {
                    break;
                }
                j++;
            }
            match=Math.min(match,j);
        }

        return ref.substring(0,match);
    }
}