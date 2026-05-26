class Solution {
    public int numberOfSpecialChars(String s) 
    {
        //Lets Track-> First Idx of Caps.
        //Last Idx -> Small.
        HashMap<Character,Integer> firstCap=new HashMap<>();
        HashMap<Character,Integer> lastSmall=new HashMap<>();

        int n=s.length();

        for(int i=n-1;i>=0;i--)
        {
            char x=s.charAt(i);
            if(Character.isUpperCase(x)) continue;
            if(!lastSmall.containsKey(x))
            {
                lastSmall.put(x,i);
            }
        }
        //
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            if(Character.isLowerCase(x)) continue;
            if(!firstCap.containsKey(x))
            {
                firstCap.put(x,i);
            }
        }
        //Now Lets See->HOW MUCH VALID.
        int cnt=0;
        for(Map.Entry<Character,Integer> it:firstCap.entrySet())
        {
            char key=it.getKey();
            int firstIdx=it.getValue();
            char lower=Character.toLowerCase(key);
            if(!lastSmall.containsKey(lower)) continue;
            int smallIdx=lastSmall.get(lower);
            if(smallIdx<firstIdx)
            {
                cnt++;
            }
        }
        return cnt;
        
    }
}