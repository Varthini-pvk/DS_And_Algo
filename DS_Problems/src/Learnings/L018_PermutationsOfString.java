package Learnings;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class L018_PermutationsOfString 
{

	List<String> output=new ArrayList<>();
	@Test
	public void dataSetone()
	{
		
		String input="god";
		findPermutations(input);
		System.out.println(output);
	}

	private void findPermutations(String input)
	{
		char[] inputArray=input.toCharArray();
		findPermutationsRec(inputArray,0,inputArray.length);

	}

	private void findPermutationsRec(char[] input, int currentElement, int length) 
	{
		if(currentElement==length)
		{
		output.add(String.valueOf(input));
		return;
		}
		char temp=' ';
		for(int i=currentElement;i<length;i++)
		{
			temp=input[currentElement];
			input[currentElement]=input[i];
			input[i]=temp;
			findPermutationsRec(input,currentElement+1,length);
			temp=input[currentElement];
			input[currentElement]=input[i];
			input[i]=temp;
			
		}
	}
}
