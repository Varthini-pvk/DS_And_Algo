package ArraysAndStrings;
import org.junit.Test;

//Write a Java program for the
//below given word problem:
//Given number cold coffee bottles, you can exchange empty bottles for one full cold coffee bottle.The operation of drinking a full
//cold coffee bottle turns it into an empty bottle.Return the maximum number of
//cold coffee bottles you can drink.

public class P046_ReturnBottles {


	@Test
	public void dataSetOne()
	{
		int numberOfBottles=9;
		int numberOfExchange=3;
		System.out.println("One :"+findMaxBottles(numberOfBottles,numberOfExchange));
	}


	@Test
	public void dataSetTwo()
	{
		int numberOfBottles=15;
		int numberOfExchange=4;
		System.out.println("Two :"+findMaxBottles(numberOfBottles,numberOfExchange));

	}
	
	@Test
	public void dataSetThree()
	{
		int numberOfBottles=3;
		int numberOfExchange=4;
		System.out.println("Three :"+findMaxBottles(numberOfBottles,numberOfExchange));

	}

	@Test
	public void dataSetFour()
	{
		int numberOfBottles=3;
		int numberOfExchange=2;
		System.out.println("Four :"+findMaxBottles(numberOfBottles,numberOfExchange));

	}

//	
//	if(numBottles == 0 || numExchange > numBottles) {
//        return numBottles;
//    }
	private int findMaxBottles(int numberOfBottles,int numberOfExchange)
	{
		int total=numberOfBottles;
		int bottlesForExchange=numberOfBottles/numberOfExchange;
		while(bottlesForExchange>=1)
		{
			total+=bottlesForExchange;
			numberOfBottles=bottlesForExchange+numberOfBottles%numberOfExchange;
			bottlesForExchange=numberOfBottles/numberOfExchange;
			
		}

		return total;
	}

}
