class SumOfPrimes{
	public static boolean isSumOfPrimes(int n)
	    {
		if(n<4)
		{
		    System.out.println("Impossible");
		    return false;
		}
		
		return false;
	    }

	    public static boolean prime(int n){
		boolean bool = true;
		for(int i=2; i<=n/2; i++){
		    if(n%i==0)
		        bool = false;
		}
		return bool;



	    }

	public static void main(String args[]){
		int a = Integer.parseInt(args[0]);
		isSumOfPrimes(a);
	}
}
