class Solution {
    public int numOfStrings(String[] patterns, String word) 
    {
        int cnt=0;
        for(int i=0;i<patterns.length;i++)
        {
            String s=patterns[i];
            if(s.length()>word.length()) continue;
            int len=s.length();
            for(int j=0;j<=word.length()-len;j++)
            {
                boolean match=true;
                for(int k=0;k<len;k++)
                {
                   if (word.charAt(j+k)!=s.charAt(k)) {
                        match = false;
                        break;
                    }

                }
                if(match)
                {
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
        
    }
}