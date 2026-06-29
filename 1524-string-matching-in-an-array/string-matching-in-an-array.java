class Solution {
    public List<String> stringMatching(String[] words) 
    {
        
        HashSet<String> set=new HashSet<>();
        int n=words.length;
        
        for(int i=0;i<n;i++)
        {
            String pattern=words[i];
            for(int j=0;j<n;j++)
            {
                if(i==j) continue;
                String word=words[j];
                int m=word.length();
                int k=pattern.length();
                if(k>m) continue;

                for(int x=0;x<=m-k;x++)
                {
                    boolean match=true;
                    for(int y=0;y<k;y++)
                    {
                        if(pattern.charAt(y)!=word.charAt(x+y))
                        {
                            match=false;
                            break;
                        }
                    }
                    if(match)
                    {
                        set.add(pattern);
                        break;
                    }

                }

            }
        }
        List<String> list=new ArrayList<>(set);
        return list;

        
    }
}