package arraysandstrings;

import org.junit.Test;

public class P051_maxContigousOne {


	//	1. get array and k as input
	//	2. Declare 2 variables start and end , assign both to zero
	//	3. Loop over array till end is less than the length of array
	//		4. window Condition: loop till k is greater than 0 and the element is not zero
	//			5. if the element is 1, increment end
	//			6. else decrement k
	//		6. check if the end-start is maximum then assign to max value
	//		7. reset k  to original value and assign increment start and continue



	@Test
	public void dataSetOne()
	{
		int[] array= {1,1,1,0,0,0,1,1,1,1,1};
		int k=2;
		System.out.println(maxLength(array,k));
	}
//two pointers: left, right
//Move from right, if u find 0 , decrement k 
	// if k<0, 
	//a) if left value=0, increment k
	//b) either case, increment left
//Difference between right and left should be the length
								
	private int findmaxLength(int[] array, int k)
	{
		int left=0;int right=0;
		for(;right<array.length;right++)
		{
			if(array[right]==0)  k--;
			if(k<0)	
			{
				if(array[left]==0) k++;
				left++;
			}
			
		}
		return right-left;
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k=3;
		System.out.println(maxLength(array,k));
	}

	private int maxLength(int[] array, int k)
	{
		int start=0; int end=0; int output=0;
		int temp=k;
		while(end<array.length)
		{
			if(array[end]==1) end++;


			else 
			{
				if(k>0)
				{
					k--;
					end++;
				}
				else
				{
					output=Math.max(output, end-start);
					if(array[start]==0) k++;
					start++;
					
				}

			}

		}
		return output;
}
}