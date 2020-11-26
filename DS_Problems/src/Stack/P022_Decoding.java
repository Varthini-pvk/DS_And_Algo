package Stack;

import java.util.Arrays;

import org.junit.Test;

public class P022_Decoding 
{
	//	
	//	Given an encoded string, return its decoded string.
	//
	//			Input: s = "3[a]2[bc]"
	//			Output: "aaabcbc"
	//
	//			Input: s = "3[a2[c]]"
	//			Output: "accaccacc"
	//	
	@Test
	public void dataSetOne()
	{
		String input="3[a]2[bc]";
		String result=decode(input);
		char[] toPrint=result.toCharArray();
		int i=0;int j=toPrint.length-1;char temp;
		while(i<j)
		{
			temp=toPrint[i];
			toPrint[i]=toPrint[j];
			toPrint[j]=temp;
			i++;j--;
		}
		System.out.println(String.valueOf(toPrint));
	}
	@Test
	public void dataSetTwo()
	{
		String input="3[a2[c]]";
		String result=decode(input);
		char[] toPrint=result.toCharArray();
		int i=0;int j=toPrint.length-1;char temp;
		while(i<j)
		{
			temp=toPrint[i];
			toPrint[i]=toPrint[j];
			toPrint[j]=temp;
			i++;j--;
		}
		System.out.println(String.valueOf(toPrint));
	}
	@Test
	public void dataSetThree()
	{
		String input="3[a2[c3[fff]]]";
		String result=decode(input);
		char[] toPrint=result.toCharArray();
		int i=0;int j=toPrint.length-1;char temp;
		while(i<j)
		{
			temp=toPrint[i];
			toPrint[i]=toPrint[j];
			toPrint[j]=temp;
			i++;j--;
		}
		System.out.println(String.valueOf(toPrint));
	}

	//Solution 1

	private String decode(String encoded)
	{
		char[] inputarray=encoded.toCharArray();
		int i=inputarray.length-1;
		String subString="";
		String endString="";
		String finalString="";
		int start=0;
		int end=0;
		int count=0;
		while(i>0)//Outer loop to check the length of Array
		{
			end=0;
			while(inputarray[i]==']')//O[M]//Initialization to count number of inner blocks by counting ending phrase ']'
			{
				end++;i--;

				subString="";

			}
			start=end;


			while(start>0)//Condition to check all blockes are done
			{

				if(Character.isDigit(inputarray[i]))//If the character is number add the determined strings by the digit count
				{
					count=Character.getNumericValue(encoded.charAt(i));
					char[] tempArray=subString.toCharArray();
					int l=0;int m=tempArray.length-1;char temp;//To Sort the determined String before Repeating
					while(l>m)
					{
						temp=tempArray[l];
						tempArray[l]=tempArray[m];
						tempArray[m]=temp;
						l++;m--;

					}
					while(count>0)
					{
						endString=subString+endString;
						count--;

					}	
					start--;//Decrement (one block is done)
					subString=endString;
					endString="";
				}
				else if(encoded.charAt(i)!='[')//if it is char, add to current String
				{
					subString=subString+inputarray[i];
				}

				i--;
			}
			finalString=finalString+subString;
		}
		return finalString;
	}
	
	//Solution 2
	
	

}
