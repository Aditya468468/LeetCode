class Solution {
    public String removeDuplicateLetters(String s) 
    {
        int n=s.length();
        Set<Character> set=new HashSet<>();
        // Will Track elements in Set currently
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            map.put(x,i);
        }

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++)
        {
            if(set.contains(s.charAt(i)))
            {
                continue;
            }
            while(!st.isEmpty() && s.charAt(st.peek())>s.charAt(i) && map.get(s.charAt(st.peek()))>i)
            {
                set.remove(s.charAt(st.pop()));

            }
            st.push(i);
            set.add(s.charAt(i));
        }

        StringBuilder str=new StringBuilder();

        while(!st.isEmpty())
        {
            str.append(s.charAt(st.pop()));
        }

        return str.reverse().toString();
    
        
    }
}