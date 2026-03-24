class Solution {
    public boolean isVowel(char x)
    {
        String v="aeiou";
        String vo="AEIOU";
        if(v.indexOf(x)!=-1 || vo.indexOf(x)!=-1)
        {
            return true;
        }
        return false;
    }
    public String reverseVowels(String s) 
    {
        char []nums=s.toCharArray();
        int i=0;
        int j=nums.length-1;
        while(i<j)
        {
            while(i<nums.length && !isVowel(nums[i]))
            {
                i++;
            }
            while(j>=0 && !isVowel(nums[j]))
            {
                j--;
            }
            if(i<j)
            {
            char temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
            }
        }
        return new String(nums);
    }
}