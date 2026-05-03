class Solution {

    private int find(int idx,List<Integer> list,int k)
    {
        if(list.size()==1)
        {
            return list.get(0);
        }
        //eliminate,
        int i=(idx+k-1)%list.size();
        list.remove(i);
        return find(i%list.size(),list,k);

    }
    public int findTheWinner(int n, int k) 
    {
        //lets prepare the List.
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            list.add(i);
        }

        return find(0,list,k);
        
    }
}