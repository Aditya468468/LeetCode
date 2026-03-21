class Solution {
    public List<String> findRepeatedDnaSequences(String s) 
    {
        HashSet<String> set = new HashSet<>();
        HashSet<String> seen=new HashSet<>();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            str.append(s.charAt(i));
            while(str.length()>10)
            {
                str.deleteCharAt(0);
            }
            if(str.length()==10)
            {
                String temp=str.toString();
                if(set.contains(temp))
                {
                    seen.add(temp);
                }
                else
                {
                    set.add(temp);
                }
            }
        }
        ArrayList<String> ans=new ArrayList<>(seen);

        return ans;
        
        
    }
}