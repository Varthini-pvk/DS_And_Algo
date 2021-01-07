package BinarySearch;

import org.junit.Test;

public class P083_PeakElement 
{
	@Test
	public void dataSetOne()
	{
		int[] array= {1,2,1,3,5,6,4};
		System.out.println(findPeak(array));
		
	}
	@Test
	public void dataSetTwo()
	{
		int[] array= {1,2,4,3,5,6,4};
		System.out.println(findPeak(array));
		
	}
	//Declare low=0;high =end
	//calculate mid=low+high/2
	//if mid is >mid+1 and mid >mid-1 return mid
	//else
	//if mid+1 is greater , assign low=mid
	//else assign high=mid
	//continue till low less than ir equal to high
	
	private int findPeak(int[] input)
	{
		int low=0,high=input.length-1;int mid=0;
		while(low<=high)
		{
			mid=(low+high)/2;
			if(input[mid]>input[mid-1]&&input[mid]>input[mid+1]) return mid;
			else if(input[mid]>input[mid+1]) low=mid;
			else high=mid;
	
		}
		throw new RuntimeException("No match");
	}

}
