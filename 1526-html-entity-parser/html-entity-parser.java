class Solution {
    public String entityParser(String text) 
    {
        int n=text.length();
        HashMap<String,String> map=new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(text.charAt(i)=='&')
            {
                int j=i;
                while(j<n && text.charAt(j)!=';')
                {
                    j++;
                }
                if(j<text.length())
                {
                    String replace=text.substring(i,j+1);
                    if(map.containsKey(replace))
                    {
                        ans.append(map.get(replace));
                        i=j;
                        continue;
                    }

                }

            }
            
            ans.append(text.charAt(i));
            
        }

        return ans.toString();
        



        
        
    }
}