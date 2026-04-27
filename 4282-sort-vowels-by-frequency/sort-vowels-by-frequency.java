class Solution {
    public boolean isVowel(char c)
    {
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
        return false;
    }
    public String sortVowels(String s) 
    {
        char []nums=s.toCharArray();
        int n=nums.length;
        
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> first=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char x=nums[i];
            if(!isVowel(x)) continue;
            if(!first.containsKey(x))
            {
                first.put(x,i);
            }
            map.put(x,map.getOrDefault(x,0)+1);
        }
        //Sorting.
        List<Map.Entry<Character,Integer>> list=new ArrayList<>(map.entrySet());
         if(list.size()==0) return s;
        Collections.sort(list,(a,b)->
        {
            if(!a.getValue().equals(b.getValue()))
            {
                return b.getValue()-a.getValue();
            }
            return first.get(a.getKey())-first.get(b.getKey()); // Sorting based on FirstIdx.
        });
        //ReBuild.
        StringBuilder str=new StringBuilder(s);
        int idx=0;
        for(int i=0;i<s.length();i++)
        { 
            if(!isVowel(s.charAt(i))) continue;
            if(list.get(idx).getValue()==0)
            {
                idx++;
            }
            char x=list.get(idx).getKey();
            str.setCharAt(i,x);
            list.get(idx).setValue(list.get(idx).getValue() - 1); // Updating 
        }

        return str.toString();
        
    }
}