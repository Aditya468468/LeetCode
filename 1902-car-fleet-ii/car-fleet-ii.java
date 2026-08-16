
class Solution {
    public double[] getCollisionTimes(int[][] cars) 
    {
        int n=cars.length;
        double[]time=new double[n];
        Arrays.fill(time, -1.0);
        Stack<Integer> st=new Stack<>(); //Stores Index of car
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty())
            {
                int j=st.peek();
                if(cars[i][1]<=cars[j][1])
                {
                    st.pop();
                    continue;
                }
                else
                {
                    double t = (double)(cars[j][0]-cars[i][0])/(cars[i][1]-cars[j][1]);
                    if(t<=time[j] || time[j]<0)
                    {
                        time[i]=t;
                        break;
                    }
                   
                        st.pop();
                    
                }
            }

            st.push(i);
          
        }

        return time;


        
    }
}