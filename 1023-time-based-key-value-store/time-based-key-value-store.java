
class Pair
{
    int timestamp;
    String value;
    public Pair(int timestamp,String value)
    {
        this.timestamp=timestamp;
        this.value=value;
    }

}
class TimeMap 
{

    Map<String,List<Pair>> map;
    public TimeMap() 
    {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) 
    {
        Pair p=new Pair(timestamp,value);
        if(!map.containsKey(key))
        {
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(p);
    }
    
    public String get(String key, int timestamp) 
    {
        if(!map.containsKey(key)) return "";
        List<Pair> list=map.get(key);
        int low=0;
        int high=list.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid).timestamp<=timestamp)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        if(high<0) return ""; // 3,5,7 and .. We need <=1, so high<0.
        return list.get(high).value;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */