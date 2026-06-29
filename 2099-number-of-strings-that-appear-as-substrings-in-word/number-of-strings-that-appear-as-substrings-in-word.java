class Solution {
    public int numOfStrings(String[] patterns, String word) 
    {
        int cnt=0;
        for(int i=0;i<patterns.length;i++)
        {
            String s=patterns[i];
            if(s.length()>word.length()) continue;
            int len=s.length();
            for(int j=0;j<word.length();j++)
            {
                boolean match=false;
                StringBuilder str = new StringBuilder();
                for(int k=j;k<word.length();k++)
                {
                    str.append(word.charAt(k));
                    if(str.toString().equals(s))
                    {
                        match=true;
                        break;
                    }
                    if(k-j+1>len) break;
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