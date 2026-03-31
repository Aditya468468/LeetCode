class Solution {
    public int minimumOperations(int[] nums) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(map.size()==n) return 0;
        int cnt=0;
        for(int i=0;i<n;i+=3)
        {
        
            for(int j=i;j<Math.min(i+3,n);j++)
            {
                map.put(nums[j],map.getOrDefault(nums[j],0)-1);
                if(map.get(nums[j])==0) map.remove(nums[j]);
            }
          
           cnt++;
           int len=Math.min(n-(i+3),n);
           if(map.size()==len) break;
        }
        return cnt;
        
    }
}