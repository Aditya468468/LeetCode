class Pair
    {
        int x;
        int y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }

    }

class Solution 
{
    private void specialZ(StringBuilder str,int currX,int currY)
    {
        if(currY==0) // Same Col==0.
        {
            for(int i=0;i<5-currX;i++)
            {
                str.append('D');
            }
            return;
        }
        else
        {
            for(int i=0;i<4-currX;i++)
            {
                str.append('D');
            }

            for(int i=0;i<currY;i++)
            {
                str.append('L');
            }

        }
        //LastDown
        str.append('D');

    }
    public String alphabetBoardPath(String target) 
    {
        Pair[] pos=new Pair[26];
        int x=0;
        int y=0;
        for(int i=0;i<26;i++)
        {
            pos[i]=new Pair(i/5,i%5); 
            
        } // 0->a, 1->b...25->z.

        StringBuilder str=new StringBuilder();
        int currX=0;
        int currY=0;
        for(int i=0;i<target.length();i++)
        {
            char ch=target.charAt(i);
            if(ch=='z')
            {
                specialZ(str,currX,currY);
                str.append('!');
                currX=5;
                currY=0;
                continue;
            }
            int idx=ch-'a';
            int nextX=pos[idx].x;
            int nextY=pos[idx].y;
            if(currX==nextX && currY==nextY)
            {
                str.append('!');
                continue;
            }
            if(currX==5 && currY==0) //Z
            {
                int steps=5-nextX;
                for(int j=0;j<steps;j++)
                {
                    str.append('U');
                    currX--;
                }
                //int steps=nextY;
                for(int j=0;j<nextY;j++)
                {
                    str.append('R');
                    currY++;
                }
                str.append('!');
                continue; 
            }
            // X-Axis.
            if(currX<nextX)
            {
                int steps=nextX-currX;
                for(int j=0;j<steps;j++)
                {
                    str.append('D');
                    currX++;
                }

            }
            else
            {
                int steps=currX-nextX;
                for(int j=0;j<steps;j++)
                {
                    str.append('U');
                    currX--;
                } 

            }
            //Y-axis.
            if(currY<nextY)
            {
                int steps=nextY-currY;
                for(int j=0;j<steps;j++)
                {
                    str.append('R');
                    currY++;
                } 
            }
            else
            {
                int steps=currY-nextY;
                for(int j=0;j<steps;j++)
                {
                    str.append('L');
                    currY--;
                } 

            }
            //After Both-> I should be at the Element (expect Z)
            str.append('!');

        }


        return str.toString();




    
        
    }
}