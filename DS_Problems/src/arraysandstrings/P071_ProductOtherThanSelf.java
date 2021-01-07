package arraysandstrings;

import java.util.Arrays;

import org.junit.Test;

//Given an array nums of n integers where n > 1,  return an array output such 
//that output[i] is equal to the 
//product of all the elements of nums except nums[i].

public class P071_ProductOtherThanSelf 
{

	
	@Test
	public void dataSetOne()
	{
		int[] array= {1,2,3,4};
		
//					1 1 2 6
//					24   12  4  1
		
		System.out.println(Arrays.toString(findProduct(array)));
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {1,2,3,4,5};
		System.out.println(Arrays.toString(findProduct(array)));
	}
	
	
	//Solution 1
	//1.Loop through the array
	//2. for each element calculate the product to its left and right(Using to inner loops)
	//3. add the product of two results to result array
	
	private int[] findProduct1(int[] array)
	{ 
		int left=1; int right=1;
		int[] result=new int[array.length];
		for(int i=0;i<array.length;i++)
		{
			
			for(int j=i-1;j>=0;j--)
			{
				left*=array[j];
			}
			for(int k=i+1;k<array.length;k++)
			{
				right*=array[k];
			}
			result[i]=left*right;
			left=1;right=1;
		}
		return result;
	}
	
	//Solution 2
	//In two Seperate for loops calculate left and right 
	
	private int[] findProduct2(int[] array)
	{ 
		int length=array.length;int start=1; int end=length-2;
		int[] leftProduct=new int[length];
		int[] rightProduct=new int[length];
		int[] result=new int[length];
		leftProduct[0]=1;
		rightProduct[length-1]=1;
		while(start<length&&end>=0)
		{
			leftProduct[start]=leftProduct[start-1]*array[start-1];
			rightProduct[end]=rightProduct[end+1]*array[end+1];
			start++;end--;
		}
		for(int i=0;i<length;i++)
		{
			result[i]=leftProduct[i]*rightProduct[i];
		}
		return result;
	}
	
	//Solution 3
		//Instead of right array, use a varaible to store the previus right product
		
		private int[] findProduct(int[] array)
		{ 
			int length=array.length;
			int[] Output=new int[length];
			Output[0]=1;
			for(int i=1;i<length;i++)
			{
				Output[i]=Output[i-1]*array[i-1];
			}
			int previousRightProduct=1;
			for(int j=length-1;j>=0;j--)
			{
				Output[j]=Output[j]*previousRightProduct;
				previousRightProduct=previousRightProduct*array[j];
			}
			return Output;
		}
	
}
