class Solution {
    public List<List<String>> groupAnagrams(String[] nums) 
    {
        Map<String,List<String>> map = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
           char[] ch = nums[i].toCharArray();
           Arrays.sort(ch);
           String key = new String(ch);         
            if(!map.containsKey(key))
            {
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(nums[i]);

        }
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<String,List<String>> it:map.entrySet())
        {
            ans.add(it.getValue());
        }

        return ans;
        
    }
}