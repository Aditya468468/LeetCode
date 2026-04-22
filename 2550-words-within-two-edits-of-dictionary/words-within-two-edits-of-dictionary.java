class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) 
    {
        int n=queries.length;
        int m=dictionary.length;
        int len=queries[0].length();
        List<String> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String s=queries[i];
            for(int j=0;j<m;j++)
            {
                int diff=0;
                String d=dictionary[j];
                for(int k=0;k<len;k++)
                {
                    if(s.charAt(k)!=d.charAt(k))
                    {
                        diff++;
                        if(diff>2)
                        {
                            break;
                        }
                    }

                }
                if(diff<=2) 
                {
                    list.add(s);
                    break;
                }
            }

        }

        return list;
        
    }
}