class Solution {
    public int[] separateDigits(int[] nums) 
    {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<=9)
            {
                list.add(nums[i]);
            }
            else
            {
                List<Integer> temp=new ArrayList<>();
                int x=nums[i];
                while(x!=0)
                {
                    temp.add(x%10);
                    x/=10;
                }
                for(int j=temp.size()-1;j>=0;j--)
                {
                    list.add(temp.get(j));
                }
            }
        }
        int[]res=new int[list.size()];
        for(int i=0;i<res.length;i++)
        {
            res[i]=list.get(i);
        }

        return res;

        
    }
}