class Solution 
{
    boolean isPalindrome(String s,int i,int j)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j)) return false;
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
            if(isPalindrome(s,idx,i))
            {
                list.add(s.substring(idx,i+1));
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