//package BinarySearch;
//
//import org.junit.Test;
//
//public class P080_squareroot 
//{
//	
//	
//	//Iterate form 2 to n/2
//		//Set Low=2, high =n/2,
//		// for each number i, divide the given number by  i
//		//check if quotient is equal to given number and remainder equal to 0
//		//If yes , return i
//		//if quotient is greater to given number , return -1
//	//If not found at the end of iteration return -1
//	
//	
//	
//	//Iterate form 2 to n/2 (2--8)
//	//Set Low=2, high =n/2,
//	//Calculate mid=low+high/2  (2+8/2=5), (16/5==>3)   3 5 0 2 new mid (2+4/2)==> 3,
//	
//	int count=0;
//	@Test
//	public void dataStOne()
//	{
//		int n=37;
//		System.out.println(findSquareRoot(n));
//		System.out.println(count);
//		
//	}
//	private double findSquareRoot( int n)
//	{
//		
//		if(n==0||n==1) return n;
//		 int low=2, high=n/2;int mid=0;
//		while(low<=high)
//		{
//			count++;
//			mid=(low+high)/2;
//			double temp=mid*mid;
//			if(temp==n) return mid;
//			else if(temp<n) low=mid+1;
//			else high=mid-1;
//
//		}
//	 return -1;
//	}
//	
//
//	private double findSquareRoot( int n)
//	{
//		
//		if(n==0||n==1) return n;
//		 int low=2, high=n/2;int mid=0;
//		while(low<=high)
//		{
//			count++;
//			mid=(low+high)/2;
//			double temp=mid*mid;
//			if(temp==n) return mid;
//			else if(temp<n) low=mid+1;
//			else high=mid-1;
//
//		}
//	 return -1;
//	}
//
//}
