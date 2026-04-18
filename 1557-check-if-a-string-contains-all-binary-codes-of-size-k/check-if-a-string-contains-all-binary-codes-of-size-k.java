class Solution {
    public boolean hasAllCodes(String s, int k) 
    {
        HashSet<String> set=new HashSet<>();
        int n=s.length();
        StringBuilder str=new StringBuilder();
        int left=0;
        for(int right=0;right<n;right++)
        {
            char ch=s.charAt(right);
            str.append(ch);
            while(right-left+1>k && right<n)
            {
                str.deleteCharAt(0);
                left++;
            }
            if(right-left+1==k)
            {
                set.add(str.toString());
            }
            if(set.size()==(int)Math.pow(2,k))
            {
                return true; //early exit.
            }
        }

        // int needed=(int)Math.pow(2,k);
        // if(set.size()==needed) return true;

        return false;
        
    }
}