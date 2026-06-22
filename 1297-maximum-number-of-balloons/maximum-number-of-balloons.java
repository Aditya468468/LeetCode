class Solution {
    public int maxNumberOfBalloons(String text) 
    {

        HashMap<Character,Integer> map=new HashMap<>();
        for(char x:text.toCharArray())
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int min=Integer.MAX_VALUE;
        String s="balloon";
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(!map.containsKey(x)) return 0;
            int val=map.get(x);
            if(x=='l') val/=2;
            else if(x=='o') val/=2;
            min=Math.min(val,min);
        }

        return min;
        
        
    }
}