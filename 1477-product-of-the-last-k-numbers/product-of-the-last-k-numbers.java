class ProductOfNumbers 
{
  
    List<Long> prefixList;

    long prefix;

    public ProductOfNumbers() 
    {
      
        prefixList=new ArrayList<>();
        prefix=1;
    }
    
    public void add(int num) 
    {
        if(num==0)
        {
            prefix=1; //Reset
            //prefixList.add(0*1L); //Product will be all zero
            prefixList=new ArrayList<>();
        }
        else
        {
            prefix*=num;
            prefixList.add(prefix);
        }
        
    }
    
    public int getProduct(int k) 
    {

        if(prefixList.size()<k) return 0;

        if (prefixList.size() == k) 
        {
            return (int) prefix;
        }

        long prefixProduct=prefixList.get(prefixList.size()-1-k);

        int ans=(int)(prefix/prefixProduct);

        return ans;

        
    }

}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */