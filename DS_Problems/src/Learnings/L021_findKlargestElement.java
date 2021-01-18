package Learnings;

import org.junit.Test;

public class L021_findKlargestElement 
{

	@Test
	public void dataSetOne()
	{
		int[] array= {1,5,8,1,4,0,1,2,2};
		int k=5;
		System.out.println(findKlargest(array,k));
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {3,2,1,5,6,4};
		int k=2;
		System.out.println("Two:"+findKlargest(array,k));
	}

	//Using quick sort
	//Select pivot (first /random element)
	//sort the array such that elements to left of pivot are lower to pivot and elements 
	//greater are to right of pivot
		//Assign two varaibles left =0, right=array size
		//increment left till element at left is less than or equal to element at pivot
		//decrement right till element at right is greater than or equal to element at pivot
		//swap both  elements at left and right
		//continue till left is less than right
		//Swap right-1 element with element at pivot
	//Repeat above steps recursively till all elements are sorted
	private int findKlargest(int[] array, int k) 
	{
		int start=0;int end=array.length-1;
		int part= partitionatPivot(start,end,array);
		
		while(part!=k-1)
		{
		if(part>k-1)
			end=part-1;
		else if(part<k)
			start=part+1;
		part=partitionatPivot(start,end,array);
		}
		return array[part];
	
		
	}

	
	private  int partitionatPivot(int start, int end, int[] array) 
	{
		int pivot=start;start++;
		while(start<=end)
		{
			if(array[start]>array[pivot])
			{
				swap(start,end,array);
				end--;
			}
			else
			start++;
			
		}
		
		swap(end,pivot,array);
		return end;
	}
	
	private void swap(int a,int b,int[] array)
	{
		int temp=array[a];
		array[a]=array[b];
		array[b]=temp;
		
	}
}
