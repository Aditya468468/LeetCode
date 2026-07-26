class Solution {
    public int findContentChildren(int[] g, int[] s) 
    {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        int count=0;
        while(i<g.length && j<s.length)
        {
            if(g[i]<=s[j]) // Can satsify 
            {
                count++; //Lets Count it 
                i++;
            }
            j++; // It will inc in both scenarios, As if it satisfies Fine count it ..If not it cant satisfy anyone as Greed Fact is sorted in asc order,if it cant satisfy the lowest, It cant satisfy the further ones
        }

        return count;

    }
}