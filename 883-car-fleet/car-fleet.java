class Car
{
    int position;
    int speed;

    public Car(int position,int speed)
    {
        this.position=position;
        this.speed=speed;
    }
}
class Solution 
{

    public int carFleet(int target, int[] position, int[] speed)
    {
        int n=speed.length;
        List<Car> cars=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            cars.add(new Car(position[i],speed[i]));
        }
        
        cars.sort((a,b)->
        {
            return a.position-b.position;
        });
        
        Stack<Car> st = new Stack<>();

        for(int i=n-1;i>=0;i--) // It will help us more, i can decide can ith catch top's fleet, rather then can top fleet can catch ith
        { 
            if(st.isEmpty())
            {
                st.push(cars.get(i));
            }
            else
            {
                int s=cars.get(i).speed;
                int p= cars.get(i).position;
                if(s>st.peek().speed) //it can catch.
                {
                    //but will it catch within target
                    double relativeDistance=st.peek().position-p;
                    double relativeSpeed=s-st.peek().speed;
                    double time=relativeDistance/relativeSpeed;
                    double newPosition=p+(time*s);
                    if(newPosition<=target) // Yes it will catch it
                    {
                        continue;
                    }
                    else
                    {
                        st.push(cars.get(i)); // It cant catch will be a part of new fleet.
                    }
                    
                }
                else
                {
                    st.push(cars.get(i));
                    // if speed of ith is less or equal, it cant catch,
                    // Will be part of new fleet.
                }
            }

        }

        return st.size();


    }
}