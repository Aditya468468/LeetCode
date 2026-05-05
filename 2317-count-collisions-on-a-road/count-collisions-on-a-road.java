class Solution {
    public int countCollisions(String directions) 
    {
        Stack<Character> s=new Stack<>();
        int n=directions.length();
        s.push(directions.charAt(0));
        int coll=0;
        for(int i=1;i<n;i++)
        {
            char c=directions.charAt(i);
            if(!s.isEmpty() && s.peek()=='R' && c=='L')
            {
                coll+=2;
                s.pop();
                while(!s.isEmpty() && s.peek()=='R')
                {
                    s.pop();
                    coll+=1;
                }
                s.push('S');
                
            }
            else if(!s.isEmpty() && s.peek()=='S' && c=='L')
            {
                coll+=1;
            }
            else if(!s.isEmpty() && s.peek()=='R' && c=='S')
            {
                coll+=1;
                s.pop();
                while(!s.isEmpty() && s.peek()=='R')
                {
                    s.pop();
                    coll+=1;
                }
                s.push('S');
            }
            else 
            {
                s.push(c);
                
            }
        }

        return coll;
        
    }
}