class Solution {
    public int totalFruit(int[] fruits) 
    {
        // So i have 2 baskets, and we need to see, how many fruits we can cover
        //-> map.size()<=2
        Map<Integer,Integer> map=new HashMap<>();

        int maxFruits=0;
        int left=0;
        int n=fruits.length;

        for(int right=0;right<n;right++)
        {
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2)
            {
                int f=fruits[left];
                map.put(f,map.get(f)-1);
                if(map.get(f)==0)
                {
                    map.remove(f);
                }
                left++;
            }

            int len=right-left+1;
            maxFruits=Math.max(maxFruits,len);
        }

        return maxFruits;

        
    }
}