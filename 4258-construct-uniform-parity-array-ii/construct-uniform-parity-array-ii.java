class Solution 
{
    public boolean check(List<Integer> list,int x)
    {
        int low=0;
        int high=list.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid)>x)
            {
                high=mid-1;
            }
            else
            {
            
                return true;
            }
        }

        return false;
    }

    public boolean uniformArray(int[] nums1) 
    {
        List<Integer> odd=new ArrayList<>();
        List<Integer> even=new ArrayList<>();
        int n=nums1.length;

        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]%2==0)
            {
                even.add(nums1[i]);
            }
            else
            {
                odd.add(nums1[i]);
            }
        }
        Collections.sort(odd);
        Collections.sort(even);

        if(odd.size()==0 || even.size()==0)
        {
            return true;
        }

        //All Odd
        boolean canOdd=true;
        for(int i=0;i<n;i++)
        {
            if(nums1[i]%2==0)
            {
                //nums[i]-x>=1--> nums[i]-1>=x
                //x<=nums[i]-1
                // Even--> Needs--> Odd
                int x=nums1[i]-1;
                if(check(odd,x)==false)
                {
                    canOdd=false;
                    break;
                }
            }
        }

        boolean canEven=true;
        for(int i=0;i<n;i++)
        {
            if(nums1[i]%2!=0)
            {
                //nums[i]-x>=1--> nums[i]-1>=x
                //x<=nums[i]-1
                // Odd--> Needs--> Odd // Now We need distict
                int x=nums1[i]-1;
                if(check(odd,x)==false)
                {
                    canEven=false;
                    break;
                }
            }
        }

        return canOdd || canEven;
    }
}