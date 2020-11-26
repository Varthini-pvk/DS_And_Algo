import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

//Given a String , Which contains same s
//et of alphabets in both Upper and LowerCase , 
//Swap the alphabets to get the alphabets of both 
//cases to appear together .Retain the order of first Occurance of 
//any aplhabet.

public class P044_ArrangeCase {
	
	
@Test
public void dataSetOne()
{
	String input="BdAcbCaD";
	arrangeCase(input);
}

private void arrangeCase(String input)
{
	StringBuffer output=new StringBuffer();
	char[] inputArray=input.toCharArray();
	Character temp;
	int c=0;
	Set<Character> ref=new HashSet<Character>();
	for(int i=0;i<inputArray.length;i++)
	{
		temp=Character.toLowerCase(inputArray[i]);
		if(ref.add(temp))
		{
			if(Character.isLowerCase(inputArray[i]))
			{
				temp=Character.toUpperCase(inputArray[i]);
			}
			System.out.println(c++);
			

			output.append(inputArray[i]);
			output.append(temp);
		};
		
		
	}
	System.out.println(output);
	
	
}

}
