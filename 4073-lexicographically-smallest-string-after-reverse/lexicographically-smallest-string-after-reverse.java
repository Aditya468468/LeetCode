class Solution 
{
    private String reverse_End(StringBuilder s,int k)
    {
        int i=k;
        int j=s.length()-1;
        while(i<j)
        {
            char x=s.charAt(i);
            s.setCharAt(i,s.charAt(j));
            s.setCharAt(j,x);
            i++;
            j--;
        }
        return s.toString();
    }
    private String reverse_Start(StringBuilder s,int k)
    {
        int i=0;
        int j=k;
        while(i<j)
        {
            char x=s.charAt(i);
            s.setCharAt(i,s.charAt(j));
            s.setCharAt(j,x);
            i++;
            j--;
        }
        return s.toString();
    }
    public String lexSmallest(String s) 
    {
        String s_temp=new String(s);
        List<String> list=new ArrayList<>();
        int k=0;
        for(int i=0;i<s.length();i++)
        {
            StringBuilder str=new StringBuilder(s);
            list.add(reverse_Start(str,i));
        }

        for(int i=s.length();i>=0;i--)
        {
            StringBuilder str=new StringBuilder(s_temp);
            list.add(reverse_End(str,i));
        }
        Collections.sort(list);

        return list.get(0);

        
    }
}