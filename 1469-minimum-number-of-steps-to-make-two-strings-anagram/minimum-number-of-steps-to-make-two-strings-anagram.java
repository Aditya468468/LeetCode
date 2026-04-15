class Solution {
    public int minSteps(String s, String t) 
    {

        //length will be same only naa.
        int n=s.length();
        if(n!=t.length()) return -1;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int i=0;i<n;i++)
        {
            char x=t.charAt(i);
            map.put(x,map.getOrDefault(x,0)-1);
        }
        int need=0;
        
        for(Map.Entry<Character,Integer> it:map.entrySet())
        {
            int value=it.getValue();
            if(value>0)
            {
                need+=value;
            }
        }

        return need;

        
    }
}