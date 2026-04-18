class Solution 
{
    private void generate(int n,List<String> ans,StringBuilder str,int open,int close)
    {
        if(open+close==2*n && open==close)
        {
            ans.add(new String(str));
            return;
        }
        if(open<n)
        {
            str.append('(');
            generate(n,ans,str,open+1,close);
            //Backtrack
            str.deleteCharAt(str.length()-1);
        }
        if(close<open)
        {
            str.append(')');
            generate(n,ans,str,open,close+1);
            //Backtrack.
            str.deleteCharAt(str.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) 
    {
        List<String> ans=new ArrayList<>();
        generate(n,ans,new StringBuilder(),0,0);

        return ans;

        
    }
}