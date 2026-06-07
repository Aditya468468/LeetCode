class Solution 
{
    private void generate(int n,int idx,int open, int close,StringBuilder str,List<String> list)
    {
        if(idx==2*n)
        {
            list.add(new StringBuilder(str).toString());
            return;
        }
        // There can be 2 options, At idx,
        // But if(open>close) -> there should be opening for closing.
        // if(open<n)-> there cant be more then 2 opening
        //Lets See for Open at idx,
        if(open<n)
        {
            str.append('(');
            generate(n,idx+1,open+1,close,str,list);
            //We goo its depth.. Then we back track.
            str.deleteCharAt(str.length()-1);
        }
        // Can that idx have closing;
        if(close<open)
        {
            str.append(')');
            generate(n,idx+1, open, close+1,str,list);
            str.deleteCharAt(str.length()-1);//Backtrack.
        }

    }
    public List<String> generateParenthesis(int n) 
    {
        List<String> list=new ArrayList<>();
        generate(n,0,0,0,new StringBuilder(),list);

        return list;    
    }
}