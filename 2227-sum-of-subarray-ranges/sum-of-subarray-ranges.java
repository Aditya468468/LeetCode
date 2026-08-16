class Solution 
{
    public long sumOfMaximums(int[]nums)
    {
        int n=nums.length;
        int[]ngE=new int[n]; // Stores index
        int []pgeE=new int[n]; // Stores index 
        Stack<Integer> st=new Stack<>();
        //Lets Find nGE
        for(int i=0;i<n;i++)
        {
            if(!st.isEmpty())
            {
                while(!st.isEmpty() && nums[st.peek()]<nums[i])
                {
                    ngE[st.pop()]=i;
                }
                if(st.isEmpty())
                {
                    ngE[i]=n;
                }
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            ngE[st.pop()]=n;
        }

        //Lets Find pgeE
        for(int i=n-1;i>=0;i--)
        {
            if(!st.isEmpty())
            {
                while(!st.isEmpty() && nums[st.peek()]<=nums[i])
                {
                    pgeE[st.pop()]=i;
                }
                if(st.isEmpty())
                {
                    pgeE[i]=-1;
                }
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
            sum+=(1L)*((long)nums[i]*(i-pgeE[i])*(ngE[i]-i));
        }

        return sum;


    }

     public long sumOfMinmums(int[]nums)
    {
        int n=nums.length;
        int[]nsE=new int[n]; // Stores index
        int []pseE=new int[n]; // Stores index 
        Stack<Integer> st=new Stack<>();
        //Lets Find nsE
        for(int i=0;i<n;i++)
        {
            if(!st.isEmpty())
            {
                while(!st.isEmpty() && nums[st.peek()]>nums[i])
                {
                    nsE[st.pop()]=i;
                }
                if(st.isEmpty())
                {
                    nsE[i]=n;
                }
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            nsE[st.pop()]=n;
        }

        //Lets Find pseE
        for(int i=n-1;i>=0;i--)
        {
            if(!st.isEmpty())
            {
                while(!st.isEmpty() && nums[st.peek()]>=nums[i])
                {
                    pseE[st.pop()]=i;
                }
                if(st.isEmpty())
                {
                    pseE[i]=-1;
                }
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
            sum+=(1L)*((long)nums[i]*(i-pseE[i])*(nsE[i]-i));
        }

        return sum;


    }

    public long subArrayRanges(int[] nums) 
    {

        return sumOfMaximums(nums)-sumOfMinmums(nums);
        
     
    }
}