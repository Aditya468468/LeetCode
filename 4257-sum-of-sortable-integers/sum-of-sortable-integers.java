class Solution {

    public boolean rotation(int[] nums,int []sorted, int start, int k)
    {
        HashMap<Integer,Integer> map1=new HashMap<>();

        for(int i=start;i<start+k;i++)
        {
            map1.put(nums[i],map1.getOrDefault(nums[i],0)+1);
        }
        // for(int i=start;i<start+k;i++)
        // {
        //     if(!map1.containsKey(sorted[i]))
        //     {
        //         return false;
        //     }
        //     map1.put(sorted[i],map1.getOrDefault(sorted,0)-1);
        //     if(map1.get(sorted[i])==0) map1.remove(sorted[i]);
        // }
        for(int i=start;i<start+k;i++)
        {
            int val = sorted[i];
            if(!map1.containsKey(val)) return false;
            map1.put(val, map1.get(val) - 1);
            if(map1.get(val) == 0) map1.remove(val);
        }

        int n=nums.length;
        int dip=0;
        for(int i=start+1;i<start+k;i++)
        {
            if(nums[i-1]>nums[i])
            {
                dip++;
                if(dip>1) return false;
            }
            
        }
        if(nums[start]<nums[start+k-1]) dip++;
        return dip<=1;
        
    }

    public int sortableIntegers(int[] nums) 
    {
        int n=nums.length;

        List<Integer> div = new ArrayList<>();
        for(int i=1; i*i<=n;i++)
        {
            if(n%i==0)
            {
                div.add(i);
                if(i!=n/i) div.add(n/i);
            }
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int sum=0;
        for(int k:div)
        {
            boolean can=true;

            for(int start = 0; start<n;start+=k)
            {
                if(!rotation(nums,sorted,start,k))
                {
                    can=false;
                    break;
                }
            }

            if(can) sum+=k;
        }

        return sum;
    }
}