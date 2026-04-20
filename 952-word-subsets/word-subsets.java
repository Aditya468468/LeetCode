class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) 
    {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<words2.length;i++)
        {
            Map<Character,Integer> temp=new HashMap<>();
            String s=words2[i];
            for(int j=0;j<s.length();j++)
            {
                temp.put(s.charAt(j),temp.getOrDefault(s.charAt(j),0)+1);
            }

            for (Map.Entry<Character,Integer> entry:temp.entrySet())
            {
                char c=entry.getKey();
                int freq=entry.getValue();
                map.put(c,Math.max(map.getOrDefault(c, 0),freq));
            }

        }
            List<String> list=new ArrayList<>();
            for(int i=0;i<words1.length;i++)
            {
                String s=words1[i];
                Map<Character,Integer> map2=new HashMap<>();
                for(int j=0;j<s.length();j++)
                {
                    map2.put(s.charAt(j),map2.getOrDefault(s.charAt(j),0)+1);
                }
                boolean isValid=true;
                for(Map.Entry<Character,Integer> it:map.entrySet())
                {
                    char key=it.getKey();
                    int value=it.getValue();
                    if(!map2.containsKey(key))
                    {   
                        isValid=false;
                        break;
                    }
                    else
                    {
                        if(map2.get(key)<value)
                        {
                            isValid=false;
                            break;
                        }
                    }
                }
                if(isValid)
                {
                    list.add(s);
                }
                
            }


        return list;
    }
}