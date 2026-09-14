class Solution {
    public int monotoneIncreasingDigits(int n) 
    {
        //Right to left as we want larger number,<=n
        char []nums=Integer.toString(n).toCharArray();
        //Converts, The n to char[]
        int size=nums.length;
        
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]>nums[i+1])
            {
                nums[i]--;
                int j=i+1;
                while(j<size && nums[j]!='9')
                {
                    nums[j]='9';
                    j++;
                }
            }
        }
        int i=0;
        while(i<size && nums[i]=='0')
        {
            i++;
        }


        return Integer.parseInt(new String(nums));


        
    }
}