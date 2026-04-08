class Solution 
{
    private void generate(int n,List<String> list,String s,int open,int close)
    {
        if(open+close==2*n && open==close)
        {
            list.add(s);
            return;
        }
        if(open<n)
        {
            //s=s+'(';
            generate(n,list,s+'(',open+1,close);
        }
        if(close<open)
        {
            //s+=')';// this will change the state in current fun space.
            //Wrong we need to keep this as it is
            generate(n,list,s+')',open,close+1); // and pass new to next fun call.
            // Else i need to redo it.
            // (_--> lets say (( okay now,
            //for the next if block-> (()->3 noo..it should be -> ()
        }
    }
    public List<String> generateParenthesis(int n) 
    {
        List<String> list=new ArrayList<>();
        generate(n,list,"",0,0);
        return list;
    }
}