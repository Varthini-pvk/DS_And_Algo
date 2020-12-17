package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P050_reverseVowels {
	
@Test
public void dataSetOne()
{
	String input="hello";
	System.out.println(reverseVowels(input));
}

@Test
public void dataSetTwo()
{
	String input="eioua";
	System.out.println(reverseVowels(input));
}

@Test
public void dataSetThree()
{
	String input="pbcfgc";
	System.out.println(reverseVowels(input));
}

@Test
public void dataSetFour()
{
	String input="kedfAeif";
	System.out.println(reverseVowels(input));
}

private String reverseVowels(String input)
{
	List<Character> vowels=new ArrayList<>();
	vowels.add('a');	
	vowels.add('A');
	vowels.add('e');
	vowels.add('E');
	vowels.add('i');
	vowels.add('I');
	vowels.add('o');
	vowels.add('O');
	vowels.add('u');
	vowels.add('U');
	
	char[] refArray=input.toCharArray();
	int start=0;int end=refArray.length-1;
	char temp;
	while(start<end)
	{
		if(vowels.contains(refArray[start])&&vowels.contains(refArray[end]))
		{
			temp=refArray[start];
			refArray[start]=refArray[end];
			refArray[end]=temp;
			start++;end--;
		}
		if(!vowels.contains(refArray[start]))
		start++;
		if(!vowels.contains(refArray[end]))
		end--;
		
				
	}
	return String.valueOf(refArray);
	
	
}




}
