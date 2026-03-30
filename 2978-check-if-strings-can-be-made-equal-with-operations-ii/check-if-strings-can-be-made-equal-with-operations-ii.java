class Solution {
    public boolean checkStrings(String s1, String s2) 
    {
        //odd replaces odd, and even replaces even
        // Lets Match s1 to s2.
        char []nums1=s1.toCharArray();
        char []nums2=s2.toCharArray();
        int n=nums1.length;
        HashMap<Character,Integer> even=new HashMap<>();
        HashMap<Character,Integer> odd=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char x=nums1[i];
            if(i%2==0) even.put(x,even.getOrDefault(x,0)+1);
            else odd.put(x,odd.getOrDefault(x,0)+1);
        }
        // Lets Match.
        for(int i=0;i<n;i++)
        {
            // if(nums1[i]!=nums2[i])//Even if characters are equal at a position, they still “consume” one occurrence from the available pool.
            // {
                if(i%2==0)
                {
                    if(!even.containsKey(nums2[i]))
                    {
                        return false;
                    }
                    even.put(nums2[i],even.get(nums2[i])-1);
                    if(even.get(nums2[i])==0) even.remove(nums2[i]);
                }
                else 
                {
                    if(!odd.containsKey(nums2[i]))
                    {
                        return false;
                    }
                    odd.put(nums2[i],odd.get(nums2[i])-1);
                    if(odd.get(nums2[i])==0) odd.remove(nums2[i]);
                }
           // }
        }

        return true;
        
    }
}