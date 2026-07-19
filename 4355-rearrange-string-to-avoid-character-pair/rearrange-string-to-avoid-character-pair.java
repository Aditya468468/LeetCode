class Solution {
    public String rearrangeString(String s, char x, char y) 
    {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder str=new StringBuilder();
        
        int countY=0;
        if(map.containsKey(y))
        {
            countY=map.get(y);
        }
        for(int i=0;i<countY;i++)
        {
            str.append(y);
        }
        map.remove(y);
        for(Map.Entry<Character,Integer> it:map.entrySet())
        {
            char key=it.getKey();
            int count=it.getValue();
            for(int i=0;i<count;i++)
            {
            str.append(key);
            }

        }

        return str.toString();
        
    }
}