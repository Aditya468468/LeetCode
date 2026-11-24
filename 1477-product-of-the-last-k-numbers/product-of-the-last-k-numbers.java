class ProductOfNumbers 
{
    List<Integer> list;

    public ProductOfNumbers() 
    {
        list=new ArrayList<>();
    }
    
    public void add(int num) 
    {

        list.add(num); //O(1)
        
    }
    
    public int getProduct(int k) 
    {
        int idx=list.size()-1;
        int prod=1;
        for(int i=0;i<k;i++)
        {  
            prod*=list.get(idx);
            idx--;
        }

        return prod;
        
    }

}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */