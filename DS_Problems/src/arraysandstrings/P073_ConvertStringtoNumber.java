package arraysandstrings;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class P073_ConvertStringtoNumber {

	@Test
	public void dataSetOne()
	{
		String input="Three hundred million seven hundred twenty nine thousand five hundred ninety six";
		System.out.println(determineNumber(input));
	}

	@Test
	public void dataSetTwo()
	{
		String input="Two hundred ninety six";
		System.out.println(determineNumber(input));
	}

	@Test
	public void dataSetThree()
	{
		String input="One Thousand";
		System.out.println(determineNumber(input));
	}

	//if the string contains million/thousand/hundreds
	//Split the string before and after these words
	//Final Result is equal to number equal to the preceding words * million/thousand/hundred+ number equal to the succeeding words


	String[] TensListArray= {" ", " ","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
	String[] OnesListArray= {" ","one","two","three","four","five","six","seven","eight","nine","ten","elven",
			"twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	List<String> TensList=Arrays.asList(TensListArray);
	List<String> OnesList=Arrays.asList(OnesListArray);

	private int determineNumber(String input)
	{
		if(input.length()>0)
		{
			input= input.toLowerCase();
			return convertToNumber(input);		
		}
		throw new RuntimeException("Invalid input");
	}

	private int convertToNumber(String input)
	{

		if(input.equals(" ")) return 0;

		if(input.contains("million"))
		{
			String[] temp=input.split("million");
			if(temp.length>1) 
				return convertToNumber(temp[0])*1000000+convertToNumber(temp[1]);
			else
				return convertToNumber(temp[0])*1000000;

		}
		if(input.contains("thousand"))
		{
			String[] temp=input.split("thousand");
			if(temp.length>1) 
				return convertToNumber(temp[0])*1000+convertToNumber(temp[1]);
			else
				return convertToNumber(temp[0])*1000;
		}

		if(input.contains("hundred"))
		{
			String[] temp=input.split("hundred");
			if(temp.length>1) 
				return convertToNumber(temp[0])*100+convertToNumber(temp[1]);
			else
				return convertToNumber(temp[0])*100;
		}


		else if(input.trim().contains(" "))
		{
			String[] temp= input.trim().split(" ");
			if(temp.length>1)
			{
				//if(TensList.indexOf(temp[0])<0) throw new RuntimeException("Invalid input");
				return (TensList.indexOf(temp[0])*10)+convertToNumber(temp[1]);
			}
			else
				return convertToNumber(temp[0]);
		}

		else
		{
			//if(OnesList.indexOf(input)<0) throw new RuntimeException("Invalid input");
			return (OnesList.indexOf(input.trim()));
		}


	}

}
