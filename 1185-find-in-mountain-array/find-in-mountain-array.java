/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution 
{
    public int findPeak(MountainArray arr,int n)
    {
        if(arr.get(0)>arr.get(1)) return 0;
        if(arr.get(n-1)>arr.get(n-2)) return n-1;
        int low=1;
        int high=n-2;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int midLeft=arr.get(mid-1);
            int midRight=arr.get(mid+1);
            int midElem=arr.get(mid);
            if(midElem>midLeft && midElem>midRight)
            {
                return mid;
            }
            else if(midElem>midLeft)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return -1;

    }
    public int searchLeft(int target,MountainArray arr, int peak)
    {
        int low=0;
        int high=peak;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int midElem=arr.get(mid);
            if(midElem==target)
            {
                return mid;
            }
            else if(midElem<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
        
    }
    public int searchRight(int target,MountainArray arr, int peak,int n)
    {
        int low=peak+1;
        int high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int midElem=arr.get(mid);
            if(midElem==target)
            {
                return mid;
            }
            else if(midElem<target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1;
        
    }

    public int findInMountainArray(int target, MountainArray mountainArr) 
    {
        int n=mountainArr.length();
        if(n<3) return -1;
        int peakIdx=findPeak(mountainArr,n);
        if(peakIdx==-1) return -1;
        int left=searchLeft(target,mountainArr,peakIdx);
        if(left!=-1) return left;
        int right=searchRight(target,mountainArr,peakIdx,n);
        if(right!=-1) return right;

        return -1;

        
    }
}