class Solution {
    public int[] pivotArray(int[] nums, int pivot) 
    {
        List<Integer> smaller=new ArrayList<>();
        List<Integer> equal=new ArrayList<>();
        List <Integer> greater =new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<pivot)
            {
                smaller.add(nums[i]);
            }
            else if(nums[i]==pivot)
            {
                equal.add(nums[i]);
            }
            else
            {
                greater.add(nums[i]);
            }
        }
        int idx=0;
        for(int i=0;i<smaller.size();i++)
        {
            nums[idx++]=smaller.get(i);
        }

        for(int i=0;i<equal.size();i++)
        {
            nums[idx++]=equal.get(i);
        }

        for(int i=0;i<greater.size();i++)
        {
            nums[idx++]=greater.get(i);
        }

        return nums;
        
    }
}