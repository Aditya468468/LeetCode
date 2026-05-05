class Solution {
    private int BS(List<Integer> list,int k)
    {
        int low=0;
        int high=list.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid)==k)
            {
                return mid;
            }
            else if(list.get(mid)>k)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1; //dummy

    }
    public List<Integer> solveQueries(int[] nums, int[] queries) 
    {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++)
        {
            int q=queries[i];
            List<Integer> idx=map.get(nums[q]);
            if(idx.size()==1) 
            {
                ans.add(-1);
                continue;
            }
            int m=idx.size();
            int pos=BS(idx,q);
            int left=idx.get((pos-1+m)%m);
            int right=idx.get((pos+1)%m);
            int disL=Math.abs(left-q);
            int disR=Math.abs(right-q);
            // Here we can reach by n-d also-> clock and Anti
            disL=Math.min(disL,n-disL);
            disR=Math.min(disR,n-disR);
            ans.add(Math.min(disL, disR));
            
        }

        return ans;
        
    }
}