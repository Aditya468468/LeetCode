class Solution 
{
    public String[] findRestaurant(String[] list1, String[] list2) 
    {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<list1.length;i++)
        {
            if(!map.containsKey(list1[i]))
            {
                map.put(list1[i],i);
            }
        }
        List<String> ans=new ArrayList<>();
        int minSum=Integer.MAX_VALUE;
        for(int i=0;i<list2.length;i++)
        {
            if(map.containsKey(list2[i]))
            {
        
                int sum=i+map.get(list2[i]);
                if(minSum>sum)
                {
                    ans.clear();
                    ans.add(list2[i]);
                    minSum=sum;
                }
                else if(minSum==sum)
                {
                    ans.add(list2[i]);
                }
            }
        }
    
        String[] res=new String[ans.size()];
        int idx=0;
        for(int i=0;i<res.length;i++)
        {
            res[idx++]=ans.get(i);
        }

        return res;


        
    }
}