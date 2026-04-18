class Solution 
{
    private void generate(int idx,int n,List<String> ans,StringBuilder str,int open,int close)
    {
        if(open+close==2*n && open==close)
        {
            ans.add(str.toString());
            return;
        }
        if(idx==2*n) return; //pruning
        if(open<n)
        {
            str.append('(');
            generate(idx+1,n,ans,str,open+1,close);
            //Backtrack
            str.deleteCharAt(str.length()-1);
        }
        if(close<open)
        {
            str.append(')');
            generate(idx+1,n,ans,str,open,close+1);
            //Backtrack.
            str.deleteCharAt(str.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) 
    {
        List<String> ans=new ArrayList<>();
        generate(0,n,ans,new StringBuilder(),0,0);

        return ans;

        
    }
}