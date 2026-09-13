class Solution {
    public long shadowPairs(int[] nums) 
    {
        int n=nums.length;
        Stack<List<Integer>> st=new Stack<>();
    // The state the stack will keep will be-> [x,freq(x),value(smaller then x)]
        long count=0;
        long ans=0;

        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && st.peek().get(0)>nums[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                st.push(new ArrayList<>(List.of(nums[i],1,0)));
            }
            else if(!st.isEmpty() && st.peek().get(0)==nums[i])
            {
                ans+=(st.peek().get(2));
                st.peek().set(1,st.peek().get(1)+1);
                
            }
            else if(!st.isEmpty() && st.peek().get(0)<nums[i])
            {
                ans+=(st.peek().get(1)+st.peek().get(2));
                st.push(new ArrayList<>(List.of(nums[i],1,st.peek().get(1)+st.peek().get(2)))); // smaller then it self
            }

        }

        return ans;
        
    }
}