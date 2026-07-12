class Solution {
    public int findContentChildren(int[] g, int[] s) 
    {
        // Two pointer + Sorting-> Greedy
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt=0;
        int i=0;
        int j=0;
        while(i<g.length && j<s.length)
        {
            if(g[i]<=s[j]) // I can satisfy the kid lets move.
            {
                cnt++;
                i++;
                j++;
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