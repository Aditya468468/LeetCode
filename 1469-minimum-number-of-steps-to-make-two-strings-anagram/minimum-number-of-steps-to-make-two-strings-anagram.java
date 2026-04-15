class Solution {
    public int minSteps(String s, String t) 
    {

        //length will be same only naa.
        int n=s.length();
        if(n!=t.length()) return -1;
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            char y=t.charAt(i);
            map1.put(x,map1.getOrDefault(x,0)+1);
            map2.put(y,map2.getOrDefault(y,0)+1);
        }
        int need=0;
        
        for(Map.Entry<Character,Integer> it:map1.entrySet())
        {
            char key=it.getKey();
            int value=it.getValue();

            if(map2.containsKey(key))
            {
                if(map2.get(key)<value)
                {
                    need+=value-map2.get(key); 
                }
                //if enough is there..no need to do anything at all->else part
            }
            else
            {
                need+=value;
            }

        }

        return need;

        
    }
}