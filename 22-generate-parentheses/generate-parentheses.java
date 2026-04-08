class Solution {

    private void generate(int n,List<String> list,StringBuilder str,int o,int c)
    {
        if(str.length()==2*n)
        {
            list.add(str.toString());
            return;
        }
        if(o<n)
        {
            str.append('(');
            generate(n,list,str,o+1,c);
            str.deleteCharAt(str.length() - 1);
        } 
        if(c<o)
        {
            str.append(')');
            generate(n,list,str,o,c+1);
            str.deleteCharAt(str.length() - 1);
        }
        
    }
    public List<String> generateParenthesis(int n) 
    {
        List<String> list=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        generate(n,list,str,0,0);
        return list;
       
    }
}