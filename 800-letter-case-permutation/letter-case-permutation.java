class Solution 
{
    private void generate(int idx, String s, StringBuilder str,List<String> ans)
    {
        if(idx==s.length())
        {
            ans.add(new StringBuilder(str).toString());
            return;
        }
        //
        char x=s.charAt(idx);
        if(!Character.isDigit(x))
        {
            //Append both of its forms.
            str.append(Character.toUpperCase(x));
            generate(idx+1,s,str,ans);
            str.deleteCharAt(str.length()-1); // Back track.
            //Now Lets put lower case.
            str.append(Character.toLowerCase(x));
            generate(idx+1,s,str,ans);
            str.deleteCharAt(str.length()-1);
        }
        else
        {
            str.append(x);
            generate(idx+1,s,str,ans);
            str.deleteCharAt(str.length()-1);
        }
    }
    public List<String> letterCasePermutation(String s) 
    {
        List<String> list=new ArrayList<>();
        generate(0,s,new StringBuilder(),list);

        return list;

        
    }
}