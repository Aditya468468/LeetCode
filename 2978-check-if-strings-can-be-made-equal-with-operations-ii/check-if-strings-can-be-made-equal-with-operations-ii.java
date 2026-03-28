class Solution {
    public boolean checkStrings(String s1, String s2) 
    {
        HashMap<Character,Integer> even=new HashMap<>();
        HashMap<Character,Integer> odd=new HashMap<>();
        // we will match s2
        for(int i=0;i<s2.length();i++)
        {
            char ch=s2.charAt(i);
            if(i%2==0) {
                even.put(ch,even.getOrDefault(ch,0)+1);
            } 
            else 
            {
                odd.put(ch,odd.getOrDefault(ch,0)+1);
            }
        }
        //Lets match
        for(int i=0;i<s1.length();i++)
        {
           // if(s1.charAt(i)!=s2.charAt(i))
            {
                if(i%2==0)
                {
                if(even.containsKey(s1.charAt(i)) && even.get(s1.charAt(i))>0)
                    {
                        even.put(s1.charAt(i),even.get(s1.charAt(i))-1);
                    }
            else if(!even.containsKey(s1.charAt(i)) || even.get(s1.charAt(i))==0)
                    {

                        return false;
                    }
                }
                else 
                {
                if(odd.containsKey(s1.charAt(i))&&odd.get(s1.charAt(i))>0)
                    {
                        odd.put(s1.charAt(i),odd.get(s1.charAt(i))-1);
                    }
            else if(!odd.containsKey(s1.charAt(i)) || odd.get(s1.charAt(i))==0)
                    {
                        return false;
                    }

                }

            }
        }
        return true;
    }
}