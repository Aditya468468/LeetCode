class Solution {
    public List<String> findRepeatedDnaSequences(String s) 
    {
        //We needed Repeated Seq-> That Too One time 
        HashSet<String> set=new HashSet<>();
        HashSet<String> seen=new HashSet<>();
        int n=s.length();
        //Its a Fixed Sized Window-> k=10;
        StringBuilder str=new StringBuilder();
        int left=0;
        for(int right=0;right<s.length();right++)
        {
            char ch=s.charAt(right);
            str.append(ch);
            //Shrink it babes 
            while(right-left+1>10)
            {
                str.deleteCharAt(0);
                left++;
            }
            if(right-left+1==10)
            {
                if(seen.contains(str.toString()))
                {
                    set.add(str.toString());
                }
                else 
                {
                    seen.add(str.toString());
                }
            }

        }

        return new ArrayList<>(set);
        
    }
}