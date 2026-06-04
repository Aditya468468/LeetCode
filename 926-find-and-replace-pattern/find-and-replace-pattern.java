class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) 
    {
        List<String> list=new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            HashMap<Character,Character> m1=new HashMap<>();
            HashMap<Character,Character> m2=new HashMap<>();
            boolean match=true;
            String word=words[i];
            for(int j=0;j<word.length();j++)
            {
                char x1=pattern.charAt(j);
                char x2=word.charAt(j);

                if(m1.containsKey(x1) || m2.containsKey(x2))
                {
                    if((m1.containsKey(x1) && !m1.get(x1).equals(x2)) || (m2.containsKey(x2) && !m2.get(x2).equals(x1)))
                    {
                        match=false;
                        break;

                    } 
                }
                else
                {
                    m1.put(x1,x2);
                    m2.put(x2,x1);
                }
            }

            if(match)
            {
                list.add(word);
            }

        }

        return list;
        
    }
}