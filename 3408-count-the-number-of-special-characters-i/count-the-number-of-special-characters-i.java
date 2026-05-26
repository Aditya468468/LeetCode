class Solution {
    public int numberOfSpecialChars(String word) 
    {
        char[]freqS=new char[26];
        char[]freqC=new char[26];
        for(int i=0;i<word.length();i++)
        {
            char x=word.charAt(i);
            if(Character.isLowerCase(x))
            {
                freqS[x-'a']++;
            }
            else
            {
                freqC[x-'A']++;
            }
        }
        int cnt=0;
        for(int i=0;i<freqC.length;i++)
        {
            if(freqC[i]!=0)
            {
                if(freqS[i]!=0)
                {
                    cnt++;
                }
            }
        }
    
        return cnt;
    }
}