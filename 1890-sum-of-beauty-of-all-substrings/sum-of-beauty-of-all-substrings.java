class Solution {
    public int beautySum(String s) 
    {
        int count=0;
        HashMap<Character,Integer> map=new HashMap<>();
        char []nums=s.toCharArray();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                char x=nums[j];
                map.put(x,map.getOrDefault(x,0)+1);
                 int maxFreq = Integer.MIN_VALUE;
                 int minFreq = Integer.MAX_VALUE;
                    for (int freq:map.values()) 
                    {
                        maxFreq=Math.max(maxFreq,freq);
                        minFreq=Math.min(minFreq,freq);
                    }
                count+=maxFreq-minFreq;

            }
            map.clear();
        }
        return count;
        
    }
}