package Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class Temperatures {
	
	
	@Test
	public void dataSetOne()
	{
		int[] temperatures= {73,74,75,69,72,76,73};
		//System.out.println(Arrays.toString(nextHighTemp(temperatures)));
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] temperatures= {89,62,70,58,47,47,46,76,100,70};
		System.out.println(Arrays.toString(nextHighTemp(temperatures)));
	}

	
	
	
	public int[] nextHighTemp(int[] input)
	{
		int[] output=new int[input.length];
		Stack<Integer> ref=new Stack<>();
		int popIndex=0;
		for(int i=0;i<input.length;i++)
		{
			while(!ref.isEmpty()&&input[i]>input[ref.peek()])
			{
				popIndex=ref.pop();
				output[popIndex]=i-popIndex;
			}
			ref.push(i);
		}
		return output;
	}
}
