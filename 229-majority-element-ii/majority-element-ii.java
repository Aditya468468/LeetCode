class Solution {
    public List<Integer> majorityElement(int[] nums) 
    {
        int cnt1=0;
        int cnt2=0;
        int ele1=Integer.MIN_VALUE;
        int ele2=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(cnt1==0 && nums[i]!=ele2)
            {
                cnt1=1;
                ele1=nums[i];
            }
            else if(cnt2==0 && nums[i]!=ele1)
            {
                cnt2=1;
                ele2=nums[i];
            }
            else if(nums[i]==ele1)
            {
                cnt1++;
            }
            else if(nums[i]==ele2)
            {
                cnt2++;
            }
            else
            {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> list=new ArrayList<>();
        int count1=0;
        int count2=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==ele1) count1++;
            else if(nums[i]==ele2) count2++;

        }
        if(count1>n/3) list.add(ele1);
        if(count2>n/3) list.add(ele2);
        Collections.sort(list);

        return list;


        
    }
}