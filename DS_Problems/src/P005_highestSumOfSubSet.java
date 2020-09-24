import org.junit.Test;

public class P005_highestSumOfSubSet {
	
	@Test
	public void dataSetOne()
	{
		int[] array= {1,2,3,5,0,8,7,8,3,2};
		int k=4;
		System.out.println("One:"+ sumOfConsecutiveNumbers(array,k));
		
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {7,4,3,0,-1,-14,-16,8,10,-3,13,15,8,3};
		int k=2;
		System.out.println("Two:"+sumOfConsecutiveNumbers(array,k));
		
	}
	
	@Test
	public void dataSetThree()
	{
		int[] array= {3,4,5,1,2,0,8,9,10,11,12,15,19,20,23,25,26,1,2,-20,-23,-25,-26};
		int k=4;
		System.out.println("Three:"+sumOfConsecutiveNumbers(array,k));
		
	}
	@Test
	public void dataSetFour()
	{
		int[] array= {2,4,1,3,5,6,0,1,3,1};
		int k=3;
		System.out.println("Four: "+sumOfConsecutiveNumbers(array,k));
		
	}

	//Solution 1
	private int sumOfConsecutiveNumbers1(int[] array,int k)
	{
		int sum=0;int maxSum=0;
		for(int i=0;i<array.length-k-1;i=i+k)
		{
			sum=0;
			for(int j=i;j<i+k;j++)//O[N]
			{
				sum=array[j]+sum;//O[N*M]
			}
			if(sum>maxSum)
			{
				maxSum=sum;
			}
		}
		return maxSum;
	}
	//Total timeComplexity==>O[N]+O[N*M]==>O[N*M]
	
//Solution 2
	//Windows Sliding technique
	private int sumOfConsecutiveNumbers(int[] array,int k)
	{
		int sum=0; int maxSum=0;int temp=0;
		for (int i=0;i<k;i++)
		{
			maxSum=maxSum+array[i];//O[M]
		}
		sum=maxSum;
		for(int i=0;i<array.length-k;i++)
		{
		sum=sum-array[i]+array[i+k];//O[N]
		maxSum=Math.max(maxSum, sum);//O[1]
		}
		return maxSum;
		
	}
	
	
	
}

