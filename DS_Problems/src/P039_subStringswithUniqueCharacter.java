import org.junit.Test;

public class P039_subStringswithUniqueCharacter {
	
	
@Test
public void dataSetOne()
{
	String input="abcabcbb";
	System.out.println(subStringLength(input));
}

@Test
public void dataSetTwo()
{
	String input="pebdbfghi";
	System.out.println(subStringLength(input));
}

@Test
public void dataSetThree()
{
	String input="abcabcbb";
	System.out.println(subStringLength(input));
}

private int subStringLength(String input)
{
	int i=0;int start=0;int max_Length=0;int[] charCount=new int[256];char cuurentChar;
	while(i<input.length())
	{
		cuurentChar=input.charAt(i);
		if(charCount[cuurentChar]<1)
		{
			charCount[cuurentChar]++;
			i++;
		}
		else
		{
			if(max_Length<i-start)
			{
				max_Length=i-start;
			}
			charCount[input.charAt(start)]--;
			start++;
			
		}
	}
	return max_Length;
}

}
