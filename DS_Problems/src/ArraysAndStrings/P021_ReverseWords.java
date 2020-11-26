package ArraysAndStrings;

import java.util.Arrays;

import org.junit.Test;

public class P021_ReverseWords 
{

	//	Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
	//
	//	Input:  "I am doing great"
	//	Output: "I ma gniod taerg"

	//DataSet

	@Test
	public void dataSetOne()
	{
		String input="I am doing great";
		System.out.println(Arrays.toString(reverseWords(input)));
		
	}

	//Solution 1
	private char[] reverseWords1(String input)
	{
		char[] inputarray=input.toCharArray();int j=0;int k=0;
		char[] result=new char[inputarray.length];
		for(int i=0;i<inputarray.length-1;i++)
		{
			j=i;			
			while(j<inputarray.length-1 && inputarray[j+1]!=' ')
			{
				j++;
			}
			
			for(;j>=i;j--)
			{
				result[k]=inputarray[j];
				k++;
			}
			
			if(k<inputarray.length)
			result[k]=' ';k++;
			i=k-1;
		}
		return result;
	}
	
	//Solution 2(Windows Sliding+Two pointer)
  private char[] reverseWords(String input)
  {
	  char[] inputArray=input.toCharArray();int i=0;int start=0;char temp;
	  int j=0;
	  while(i<input.length())//O[M]
	  {
		  start=i;
		  while(i<inputArray.length-1 && inputArray[i+1]!=' ')//O[K]
		  {
			  i++;
		  }
		  j=i;
		  while(start<j)//O[K]
		  {
			  temp=inputArray[start];
			  inputArray[start]= inputArray[j];
			  inputArray[j]=temp;
			  start++;j--;  
		  }
		  i=i+2;
		  
	  }
	  return inputArray;
	  
  }
}