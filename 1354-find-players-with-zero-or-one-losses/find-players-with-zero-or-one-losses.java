class Solution {
    public List<List<Integer>> findWinners(int[][] matches) 
    {
        //Winners should not be loosers
        // and Lossers who dont lose more than one (like Me)
        
        HashMap<Integer,Integer> loosers=new HashMap<>();

        for(int i=0;i<matches.length;i++)
        {
            int loss=matches[i][1];
            loosers.put(loss,loosers.getOrDefault(loss,0)+1);
        }
        //
        Set<Integer> won=new TreeSet<>();
        Set<Integer> lost=new TreeSet<>();


        for(int i=0;i<matches.length;i++)
        {
            int win=matches[i][0];
            int loss=matches[i][1];
            
            //Win who hasnt lost match will not be in loosers list.
            if(!loosers.containsKey(win))
            {
                if(!won.contains(win))
                {
                    won.add(win);
                }
            }
            //If its looser the count=1;
            if(loosers.get(loss)==1)
            {
                lost.add(loss);
            }
        }

        List<List<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>(won));
        list.add(new ArrayList<>(lost));

        return list;
        
    }
}