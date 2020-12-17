package MockAssesments;

import java.util.Arrays;

import org.junit.Test;

public class Varthini_D7_Q3 {
	
	@Test
	public void dataSetOne()
	{
		String input="There is no Test";
		System.out.println(reverse(input));
	}
	
	@Test
	public void dataSetTwo()
	{
		String input="There is no Test Testee";
		System.out.println(reverse(input));
	}

	
	//Solution 2(Using One pass and two Pointers)
	//Split the String using Space in to array of strings
	//Loop 1: 
			 //Declare Two Variables Start =0 and end= length of array
			//Loop till start is less than end
			//Swap the strings at start and end
			//Keep a counter/flag identify the string which needs to be reverse : strings at end and start alterbatively
	//Loop 2 ://Reverse each  selected string using two pointers again
	
	private String reverse(String input)
	{
		StringBuilder OutPut=new StringBuilder();
		String[] inputArray=input.split(" ");
		int start=0;int end=inputArray.length-1;
		Boolean reverseEnd=true;String temp="";
		while(start<end)
		{
			if(reverseEnd)  inputArray[end]=reverseWord(inputArray[end]);
			else            inputArray[start]=reverseWord(inputArray[start]);
			temp=inputArray[end];
			inputArray[end]=inputArray[start];
			inputArray[start]=temp;
			start++;end--;
			reverseEnd=reverseEnd?false:true;
		}
		for(int i=0;i<inputArray.length;i++)
		{
			OutPut.append(inputArray[i]);
			OutPut.append(" ");
		}
		
		return String.valueOf(OutPut);
	}
	
	private String reverseWord(String word)
	{
		char[] inputArray=word.toCharArray();
		int start=0;int end=inputArray.length-1;char temp;
		while(start<end)
		{
			temp=inputArray[end];
			inputArray[end]=inputArray[start];
			inputArray[start]=temp;
			start++;end--;
			
		}
		
		return String.valueOf(inputArray);
		
	}
}
