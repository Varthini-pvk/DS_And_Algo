package MockAssesments;

import org.junit.Test;

public class M007_InsertFive 
{

	//Check if the number is greater than 0
	//if greater
	//	split the digits using mod ten
	//	And insert 5 if the next digit is greater than 5
	@Test
	public void dataSetOne()
	{
		int number=1234;
		System.out.println(insertFive(number));
	}

	@Test
	public void dataSetTwo()
	{
		int number=7643;
		System.out.println(insertFive(number));
	}

	@Test
	public void dataSetThree()
	{
		int number=0;
		System.out.println(insertFive(number));
	}

	@Test
	public void dataSetFour()
	{
		int number=-26;
		System.out.println(insertFive(number));
	}
	
	@Test
	public void dataSetFIVE()
	{
		int number=723;
		System.out.println(insertFive(number));
	}

	private int insertFive(int number)
	{
		int digit=0; ;int output=0;
		int postion=0;
		if(number>=0)
		{
			int tempnumber=number;
			while(tempnumber>=0)
			{
				digit =tempnumber%10;
				tempnumber=tempnumber/10;
				postion++;
				if(digit>5||tempnumber==0)
				{	
				if(tempnumber==0&&digit<5)	postion++;
				postion=(int)Math.pow(10, postion-1);
				output=	((number/(postion))*(postion*10))+(5*postion)+(number%postion);
				break;
				}
			}

		}
		else
		{	number=number*(-1);
			int tempnumber=number;
			while(tempnumber>=0)
			{
				digit =tempnumber%10;
				tempnumber=tempnumber/10;
				postion++;
				if(digit<5||tempnumber==0)
				{	
				if(tempnumber==0&&digit>5)	postion++;
				postion=(int)Math.pow(10, postion-1);
				output=	(-1)*(((number/(postion))*(postion*10))+(5*postion)+(number%postion));
				break;
				}


			}
		}
		return output;
	}
}
