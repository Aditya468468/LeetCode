class Solution {
    public List<List<String>> groupAnagrams(String[] nums) 
    {
        Map<Map<Character,Integer>,List<String>> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            String s=nums[i];
            Map<Character,Integer> temp=new HashMap<>();
            for(char x:s.toCharArray())
            {
                temp.put(x,temp.getOrDefault(x,0)+1);
            }
            if(!map.containsKey(temp))
            {
                map.put(temp,new ArrayList<>());
            }
            map.get(temp).add(s);

        }
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<Map<Character,Integer>,List<String>> it:map.entrySet())
        {
            ans.add(it.getValue());
        }

        return ans;
        
    }
}