class Solution {
    public boolean areAlmostEqual(String s1, String s2) 
    {
        if(s1.equals(s2))
        {
            return true;
        }
        int idx1=-1;
        int idx2=-1;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                if(idx1==-1) idx1=i;
                else if(idx2==-1) idx2=i;
                else return false;
            }
        }
        if(idx2==-1) return false;
        if(s1.charAt(idx1)==s2.charAt(idx2) && s1.charAt(idx2)==s2.charAt(idx1))
        {
            return true; //cross=matching
        }
        return false;
    }
}