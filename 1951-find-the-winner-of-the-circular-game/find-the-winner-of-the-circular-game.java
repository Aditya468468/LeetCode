class Solution 
{
    private int winner(int idx,ArrayList<Integer> nums,int k)
    {
        if(nums.size()==1)
        {
            return nums.get(0);
        }
        int ind=(idx+k-1)%nums.size();
        nums.remove(ind);
        return winner((ind)%nums.size(),nums,k);

    }
    public int findTheWinner(int n, int k) 
    {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            list.add(i);
        }
        return winner(0,list,k);
        
    }
}