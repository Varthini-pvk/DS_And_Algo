package MockAssesments;

import org.junit.Test;

//Given an array of integers, without reordering, determine the maximum
//difference between any element and any prior smaller difference. If
//there is never a lower prior element, return -1.
//Example
//arr = [5, 3, 6, 7, 4]
//There are no earlier elements than arr[0].
//There is no earlier reading with a value lower than arr[1].
//There are two lower earlier readings with a value lower than arr[2] = 6:
//arr[2] - arr[1] = 6 - 3 = 3
//arr[2] - arr[0] = 6 - 5 = 1
//There are three lower earlier readings with a lower value than arr[3] = 7:
//arr[3] - arr[2] = 7 - 6 = 1
//arr[3] - arr[1] = 7 - 3 = 4
//arr[3] - arr[0] = 7 - 5 = 2
//There is one lower earlier reading with a lower value than arr[4] = 4:
//arr[4] - arr[1] = 4 - 3 = 1
//The maximum trailing record is arr[3] - arr[1] = 4.

public class A1P02 {
	

@Test	
public void dataSetOne()
{
	int[] input= {5, 3, 6, 7, 4};
	System.out.println("o"+riverRecords(input));
}

@Test	
public void dataSetTwo()
{
	int[] input= {4,3,2,1};
	System.out.println(riverRecords(input));
}

@Test	
public void dataSetThree()
{
	int[] input= {7,9,5,6,3,2};
	System.out.println(riverRecords(input));
}



private int riverRecords(int[] input)
{
	int nextLeader=input[input.length-1];
	int localLowest=nextLeader;int localDifference=0; int maximumDifference=-1;
	int i=input.length-1;int localLowestCount=0;
	
	while(i>0)
	{
		
		if(input[i-1]<localLowest)
		{
			localLowest=input[i-1];
			localLowestCount++;
		}
		if((input[i-1]>nextLeader)||i==1)
		{
			if(localLowestCount>0)
			{
			localDifference=nextLeader-localLowest;
			if(localDifference>maximumDifference)
			{
				maximumDifference=localDifference;
			}
			}
			nextLeader=input[i-1];
			localLowest=nextLeader;
			localLowestCount=0;
			
		}
		
		i--;
	}
	return maximumDifference;
}
}
