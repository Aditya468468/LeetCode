class Solution {

    private boolean isVowel(char x)
    {
        if (x=='a'|| x=='e' || x=='i' || x=='o' || x=='u')
            {
                return true;
            }
        else
        {
             return false;
        }
         
    }
    public int beautifulSubstrings(String s, int k) 
    {
        char []nums=s.toCharArray();
        Map<Integer,List<Integer>> map=new HashMap<>();//for states.
        Map<Integer,List<Integer>> idx=new HashMap<>();
        int v=0;
        int c=0;
        map.put(0,new ArrayList<>());//Counting prblm.
        map.get(0).add(-1); // -1 idx-> state -> 0
        idx.put(-1,new ArrayList<>());
        idx.get(-1).add(0);
        idx.get(-1).add(0);
        int cnt=0;
        for(int i=0;i<nums.length;i++)
        {
            if(isVowel(nums[i])) v++;
            else c++;
            // prefix State.
            int state=v-c; // vowel-con.
            if(map.containsKey(state))
            {
                List<Integer> temp=map.get(state);
                for(int j=0;j<temp.size();j++)
                {
                    int prevIdx=temp.get(j);
                    int vowels=v-idx.get(prevIdx).get(0);
                    int conso=c-idx.get(prevIdx).get(1);
                    if((long)(vowels*conso)%k==0)
                    {
                        cnt++;
                    }
                }
                
            }
            if(!map.containsKey(state))
            {
                    map.put(state,new ArrayList<>());
            }
            map.get(state).add(i);
            idx.put(i,Arrays.asList(v,c));
        }

        return cnt;
    }
}