class Solution 
{
    int count=0;
    public void generate(int []digits,Set<Integer> set,StringBuilder str,boolean[]used)
    {
        if(str.length()==3)
        {
            int num=Integer.parseInt(str.toString());
            if(set.contains(num)) return;

            if(num%2==0)
            {
                count++;
                set.add(num);
            }
            return;
        }
        if(str.length()>3) return;
        for(int i=0;i<digits.length;i++)
        {
            if(used[i]) continue;
            if(str.length()==0 && digits[i]==0) continue;
            used[i]=true;
            str.append(digits[i]);
            generate(digits,set,str,used);
            used[i]=false;
            str.deleteCharAt(str.length()-1);
        }

    }
    public int totalNumbers(int[] digits) 
    {
        int n=digits.length;
        Set<Integer> uniqueEvens = new HashSet<>();
        boolean[] used = new boolean[digits.length];

        generate(digits,uniqueEvens,new StringBuilder(),used);

        return count;
        
    }
}