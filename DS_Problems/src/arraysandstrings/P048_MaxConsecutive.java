package arraysandstrings;

import org.junit.Test;

//1. Declare two Variables Start and i and assign to zero
//2. Loop over charcter array ,Increment i till ,equal to same element
//3. if not caluclate start-i and check if it is greater than max , assign value of i to output
//4. Assign start to i and continue

public class P048_MaxConsecutive {
	
	
@Test
public void dataSetOne()
{
	String input ="Amazon is a great Company AoooZzz";
	System.out.println(maxOccurance(input));
}


@Test
public void dataSetTwo()
{
	String input ="AAAAmazonnn is a great Company AoooZzz";
	System.out.println(maxOccurance(input));
}

@Test
public void dataSetThree()
{
	String input ="Amazon is a great Company";
	System.out.println(maxOccurance(input));
}



private char maxOccurance(String input)
{
	char[] refArray=input.toCharArray();
	int max=0;char output=' ';
	int start=0;int i=0;
	while(i<refArray.length)
	{
		while(i<refArray.length&&refArray[start]==refArray[i])
		{
			i++;
		}
		if(max<i-start)
		{
			output=refArray[start];
			max=i-start;
		}
		i++;
		start=i;
	}
	
	return output;
}
}
