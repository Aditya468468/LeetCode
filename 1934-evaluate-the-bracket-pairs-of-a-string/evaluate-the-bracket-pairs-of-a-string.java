class Solution {
    public String evaluate(String s, List<List<String>> knowledge) 
    {
        Map<String,String> map=new HashMap<>();
        for(int i=0;i<knowledge.size();i++)
        {
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        //Map is Done
        StringBuilder str=new StringBuilder();
        int open=0;
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if((s.charAt(i)!='(' && s.charAt(i)!=')') && open==0)
            {
                str.append(s.charAt(i));
            }
            else
            {
                if(s.charAt(i)=='(')
                {
                    open++;
                }
                else if(s.charAt(i)==')')
                {
                    str.append(map.getOrDefault(temp.toString(),"?"));
                    temp.setLength(0);
                    open--;
                }
                else
                {
                    temp.append(s.charAt(i));

                }

            }
            
        }
        
        return str.toString();
    }
}