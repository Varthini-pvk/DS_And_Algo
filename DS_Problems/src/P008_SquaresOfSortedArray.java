import java.util.Arrays;

import org.junit.Test;

public class P008_SquaresOfSortedArray 
{
	@Test
	public void dataSetOne()
	{
		int[] inputArray= {-8,-3,3,4,10};
		squaresInSortedOrder(inputArray);
		
	}
	@Test
	public void dataSetTwo()
	{
		int[] inputArray= {-8,-3,0,3,3,4,10};
		squaresInSortedOrder(inputArray);
		
	}
	@Test
	public void dataSetThree()
	{
		int[] inputArray= {-8,-5,-3,-1,0,1,2};
		squaresInSortedOrder(inputArray);
	}

	//Solution 1
	private void squaresInSortedOrder1(int[] input)
	{
		for(int i=0;i<input.length;i++)
		{
			input[i]=input[i]*input[i];//O[N]
		}
		Arrays.sort(input);//O[nlog(n)]
		System.out.println(Arrays.toString(input));
	}
	//Total Time Complexity-->O[N]+O[n*log(n)]
	//space complexity //O(1)--?
	
	//Solution 2
	private void squaresInSortedOrder2(int[] input)
	{
		
		int[] resultArray=new int[input.length];int temp=0;
		resultArray[0]=input[0]*input[0];//O[1]
		for(int i=1;i<input.length;i++)
		{
			resultArray[i]=input[i]*input[i];//O[N]
			temp=resultArray[i];//O[1]
			for(int j=i-1;j>=0;j--)
			{

				if(temp<resultArray[j])//O[M] , worst case O[N^2]
				{
					resultArray[j+1]=resultArray[j];
					resultArray[j]=temp;
				}
				else
				{
					break;
				}
			}
		}
		System.out.println(Arrays.toString(resultArray));
		
		//Total time Complexity-->O[N]*O[M*N]==>O[M*N]
	}
	
	//Solution 3
	
	private void squaresInSortedOrder(int[] input)
	{
		int[] resultArray=new int[input.length];
		int[] tempArray=new int[input.length];
		int postiveStart=0;
		//To calculate the number of negative numbers
		for(int i=0;i<input.length;i++)
		{
			if(input[i]>=0)//O[M]
			{
			postiveStart=i;
			break;
			}
		}
		//Find The Square of negative numbers and Sort in ascending order
		int j=postiveStart-1;
		for(int i=0;i<postiveStart;i++)
		{
			tempArray[j]=input[i]*input[i];//O[M]
			j--;
			
		}
		//Find the square of positive numbers(will  be sorted order)
		for(int i=postiveStart;i<input.length;i++) 
		{
			tempArray[i]=input[i]*input[i];//O[N-M]
		}
		int i=0;j=postiveStart;int k=0;
		//Merge the squares of positive and negative numbers together in a new array in sorted Order
		while(i<postiveStart && j<tempArray.length) //Best Case O[N/2], else O[M] or O[N-M]
		{
			if(tempArray[i]<tempArray[j])//Best Case O[N/2], else O[M] or O[N-M]
			{
				resultArray[k]=tempArray[i];
				i++;k++;
			}
			else if(tempArray[i]==tempArray[j])
			{
				resultArray[k]=tempArray[i];
				resultArray[k+1]=tempArray[i];
				i++;j++;k=k+2;
			}
			else
			{
				resultArray[k]=tempArray[j];
				j++;k++;
			}
				
		}
		if(i==postiveStart)//O[M]
		{
			while(k<input.length)
			{
				resultArray[k]=tempArray[j];
				j++;k++;
			}
		}
		else	
		{
			while(k<input.length)
			{
				resultArray[k]=tempArray[i];
				i++;k++;
			}
			
		}
		System.out.println(Arrays.toString(resultArray));
		}
	
}
