class Solution {
    public int robotSim(int[] commands, int[][] obstacles) 
    {
        HashMap<Character,Character> map1=new HashMap<>();
        HashMap<Character,Character> map2=new HashMap<>();
        // -2 Mapping 
        map1.put('N','W');
        map1.put('W','S');
        map1.put('S','E');
        map1.put('E','N');
        //-1
        map2.put('N','E');
        map2.put('W','N');
        map2.put('S','W');
        map2.put('E','S');

        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<obstacles.length;i++)
        {
            List<Integer> temp=new ArrayList<>();
            temp.add(obstacles[i][0]);
            temp.add(obstacles[i][1]);
            set.add(temp);
        }
    
        int maxDistance=Integer.MIN_VALUE;
        int x=0;
        int y=0;
        char curr='N';
        boolean started=false; // to handle-> Obstacle at 0,0
        for(int i=0;i<commands.length;i++)
        {
           // if(i==0) started=true;
    
            if(commands[i]==-2)
            {
                char change=map1.get(curr);
                curr=change;
            }
            else if(commands[i]==-1)
            {
                char change=map2.get(curr);
                curr=change;
            }
            else
            {
            for(int move=0;move<commands[i];move++)
            {
                int nextX=x;
                int nextY=y;
                if(curr=='N') nextY++;
                else if(curr=='S') nextY--;
                else if(curr=='E') nextX++;
                else nextX--;
                List<Integer> temp=new ArrayList<>();
                temp.add(nextX);
                temp.add(nextY);
                if(set.contains(temp))
                {
                    break;
                }
                x=nextX;
                y=nextY;

            }

            int distance=(int)Math.pow(x,2)+(int)Math.pow(y,2);
            if(distance>maxDistance) maxDistance=distance;
            }

        }

        return maxDistance;
    }
}