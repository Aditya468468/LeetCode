class Solution {
    public int monotoneIncreasingDigits(int n) 
    {
        //Right to left as we want larger number,<=n
        char []nums=Integer.toString(n).toCharArray();
        //Converts, The n to char[]
        int size=nums.length;
        int marker=size;
        
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]>nums[i+1])
            {
                nums[i]--;
                marker=i+1;
               
            }
        }
        //Optimization
        for (int i = marker; i < nums.length; i++) {
            nums[i]='9';
        }
        int i=0;
        while(i<size && nums[i]=='0')
        {
            i++;
        }


        return Integer.parseInt(new String(nums));


        
    }
}