package arraysandstrings;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P049_RemoveElement {

@Test
public void dataSetOne()
{
	int[] input= {0,1,2,2,3,0,4,2};
	int n=2;
	System.out.println(removeElement(input,n));
}

@Test
public void dataSetTwo()
{
	int[] input= {2,2,2};
	int n=2;
	System.out.println(removeElement(input,n));
}

@Test
public void dataSetThree()
{
	int[] input= {0,1,5,5,3,0,4,5};
	int n=2;
	System.out.println(removeElement(input,n));
}

//Declare the Output Array
//Loop through the length of array 
//if the element is not equal to the n, add the element to output
//Return length of output array
private int removeElement(int[] input, int n)
{
	
	List<Integer> outputArray=new ArrayList<>();
	for(int i=0;i<input.length;i++)
	{
		if(input[i]!=n)
		outputArray.add(input[i]);		
	}
	System.out.println(outputArray);
	return outputArray.size();
	
}
}
