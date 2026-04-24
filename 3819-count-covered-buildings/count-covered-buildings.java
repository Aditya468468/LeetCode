class Solution {
    private int binary(List<Integer> list,int x)
    {
        int low=0;
        int high=list.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid)==x)
            {
                return mid;
            }
            else if(list.get(mid)>x)
            {
                high=mid-1;
            }
            else 
            {
                low=mid+1;
            }
        }
            return -1;
    }

        
    public int countCoveredBuildings(int n, int[][] buildings) 
    {
        HashMap<Integer,List<Integer>> x=new HashMap<>();
        HashMap<Integer,List<Integer>> y=new HashMap<>();
        //Precompute.
        for(int i=0;i<buildings.length;i++)
        {
            int xA=buildings[i][0];
            int yA=buildings[i][1];
            if(!x.containsKey(xA))
            {
                x.put(xA,new ArrayList<>());
            }
            x.get(xA).add(yA);

            if(!y.containsKey(yA))
            {
                y.put(yA,new ArrayList<>());
            }
            y.get(yA).add(xA);

        }
        //Lets Sort-> Easy to find Neg.
        for (List<Integer> list : x.values()) 
        {
            Collections.sort(list);
        }
        for (List<Integer> list : y.values()) 
        {
            Collections.sort(list);
        }
        //Lets count.
        int cnt=0;
        for(int i=0;i<buildings.length;i++)
        {
            int x_cor=buildings[i][0];
            int y_cor=buildings[i][1];
            //
            boolean x_neg=false;
            List<Integer> l1=x.get(x_cor);
            int idx=binary(l1,y_cor);
            if(idx>0 && idx<l1.size()-1)
            {
                x_neg=true;
            }
            //
            boolean y_neg=false;
            List<Integer> l2=y.get(y_cor);
            idx=binary(l2,x_cor);
            if(idx>0 && idx<l2.size()-1)
            {
                y_neg=true;
            }
            if(x_neg && y_neg)
            {
                cnt++;
            }

            
        }
        
        return cnt;

    }
}