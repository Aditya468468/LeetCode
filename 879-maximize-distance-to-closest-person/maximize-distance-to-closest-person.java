class Solution 
{
    private int left(ArrayList<Integer> list,int k)
    {
        int low=0;
        int high=list.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid)>=k)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return high;
    }

    private int right(ArrayList<Integer> list,int k)
    {
        int low=0;
        int high=list.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid)<=k)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return low;
    }
    public int maxDistToClosest(int[] seats) 
    {
        int n=seats.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<seats.length;i++)
        {
            if(seats[i]==1)
            {
                list.add(i);
            }
        }
        int maxDis=0;
        for(int i=0;i<seats.length;i++)
        {
            if(seats[i]!=1)
            {
                int leftIdx=left(list,i);
                int rightIdx=right(list,i);
                int dis;
                if(leftIdx==-1) // If left is not there,All depends on Right
                {
                    int closestRight=list.get(rightIdx);
                    dis=closestRight-i;

                }
                else if(rightIdx==list.size())
                {
                    int closestLeft=list.get(leftIdx);
                    dis=i-closestLeft;
                }
                else
                {
                    int closestRight=list.get(rightIdx);
                    int closestLeft=list.get(leftIdx);
                    dis=Math.min((i-closestLeft),(closestRight-i));
                }
                maxDis=Math.max(maxDis,dis);
            }
        }
            return maxDis;
        
    }
}