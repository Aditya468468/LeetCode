class Solution 
{
    private void generate(int n,List<String> ans,String s,int open,int close)
    {
        if(open+close==2*n && open==close)
        {
            ans.add(s);
            return;
        }
        if(open<n)
        {
            generate(n,ans,s+'(',open+1,close);
        }
        if(close<open)
        {
            generate(n,ans,s+')',open,close+1);
        }
    }
    public List<String> generateParenthesis(int n) 
    {
        List<String> ans=new ArrayList<>();
        generate(n,ans,"",0,0);

        return ans;

        
    }
}