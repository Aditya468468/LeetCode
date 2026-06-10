class Solution 
{
    private boolean isPalindrome(String str)
    {
        int i=0;
        int j=str.length()-1;
        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
    private void generate(int idx,String s,List<List<String>> ans,List<String> list)
    {
        if(idx==s.length())
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<s.length();i++)
        {
            String str=s.substring(idx,i+1);
            if(isPalindrome(str))
            {
                list.add(str);
                generate(i+1,s,ans,list);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) 
    {
        List<List<String>> ans=new ArrayList<>();
        generate(0,s,ans,new ArrayList<>());

        return ans;
    }
}