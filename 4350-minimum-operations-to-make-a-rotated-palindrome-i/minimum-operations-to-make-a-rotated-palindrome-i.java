class Solution 
{
    public int generate(String str)
    {
        int i=0;
        int j=str.length()-1;
        int ops=0;
        while(i<j)
        {
            int inc=Math.abs(str.charAt(i)-str.charAt(j));
            ops+=Math.min(inc,26-inc);
            i++;
            j--;
        }

        return ops;

    }
    public int minOperations(String s) 
    {

        int n=s.length();
        int minOps=Integer.MAX_VALUE;

        //One Valid Rotation, Will be Our Ans.
        // Fck it and Lets check all the Valid rotations, and lets take min
        
        s=s+s; // String concat

        //Sliding Window-> To determine all Valid rotations
        int left=0;
        for(int right=0;right<2*n;right++)
        {
          
            while(right-left+1>n)
            {
                left++;
            }
            if(right-left+1==n)
            {
                int ops=generate(s.substring(left,right+1));
                if(left<n) minOps=Math.min(minOps,ops+left);
                // left<n --> We need to count Rotations also na as Cost.
            }
        }


        return minOps;

    }
}