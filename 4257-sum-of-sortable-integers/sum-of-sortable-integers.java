import java.util.*;

class Solution {

    public boolean rotation(int[] nums,int []sorted, int start, int k)
    {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        for(int i=start;i<start+k;i++)
        {
            set1.add(nums[i]);
            set2.add(sorted[i]);
        }
        if(!set1.equals(set2)) return false;
        int n=nums.length;
        int dip=0;
        for(int i=start+1;i<start+k;i++)
        {
            if(nums[i-1]>nums[i])
            {
                dip++;
                if(dip>1) return false;
            }
            
        }
        if(nums[start]<nums[start+k-1]) dip++;

        return dip<=1;
        
    }

    public int sortableIntegers(int[] nums) 
    {
        int n=nums.length;

        List<Integer> div = new ArrayList<>();
        for(int i=1; i*i<=n;i++)
        {
            if(n%i == 0)
            {
                div.add(i);
                if(i!=n/i) div.add(n/i);
            }
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int sum = 0;
        for(int k:div)
        {
            boolean can = true;

            for(int start = 0; start<n; start += k)
            {
                if(!rotation(nums,sorted,start,k))
                {
                    can=false;
                    break;
                }
            }

            if(can) sum += k;
        }

        return sum;
    }
}