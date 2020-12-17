package MockAssesments;

import org.junit.Test;

public class reverseString {
	
	@Test
	public void dataSetOne()
	{
		String input="There is no Test";
		System.out.println(reverese(input));
	}
	
	@Test
	public void dataSetTwo()
	{
		String input="There is no Test Testee";
		System.out.println(reverese(input));
	}

	
	private String reverese(String input)
	{
		String res = "";
		String[]  str = input.split(" ");
		
		for (int i = str.length-1; i >= 0; i--) 
		{
			int l= 0, r = 1;
			char[] chr = str[i].toCharArray();
			while (r < str[i].length())
			{
				char temp = chr[l];
				chr[l]  = chr[r];
				chr[r] = temp;
				l+=2;
				r+=2;
					
			}
			res+=String.valueOf(chr)+" ";
		}
		return res;
	}
}


