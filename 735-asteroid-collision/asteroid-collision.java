class Solution {
    public int[] asteroidCollision(int[] asteroids) 
    {
        Stack<Integer> st=new Stack<>();
        int n=asteroids.length;
        
        for(int i=0;i<n;i++)
        {   
            
            if(st.isEmpty())
            {
                st.push(asteroids[i]);
                continue;
            }
            int top=st.peek();
            //Lets Determine the Direction of Asteroid
            int currAsteroid=asteroids[i];
            boolean direction=true; // same 
            if(currAsteroid<0 && top>0)
            {
                direction=false; // opposite inwards 
            }
         
            if(direction) // same direction-> Just Push it
            {
                st.push(currAsteroid);
            }
            else 
            {
                //Who survies
                int absTop=Math.abs(top);
                int absAsteroid=Math.abs(currAsteroid);
                if(absTop==absAsteroid)
                {
                    st.pop(); //No one survives
                    continue;
                }
                else if(absTop>absAsteroid)
                {
                    continue; // Top one remains as it is
                }
                else
                {
                    while(!st.isEmpty() && st.peek()>0 && Math.abs(st.peek())<absAsteroid)
                    {
                        st.pop(); // update the top
                    }
                    if(st.isEmpty())
                    {
                        st.push(currAsteroid);  //Put with its sign,Last survival
                    }
                     else if (st.peek()<0) {
                        // They are moving away now
                        st.push(currAsteroid);
                    }
                    else if (Math.abs(st.peek())==absAsteroid) {
                        // Both destroyed
                        st.pop();
                    }                                                            
                }
            }
        }

        int []survived=new int[st.size()];
        int idx=st.size()-1;
        //Backfill
        while(!st.isEmpty())
        {
            survived[idx]=st.pop();
            idx--;
        }

        return survived;
        
    }
}