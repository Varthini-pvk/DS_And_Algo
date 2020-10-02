

import java.util.Arrays;
import org.junit.Test;

public class P032_RotateImage {

	/*
	 * Rotate an image
	 * 
	 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [[7,4,1],
	 * 													  [8,5,2],
	 * 										              [9,6,3]]
	 */

	@Test
	public void dataSetOne() 
	{
		int[][] input = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] output = rotateImage(input);
		System.out.println(Arrays.deepToString(input));
		System.out.println(Arrays.deepToString(output));
	}


	@Test
	public void dataSetTwo() 
	{
		int[][] input = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] output = rotateImage(input);
		System.out.println(Arrays.deepToString(input));
		System.out.println(Arrays.deepToString(output));
	}


	@Test
	public void dataSetThree() {
		int[][] input = new int[][] { { 1, 2 }, { 3, 4 } };
		int[][] output = rotateImage(input);
		System.out.println(Arrays.deepToString(input));
		System.out.println(Arrays.deepToString(output));
	}

	

	//Solution 1
	//Loop through the length of Array(all columns)
	//Loop through the each Column and in the add the items to the corresponding row in the new array
	//Swap row and Column


	private int[][] rotateImage(int[][] input)
	{

		int[][] output=new int[input.length][input[0].length];
		int resultColumn=input[0].length-1;
		for(int inputrow=0;inputrow<input.length;inputrow++)//O[N]
		{
			int resultrow=0;
			for(int inputColoumn=0;inputColoumn<input[0].length;inputColoumn++)//O[N]
			{
				output[resultrow][resultColumn]=input[inputrow][inputColoumn];
				resultrow++;
			}
			resultColumn--;
		}

		return output;
	}
	//Total Time Complexity=O[N^2]


}
