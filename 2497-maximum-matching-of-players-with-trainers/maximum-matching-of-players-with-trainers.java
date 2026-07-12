class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) 
    {
      
        // Two pointer + Sorting-> Greedy
        Arrays.sort(players);
        Arrays.sort(trainers);
        int cnt=0;
        int i=0;
        int j=0;
        while(i<players.length && j<trainers.length)
        {
            if(players[i]<=trainers[j]) // I can satisfy the kid lets move.
            {
                cnt++;
                i++;
                j++; // Assigned so Move.
            }
            else
            {
                j++; // I cant satisfy ith kid nd as its sorted, definetly i cant
                    // satsify the i+1 kid,soo inc j++ to find bigger ones.
            }

        }

        return cnt;
        
        
    }
}