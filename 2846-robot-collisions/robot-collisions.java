class Robot
{
    int position;
    int health;
    char dir;
    int originalIdx;

    public Robot(int position,int health,char dir,int originalIdx)
    {
        this.position=position;
        this.health=health;
        this.dir=dir;
        this.originalIdx=originalIdx;
    }
}

class Solution 
{
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) 
    {
        List<Robot> robots=new ArrayList<>();
        int n=positions.length;

        for(int i=0;i<n;i++)
        {
            robots.add(new Robot(positions[i],healths[i],directions.charAt(i),i));
        }

        robots.sort((a,b)->
        {
            return a.position-b.position;
        });
        // Now everything will be processed in Order
        Stack<Robot> st=new Stack<>();

        for(int i =0;i<n;i++)
        {
            Robot r=robots.get(i);
            if(r.dir=='R') // We need R at Top and L incoming for collison
            {
                st.push(r);
            }
            else
            {
                while(!st.isEmpty() && st.peek().dir=='R' && st.peek().health<r.health)
                {
                    st.pop();
                    r.health--;
                }
                if(st.isEmpty() || st.peek().dir=='L')
                {
                    st.push(r);
                }
                else if(!st.isEmpty() && st.peek().dir=='R' && st.peek().health>r.health)
                {
                    st.peek().health--;
                }
                else if(!st.isEmpty() && st.peek().health==r.health)
                {
                    st.pop();
                }

            }

        }

        int[] ans = new int[positions.length];

        while (!st.isEmpty()) 
        {
            Robot r = st.pop();
            ans[r.originalIdx] = r.health;
        }

            List<Integer> list = new ArrayList<>();

            for (int h : ans) {
                if (h > 0) 
                {
                    list.add(h);
                }
            }
            return list;            
        
    }
}