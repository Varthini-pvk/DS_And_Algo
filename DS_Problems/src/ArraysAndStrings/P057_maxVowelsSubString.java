package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P057_maxVowelsSubString 
{

@Test
public void dataSetOne()
{
	String input="kraeheei";
	int k=2;
	System.out.println(maxvowel(input,k));
}

//1. Get input string,k
//2.Declare the varaiables start, end  and assign to 0
//3. Loop till the end of string
//	1. if the element is non vowel
//		increment end 
//		Assign start equal to end"
//	2. else if the element is vowel ,
//		increment end
//	--> if end-start equal to K
//		return the substring (start, end)

private String maxvowel(String input,int k)
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
	
	int start=0;int end=0;
	while(end<input.length())
	{
		if(!vowels.contains(input.charAt(end)))
		{
		end++;
		start=end;
		}
		else
		{
		end++;
		if(end-start==k)
		return(input.substring(start, end));
		
		}
		
	}
	throw new RuntimeException("No Vowels");
}
}
