class Solution {
    public int maximumLength(int[] nums) 
    {
        int maxLen=0;
        HashMap<Long,Integer> map=new HashMap<>();
        for(long x:nums)
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        if(map.containsKey(1L))
        {
            int count=map.get(1L);
            if(count%2==0) // we neeed off count only, 1,1,1 
            //or 1,1,1,1,1 Or Sooo on..
            {
                count--;
            }
            maxLen=Math.max(maxLen,count);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1) continue; //Already Handled.
            int check=(int)Math.sqrt(nums[i]); // 1's would have caused infinite loop.
            if(check*check==nums[i] && map.containsKey(check)) continue; // It cant be starting x.
            long elem=nums[i];
            int len=0;
            int p=1;
            boolean single=false;
            while(true)
            {
                if(!map.containsKey(elem)) break;
                int count=map.get(elem);
                if(count>=2) len+=2;
                else if(count==1)
                {
                    single=true;
                    len+=1;
                    break;
                }
                elem=elem*elem;
            }
            if(!single) len--; // if we dont have any single elem
            // We need to make it Odd len as ques said-- x1,x2...last...xn...x1 .. So The last elem just comes ones...soo if get it its good else . we make len odd to handle it
            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
        
    }
}