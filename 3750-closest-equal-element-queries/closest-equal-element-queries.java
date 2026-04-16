class Solution {
    public int BS(List<Integer> list, int x)
    {
        int low=0;
        int high=list.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid)==x)
            {
                return mid;
            }
            else if(list.get(mid)>x)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }

        }

        return -1;

    }
    public List<Integer> solveQueries(int[] nums, int[] queries) 
    {
        int n=nums.length;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i];
            if(!map.containsKey(x))
            {
                map.put(x,new ArrayList<>());
            }
            map.get(x).add(i);
        }

        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<queries.length;i++)
        {
            int elem=nums[queries[i]];
            List<Integer> temp=map.get(elem);
            if(temp.size()==1)
            {
                ans.add(-1);
                continue;
            }
            int q=queries[i];
            int idx=BS(temp,queries[i]); //First pos.
            int left = temp.get((idx - 1 + temp.size()) % temp.size());
            int right = temp.get((idx + 1) % temp.size());
            int minDist = Integer.MAX_VALUE;

        // LEFT
            if(left != q) {
                int d = Math.abs(q - left);
                minDist = Math.min(minDist, Math.min(d, n - d));
            }

        // RIGHT
            if(right != q) {
                int d = Math.abs(q - right);
                 minDist = Math.min(minDist, Math.min(d, n - d));
            }

            ans.add(minDist);
            
        }

        return ans;



        
    }
}