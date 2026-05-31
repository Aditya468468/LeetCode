class Solution {
    public int prefixConnected(String[] words, int k) 
    {

        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {

            String str=words[i];
            if(str.length()<k) continue;
            str=str.substring(0,k);
            map.put(str,map.getOrDefault(str,0)+1);
        }
        int groups=0;
        for(Map.Entry<String,Integer> it:map.entrySet())
        {
            if(it.getValue()>=2)
            {
                groups++;
            }
        }

        return groups;
    }
}