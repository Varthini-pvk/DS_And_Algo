package ArraysAndStrings;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class P001_IndicesOfSum {
	
	@Test
	public void dataSet_One()
	{
		int[] numbers= {1, 2,3,4,6,8,5};
		int target=5;
		int[] indicesOfSum = getIndicesOfSum(numbers,target);
		System.out.println(Arrays.toString(indicesOfSum));
	}
	@Test
	public void dataSet_Two()
	{
		int[] numbers= {1, 2,3,-8,-4};
		int target=5;
		int[] indicesOfSum = getIndicesOfSum(numbers,target);
		System.out.println(Arrays.toString(indicesOfSum));
	
	}
	@Test
	public void dataSet_Three()
	{
		int[] numbers= {1, 2,3,-8,-4,3,1,4};
		int target=5;
		int[] indicesOfSum = getIndicesOfSum(numbers,target);
		System.out.println(Arrays.toString(indicesOfSum));
	}
	
	private int[] getIndicesOfSum(int[] numbers,int target)
	{
		for(int i=0;i<numbers.length;i++) 
		{
			for(int j=i+1;j<numbers.length;j++)
			{
				if(numbers[i]+numbers[j]==target)
				{
					System.out.println("Indices: "+i+" "+j);
					return new int[] {i,j};
				}
			}
		}
		throw new RuntimeException("No match");
		
	}

}
