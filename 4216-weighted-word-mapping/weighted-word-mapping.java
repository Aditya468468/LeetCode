class Solution {
    public String mapWordWeights(String[] words, int[] weights) 
    {
        int idx=0;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<words.length;i++)
        {
            int cost=0;
            String s=words[i];
            for(int j=0;j<s.length();j++)
            {
                char ch=s.charAt(j);
                cost+=weights[ch-'a'];
            }
                cost=cost%26;
                char ch=(char)('z'-cost);
                str.append(ch);
        }

        return str.toString();

        
    }
}