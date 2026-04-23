class Solution {
    private boolean isVowel(char x)
    {
        String s="aeiou";
        if(s.indexOf(x)==-1) return false;
        return true;
    }
    public int maxVowels(String s, int k) 
    {
        char []nums=s.toCharArray();
        int n=nums.length;
        int maxCount=0;
        int count=0;
        int left=0;
        for(int right=0;right<n;right++)
        {
            if(isVowel(nums[right]))
            {
                count++;
            }

            while(right-left+1>k)
            {
                if(isVowel(nums[left]))
                {
                    count--;
                }
                left++;
            }
            if(right-left+1==k)
            {
                maxCount=Math.max(maxCount,count);
            }        
        }

        return maxCount;
        
    }
}