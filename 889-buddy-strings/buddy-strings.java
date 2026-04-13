class Solution {
    public boolean buddyStrings(String s, String goal) 
    {
        int n=s.length();
        if(n!=goal.length()) return false;

        if(s.equals(goal))
        {
            HashMap<Character,Integer> map=new HashMap<>();
            for(char x:s.toCharArray())
            {
                map.put(x,map.getOrDefault(x,0)+1);
                if(map.get(x)>1) return true;
            }
            return false;
        }
        int idx1=-1;
        int idx2=-1;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)!=(goal.charAt(i)))
            {
                if(idx1==-1) idx1=i;
                else if(idx2==-1) idx2=i;
                else return false;
            }
        }

        if(idx2==-1) return false;
        if(s.charAt(idx1)==goal.charAt(idx2) && s.charAt(idx2)==goal.charAt(idx1))
        {
            return true;
        }
        return false;
    }
}