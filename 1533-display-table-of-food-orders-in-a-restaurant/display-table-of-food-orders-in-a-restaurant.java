class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) 
    {
        int n=orders.size();
         Map<String, Map<String, Integer>> map = new TreeMap<>((a,b) -> Integer.parseInt(a)-Integer.parseInt(b));
        Set<String> items=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            String table = orders.get(i).get(1);
            String item = orders.get(i).get(2);
            if(!items.contains(item))
            {
                items.add(item);
            }
            if(!map.containsKey(table))
            {
                map.put(table,new HashMap<>());
            }
    
            map.get(table).put(item,map.get(table).getOrDefault(item,0)+1);
        }
        List<String> food=new ArrayList<>(items);
        Collections.sort(food);
        List<String> header=new ArrayList<>();
        header.add("Table");
        header.addAll(food);
        List<List<String>> content=new ArrayList<>();
        content.add(header);
        for(Map.Entry<String,Map<String,Integer>> data:map.entrySet())
        {
            String table=data.getKey();
            Map<String,Integer> fI=data.getValue();
            List<String> enter=new ArrayList<>();
            enter.add(table);
            for(int i=0;i<food.size();i++)
            {
                String f=food.get(i);
                String val;
                if(fI.containsKey(f))
                {
                    val=fI.get(f)+"";
                }
                else
                {
                    val="0";
                }
                enter.add(val);

            }
            content.add(enter);
        }

        return content;



             
        
    }
}