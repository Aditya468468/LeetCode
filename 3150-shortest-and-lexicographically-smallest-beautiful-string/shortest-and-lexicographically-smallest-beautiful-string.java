class Solution {
    public String shortestBeautifulSubstring(String s, int k) 
    {
        Map<Character,Integer> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        int left=0;
        int n=s.length();
        String ans="";

        for(int right=0;right<n;right++)
        {
            if(s.charAt(right)=='1')
            {
                map.put('1',map.getOrDefault('1',0)+1);
            }
            while(map.containsKey('1') && map.get('1')>k)
            {
                if(s.charAt(left)=='1')
                {
                    map.put('1',map.get('1')-1);
                }
                if(map.get('1')==0)
                {
                    map.remove('1');
                }

                left++;
            }

            if(map.containsKey('1') && map.get('1')==k) //valid
            {
                while(s.charAt(left)=='0') //Trim the leading zero to get more smaller
                {
                    left++;
                }
                int len=right-left+1;
                if(len<min)
                {
                    min=len;
                    ans=s.substring(left,right+1);
                }
                else if(len==min)
                {
                    String str=s.substring(left,right+1);
                    for(int i=0;i<len;i++)
                    {
                        if(str.charAt(i)<ans.charAt(i))
                        {
                            ans=str;
                            break;
                        }
                        else if(str.charAt(i)>ans.charAt(i)) 
                        {
                            break;
                        }

                    }
                }

            } 

        }

        return ans;
        
    }
}