class Solution {
    class Pair
    {
        char x;
        int count;
        public Pair(char x,int count)
        {
            this.x=x;
            this.count=count;
        }
    }
    public List<Pair> build(String s)
    {
        List<Pair> list=new ArrayList<>();
        int i=0;
        while(i<s.length())
        {
            char ch=s.charAt(i);
            int cnt=0;
            while(i<s.length() && s.charAt(i)==ch)
            {
                cnt++;
                i++;
            }
            list.add(new Pair(ch,cnt));
        }
        return list;

    }
    public boolean isLongPressedName(String name, String typed) 
    {

        List<Pair> n=build(name);
        List<Pair> t=build(typed);
        if(n.size()!=t.size()) return false;
        for(int i=0;i<n.size();i++)
        {
            if(n.get(i).x!=t.get(i).x) return false;
            if(n.get(i).count>t.get(i).count) return false;
        }
        
        return true;
        
    }
}