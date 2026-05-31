class Solution {
    public int digitFrequencyScore(int n) 
    {
        Map<Integer,Integer> map=new HashMap<>();
        while(n!=0)
            {
                int ld=n%10;
                map.put(ld,map.getOrDefault(ld,0)+1);
                n=n/10;
            }
        long score=0;
        for(Map.Entry<Integer,Integer> it:map.entrySet())
            {
                long s=(1L)*it.getKey()*it.getValue();
                score+=s;
            }

        return (int)score;
        
        
    }
}