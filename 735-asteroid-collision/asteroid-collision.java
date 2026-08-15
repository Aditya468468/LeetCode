class Solution {
    public int[] asteroidCollision(int[] asteroids) 
    {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++)
        {
            if(st.isEmpty())
            {
                st.push(asteroids[i]);
                continue;
            }
            if(!st.isEmpty() && st.peek()<0) // A collison will never happen
            {
                st.push(asteroids[i]);
                continue;
            }
            // Now s.peek()-> +ve collison can happen 
            if(!st.isEmpty() && asteroids[i]>0)
            {
                st.push(asteroids[i]);
            }
            else if(!st.isEmpty() && asteroids[i]<0) //Collison will happen
            {
                if(!st.isEmpty() && st.peek()>Math.abs(asteroids[i]))
                {
                    continue; // The Top survives
                }
                if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i]))
                {
                    st.pop();
                }
                else
                {
                    while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(asteroids[i]))
                    {
                        st.pop();
                    }
                    if(st.isEmpty())
                    {
                        st.push(asteroids[i]);
                    }
                    else if(st.peek()==Math.abs(asteroids[i]))
                    {
                        st.pop();
                    }
                    else if (st.peek() > Math.abs(asteroids[i])) 
                    {
                        continue;
                    }
                    else //st.peek()<0
                    {
                        st.push(asteroids[i]);
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