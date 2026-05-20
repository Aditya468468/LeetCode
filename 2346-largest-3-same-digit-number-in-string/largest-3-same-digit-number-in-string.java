class Solution {
    public String largestGoodInteger(String num) 
    {
        Map<Character,Integer> map=new HashMap<>();
        Set<String> set=new HashSet<>();
        int left=0;
        for(int right=0;right<num.length();right++)
        {
            char x=num.charAt(right);
            map.put(x,map.getOrDefault(x,0)+1);
            if(right-left+1>3)
            {
                char c=num.charAt(left);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                {
                    map.remove(c);
                }
                left++;
            }
            if(right-left+1==3)
            {
                if(map.size()==1)
                {
                    String val=num.substring(left,right+1);
                    if(!set.contains(val)) set.add(val);
                }

            }
        }
        //
        ArrayList<String> list=new ArrayList<>(set);
        if(list.size()==0) return "";
        Collections.sort(list);
        return list.get(list.size()-1);

    }
}