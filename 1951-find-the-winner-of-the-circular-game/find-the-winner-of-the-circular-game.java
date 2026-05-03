class Solution {
    public int findTheWinner(int n, int k) 
    {
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=1;i<=n;i++)
        {
            q.addLast(i);
        }
        int idx=0;
        while(q.size()>1)
        {
            for(int i=1;i<k;i++)
            {
                q.addLast(q.removeFirst()); //Removing nd Adding.
            }
            q.removeFirst(); //Removing kth Element.
        }
       return q.peek();
        
    }
}