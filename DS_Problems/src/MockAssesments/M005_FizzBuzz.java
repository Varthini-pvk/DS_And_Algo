package MockAssesments;

import java.util.Arrays;

import org.junit.Test;

public class M005_FizzBuzz {
	
	@Test
	public void dataSetOne()
	{
		int n=15;
		System.out.println(Arrays.toString(fizzBuzz(n)));
	}
	
	
	
	//@Test
	public void dataSetTwo()
	{
		int n=100;
		System.out.println(Arrays.toString(fizzBuzz(n)));
	}
	
	@Test
	public void dataSetThree()
	{
		int n=33;
		System.out.println(Arrays.toString(fizzBuzz(n)));
	}

	
	//Loop for 1 to n
	//Check if the current element is divisible by  3 and 5 ,3, 5  if yes add fizzbuzz, fizz, buzz and  respectively
	//else add current element to output array
	//return the output array
	
	private String[] fizzBuzz(int n)
	{
		String[] output=new String[n];
		for(int i=0;i<n;i++)
		{
			if((i+1)%5==0&&(i+1)%3==0) output[i]="FizzBuzz";
			else if((i+1)%3==0) output[i]="Fizz";
			else if((i+1)%5==0) output[i]="Buzz";
			else output[i]=String.valueOf(i+1);
			
		}
		return output;
	}
}
