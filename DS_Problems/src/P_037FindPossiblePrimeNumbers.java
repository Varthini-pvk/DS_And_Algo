

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class P_037FindPossiblePrimeNumbers {


	@Test
	public void dataSetOne()
	{
		counter=0;
		int input=8713;
		System.out.println(findPrime(input));
		System.out.println("Counter: "+counter);
	}


	@Test
	public void dataSetTwo()
	{
		counter=0;
		int input=403198305;
		System.out.println(findPrime(input));
		System.out.println("Counter: "+counter);
	}

	@Test
	public void dataSetThree()
	{
		counter=0;
		int input=44;
		System.out.println(findPrime(input));
		System.out.println("Counter: "+counter);
	}

	//Solution 1
	private Set<Integer> findPrime(int input)
	{
		String string = Integer.toString(input);
		Set<Integer>outputList=new HashSet<Integer>();
		for(int i=0;i<string.length();i++)
		{
			for(int j=i;j<string.length();j++)//O[N^2]
			{
				int currentnumber = Integer.parseInt(string.substring(i,j+1));

				if(currentnumber>2)
				{
					if(isPrime(currentnumber))
						outputList.add(currentnumber);
				}
			}

		}
		return outputList;
	}



	//Solution 2
	static int counter=0;
	private Set<Integer> findPrime2(int input)
	{
		int count = Integer.toString(input).length();
		int divisor=(int)Math.pow(10, count-1);

		Set<Integer>inputList=new HashSet<Integer>();
		Set<Integer>outputList=new HashSet<Integer>();
		while(divisor>0)//0[N-1]
		{	

			inputList.add(input);
			inputList.add(input/divisor);
			int localDivisor=10;
			for(int i=0;i<count-2 && input>10;i++)	//0[n-1*m];m==current length-2;
			{
				counter++;
				inputList.add(input/localDivisor);
				localDivisor=localDivisor*10;
			}
			input=input%divisor;
			divisor=divisor/10;
			count--;
		}
		System.out.println(inputList);
		for(int i:inputList)
		{
			if(i>2)
			{
				if(isPrime(i))
					outputList.add(i);
			}

		}
		return outputList;
	}

	private boolean isPrime(int input)//O[K];k-->input
	{
		for(int i=2;i<=input/2;i++)
		{
			if(input%i==0)
				return false;
		}
		return true;
	}
}
