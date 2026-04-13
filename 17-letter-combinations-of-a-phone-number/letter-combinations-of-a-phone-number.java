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
    public void comb(int idx,String num,List<String> ans,StringBuilder str)
    {
        if(idx==num.length())
        {
            ans.add((new StringBuilder(str)).toString());
            return;
        }

        String s=map.get(num.charAt(idx));
        for(char x:s.toCharArray())
        {
            str.append(x);
            comb(idx+1,num,ans,str);
            str.deleteCharAt(str.length()-1); //backtrack.

        }
    }
    public List<String> letterCombinations(String digits) 
    {
        List<String> ans=new ArrayList<>();
        comb(0,digits,ans,new StringBuilder());

        return ans;
        
    }
}