class Solution {
    public String maximumNumber(String num, int[] change) 
    {
        char[]nums=num.toCharArray();
        int n=nums.length;
        boolean isTaken=false;
        for(int i=0;i<n;i++)
        {
            int value=nums[i]-'0';
            int newValue=change[value];
            if(newValue>value)
            {
               
                nums[i]=(char)(newValue+'0');
                isTaken=true;
            }
            else if(newValue < value)// Because we select substrings...
            {
                if(isTaken==true) break; //and we can only take "One" so if i have taken and it fails we stop.
                
            } 
            // == cond we just skip it..why to take it
        }
        return new String(nums);
        
    }
}