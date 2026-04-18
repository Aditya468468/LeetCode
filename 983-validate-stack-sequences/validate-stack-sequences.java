class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) 
    {
        Stack<Integer> s=new Stack<>();
        int n=pushed.length;
        int idx=0;
        for(int i=0;i<n;i++)
        {
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek()==popped[idx])
            {
                s.pop();
                idx++;
            }
        }

        if(s.isEmpty()) return true;
        return false;
        
    }
}