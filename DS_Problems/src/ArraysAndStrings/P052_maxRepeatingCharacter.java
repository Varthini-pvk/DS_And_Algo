package ArraysAndStrings;

import org.junit.Test;

public class P052_maxRepeatingCharacter {
	
//	1. get Input string and k
//	2. Declare three variables: start, end and assign to 1 and 0 .
//	3. Loop till, end less than array length
//		4. check element at left is equal to element at right
//		if yes increment end
//		4. if not equal
//			check the value of k, if k is greater than 0
//				decrement k and increment end
//			if k is less than 0, 
//				check if end-start is maximum 
//				increment start 
//				And Reset k value
			
	@Test
	public void dataSetOne()
	{
		String input="AABABBA";
		int k=2;
		System.out.println(maxLength(input,k));
	}
	
	@Test
	public void dataSetTwo()
	{
		String input="AABBBB";
		int k=2;
		System.out.println(maxLength(input,k));
	}

	private int maxLength(String input, int k)
	{
		char[] array=input.toCharArray();
		int start=0; int end=0; int output=0;
		int temp=k;
		while(end<array.length)
		{
			if(array[end]==array[start])
				end++;

			else if(array[end]!=array[start])
			{
				if(k>0)
				{
					k--;
					end++;
				}
				else
				{
					output=Math.max(output, end-start);
					start++;
					k=temp;
				}

			}
			else if(end==array.length-1)
			{
			output=Math.max(output, end-start);
			start++;
			k=temp;
			}

		}
		
		start=array.length-1;  end=array.length-1; 
		
		while(end>=0)
		{
			if(array[end]==array[start])
				end--;

			else if(array[end]!=array[start])
			{
				if(k>0)
				{
					k--;
					end--;
				}
				else
				{
					output=Math.max(output, end-start);
					start--;
					k=temp;
				}

			}
			else if(end==array.length-1)
			{
			output=Math.max(output, end-start);
			start--;
			k=temp;
			}

		}
		return output;
}
	

}
