class Solution {
    public char findTheDifference(String s, String t) 
    {
        char mask=' ';
        for(char x:s.toCharArray())
        {
            mask^=x;
        }
        for(char x:t.toCharArray())
        {
            mask^=x;
        }

        return Character.toLowerCase(mask);
        
    }
}