class Solution 
{
    private void generate(int n,int idx,List<String> ans, StringBuilder str)
    {
        if(idx==n)
        {
            ans.add(new String(str.toString()));
            return;
        }
        //Remmber we need to See Adj Zeros should not be there,
        // Its Binary-> 2 options-> 0/1 but if adj has 0-> Only one Option->1 
        
        if(idx==0) 
        {
            str.append('0');
            generate(n,idx+1,ans,str);
            str.deleteCharAt(str.length()-1);
        }
        if(idx>0 && str.charAt(idx-1)!='0')
        {
            str.append('0');
            generate(n,idx+1,ans,str);
            str.deleteCharAt(str.length()-1);
        }
        // 1 is Always Avaialable to take.
        str.append('1');
        generate(n,idx+1,ans,str);
        str.deleteCharAt(str.length()-1);

    }
    
    public List<String> validStrings(int n) 
    {
        List<String> ans=new ArrayList<>();
        generate(n,0,ans,new StringBuilder());
        return ans;
        
    }
}