package ArraysAndStrings;
import java.util.Arrays;

import org.junit.Test;

public class P024_moveZerosToEnd {
	
	@Test
	public void dataSetOne()
	{
		int[] input= {0,2,0,3,5,6};
		moveZeros(input);
		
	}

	@Test
	public void dataSetTwo()
	{
		int[] input= {0,0,0,4,5,0};
		moveZeros(input);
	}
	
	@Test
	public void dataSetThree()
	{
		int[] input= {0,4,5,8,0};
		moveZeros(input);
	}
	
	//Approach One
	// Loop through the length of array
	//Check if the current element is Zero or not
	//if yes move the shift the other elements by one position to left
	//Add zero at the last of shifiting
	
	
	private void moveZeros1(int[] input)
	{
		int length=input.length;
		int[] result=new int[length];int k=0;
		Arrays.fill(result, 0);//O[N]
		for(int i=0;i<length;i++)//O[N]
		{
			if(input[i]!=0)
			{
			result[k]=input[i];
			k++;
			}
		}
		System.out.println(Arrays.toString(result));
	}
	
	//Total Time Complexity=O[N]
	
	//Approach Two
	
	//initialize a variable to keep track of next index to be replaced
	//loop through the length of the array
	//---if the value is equal to zero, 
	//    -->move the element to next index to be replaced
	//    -->increment the next index to be replaced
	//--> else continue the loop
	
	private void moveZeros(int[] input)
	{
		int indexToBeReplaced=0;
		for(int i=0;i<input.length;i++)//O[M]
		{
			if(input[i]!=0)
			{
				input[indexToBeReplaced]=input[i];
				indexToBeReplaced++;
			}
			
		}
		for(int i=indexToBeReplaced;i<input.length;i++)//O[N-M]
		{
			input[i]=0;
		}
		System.out.println(Arrays.toString(input));
	}
}
