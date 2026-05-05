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

    private void comb(int idx,String digits,List<String> ans,StringBuilder str)
    {
        if(str.length()==digits.length())
        {
            ans.add(new String(str.toString()));
            return;
        }
        String curr=map.get(digits.charAt(idx));
        for(int i=0;i<curr.length();i++)
        {
            str.append(curr.charAt(i));
            comb(idx+1,digits,ans,str);
            str.deleteCharAt(str.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) 
    {
        List<String> ans=new ArrayList<>();
        comb(0,digits,ans,new StringBuilder());

        return ans;

        
    }
}