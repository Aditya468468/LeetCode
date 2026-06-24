class Solution 
{
    class Pair
    {
        String s;
        int val;
        public Pair(String s,int val)
        {
            this.s=s;
            this.val=val;
        }
    }
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
        List<Pair> ans=new ArrayList<>();
        int minSum=Integer.MAX_VALUE;
        for(int i=0;i<list2.length;i++)
        {
            if(map.containsKey(list2[i]))
            {
        
                int sum=i+map.get(list2[i]);
                Pair p=new Pair(list2[i],sum);
                ans.add(p);
                minSum=Math.min(minSum, sum);
            }
        }
        List<String> list=new ArrayList<>();
        for(int i=0;i<ans.size();i++)
        {
            Pair curr=ans.get(i);
            if(curr.val==minSum)
            {
                list.add(curr.s);
            }
        }
        String[] res=new String[list.size()];
        int idx=0;
        for(int i=0;i<res.length;i++)
        {
            res[idx++]=list.get(i);
        }

        return res;


        
    }
}