class Solution {
    public boolean canMakeSubsequence(String str1, String str2) 
    {
        //I will be using the Concept used in Q->isSubsequence.
        //i need to see can i make str2 a sub of str1.
        //-> Matching element=Str2, Matched with->Str1.
        //-> I can go to  +1, eg:- d->{c}, z->{a}.
        //We move if we can find char x in str1, which can be formed using +1.
        //As i can take A set of indices->Any / No Constraints on it.

        int idx=0;
        int n=str2.length();
        int i=0;
        while(i<str1.length() && idx<n)
        {
            char x=str1.charAt(i);
            char ch=str2.charAt(idx);
            int right=(x-'a'+1)%26;
            char rightPos=(char)(right+'a');
            if(x==ch || ch==rightPos)
            {
                idx++;
            }
            i++;
        }

        return idx==n;
        
        
    } 
}