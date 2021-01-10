package sorting;

import java.util.Arrays;

import org.junit.Test;

public class S005_MergeSort

{
	@Test
	public void dataSetOne()
	{
		int[] array= {6,5,3,1,8,7,2,4};
		System.out.println(Arrays.toString(mergeSort(array)));
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {6,5,2,3,1,8,7,2,4};
		System.out.println(Arrays.toString(mergeSort(array)));
	}
	
	@Test
	public void dataSetThree()
	{
		int[] array= {6,5,3,1,8,7,2,4};
		System.out.println(Arrays.toString(mergeSort(array)));
	}
	
	private int[] mergeSort(int[] array)
	{
		
		mergeSortRec(0, array.length-1,array);
		return array;
	}
	
	private void mergeSortRec(int left, int right,int[] array)
	{
		
		if(left<right)
		{
		int mid=(left+right)/2;
		mergeSortRec(left,mid,array);
		mergeSortRec(mid+1,right,array);
		merge(left,mid,right,array);
		
		}
		else
		return;
		
	}
	private void merge(int start, int mid ,int end,int[] array)
	{
		int i=start,j=mid+1;
		int temp=0;
		while(i<j&&j<=end)
		{
			if(array[i]>array[j])
			{
				temp=array[j];
				array[j]=array[i];
				array[i]=temp;
				j++;
			}
			else if(array[i]==array[j])
			{
				i++;j++;
			}
			else
				i++;
			
		}
		
	
	}

}
