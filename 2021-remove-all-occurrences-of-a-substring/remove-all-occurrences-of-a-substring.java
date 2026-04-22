class Solution {
    public String removeOccurrences(String s, String part) 
    {
        StringBuilder str=new StringBuilder(s);
        int p=part.length(); // i need to just see this much of my left.
        for(int i=p-1;i<str.length();i++)
        {
            if (i - p + 1 < 0) continue;
            String segment=str.substring(i-p+1,i+1);
            if(segment.equals(part))
            {
                str.delete(i-p+1,i+1);
                i=i-p;
                if (i<0) i=-1;
            }
        }

        return str.toString();
        
    }
}