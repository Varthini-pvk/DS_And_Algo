package MockAssesments;

import org.junit.Test;

public class M008_SortBasedOnString 
{

	@Test
	public void dataSetOne()
	{
		String input="abbceeeg";
		String ref="egbca";
		System.out.println(sortBasedOnRef(input,ref));
	}
	
	@Test
	public void dataSetTwo()
	{
		String input="abbceeegg";
		String ref="egbca";
		System.out.println(sortBasedOnRef(input,ref));
	}
	
	//Declare a char Array to 
	//Loop through the ref string and place the characters as per order
	//Declare a int Array
	//Loop through the input string and note the occurence of ech characters(based on ASCII index)
	
	//Loop through the char array and print the values in order with the occurence in the int Array
	
	
	private String sortBasedOnRef(String input,String ref)
	{
		char[] inputArray=input.toCharArray();
		char[] temp=ref.toCharArray();
		String Output="";int j=0;
		int[] occurance=new int[26];
		for(int i=0;i<inputArray.length;i++)
		{
			occurance[inputArray[i]-'a']++;
		}
		for(int i=0;i<temp.length;i++)
		{
			j=occurance[temp[i]-'a'];
			while(j>0)
			{
				Output+=temp[i];
				j--;
			}
		}
		return Output;
	}
}
