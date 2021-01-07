package MockAssesments;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class M006_CaseDuplicates 
{
	@Test
	public void dataSetOne()
	{
		String input="aaabcAbCdD";
		System.out.println(findCaseDuplicate(input));
	}
	
	@Test
	public void dataSetTwo()
	{
		String input="aA";
		System.out.println(findCaseDuplicate(input));
	}
	
	@Test
	public void dataSetThree()
	{
		String input="abcdE";
		System.out.println(findCaseDuplicate(input));
	}
	
	//Convert the String to char Array
	//Loop Over the Array
	//Check the ASCII range,
	//	if the character is upper case convert to lower case and add to set, else add the character to set 
	//	when the add returns false, check if the character is maximum
	//if yes store it as output
	
	private String findCaseDuplicate(String input)
	{
		Set<Character> refSet=new HashSet<>();
		Character max='0';Character temp=' ';
		for(Character eachChar:input.toCharArray())
		{
			
			temp=(Character.isUpperCase(eachChar))? temp=Character.toLowerCase(eachChar):eachChar;
			if(!refSet.add(temp)&&Character.isUpperCase(eachChar))
			{
				if(max<eachChar)
				{
					max=eachChar;
				}
			}
		}
		if(max=='0') return "NO";
		return String.valueOf(max);
	}

}
