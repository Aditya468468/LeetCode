class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) 
    {
        HashSet<Integer> set=new HashSet<>();
        //We Add Every Possible Prefix of Nums in arr1
        for(int i=0;i<arr1.length;i++)
        {
            int num=arr1[i];
            while(num!=0)
            {
                set.add(num);
                num/=10;
            }
        }
        int maxLen=0;
        for(int i=0;i<arr2.length;i++)
        {
            int num=arr2[i];
            int len=(int)Math.floor(Math.log10(num))+1;
            while(len!=0)
            {
                if(set.contains(num))
                {
                    maxLen=Math.max(maxLen,len);
                    break;
                }
                len--;
                num/=10;
            }
        }

        return maxLen;
    }
}