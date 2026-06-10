class Solution 
{
    static Map<Character,String> map=new HashMap<>();
    static
    {
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    private void generate(int idx,String digits,StringBuilder str,List<String> ans)
    {
        if(idx==digits.length())
        {
            ans.add(new StringBuilder(str).toString());
            return;
        }
        String s=map.get(digits.charAt(idx));
        for(int i=0;i<s.length();i++)
        {
            str.append(s.charAt(i));
            generate(idx+1,digits,str,ans);
            str.deleteCharAt(str.length()-1);
        }

    }
    public List<String> letterCombinations(String digits) 
    {
        List<String> ans=new ArrayList<>();
        generate(0,digits,new StringBuilder(),ans);

        return ans;
       
    }
}