class Solution 
{
    public long sumOfMax(int[]nums)
    {
        int n=nums.length;
        int[]ngE=new int[n];
        int []pgeE=new int[n];
        Stack<Integer> st=new Stack<>();

        //Next Greater Element
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && nums[st.peek()]<nums[i])
            {
                ngE[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            ngE[st.pop()]=n;
        }

        //Previous Greater Or Equal Element
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[st.peek()]<=nums[i])
            {
                pgeE[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            pgeE[st.pop()]=-1;
        }
        long sum=0;
        for(int i=0;i<n;i++)
        {
            int left=(i-pgeE[i]);
            int right=(ngE[i]-i);
            sum+=(long)nums[i]*left*right;
        }

        return sum;

    }
     public long sumOfMin(int[]nums)
    {
        int n=nums.length;
        int[]nsE=new int[n];
        int []pseE=new int[n];
        Stack<Integer> st=new Stack<>();

        //Next Smaller Element
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && nums[st.peek()]>nums[i])
            {
                nsE[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            nsE[st.pop()]=n;
        }

        //Previous smaller Or Equal Element
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[st.peek()]>=nums[i])
            {
                pseE[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            pseE[st.pop()]=-1;
        }

        long sum=0;
        for(int i=0;i<n;i++)
        {
            int left=(i-pseE[i]);
            int right=(nsE[i]-i);
            sum+=(long)nums[i]*left*right;
        }

        return sum;

    }

    public long subArrayRanges(int[] nums)
    {
        return sumOfMax(nums)-sumOfMin(nums);
    }
}