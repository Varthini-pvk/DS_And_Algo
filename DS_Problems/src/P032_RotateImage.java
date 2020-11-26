

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

//	@Test
//	public void dataSetOne() 
//	{
//		int[][] input = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		System.out.println(Arrays.deepToString(input));
//		int[][] output = rotateImage(input);
//		System.out.println(Arrays.deepToString(output));
//	}


////	@Test
//	public void dataSetTwo() 
//	{
//		int[][] input = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
//		System.out.println(Arrays.deepToString(input));
//		int[][] output = rotateImage(input);
//		System.out.println(Arrays.deepToString(output));
//	}
//
//
	@Test
	public void dataSetFour() 
	{
		int[][] input = new int[][] { { 5,1,9,11}, {2,4,8,10}, { 13,3,6,7}, { 15,14,12,16} };
		System.out.println(Arrays.deepToString(input));
		int[][] output = rotateImage(input);
		System.out.println(Arrays.deepToString(output));
	}
	

	//Solution 1
	//Loop through the length of Array(all columns)
	//Loop through the each Column and in the add the items to the corresponding row in the new array
	//Swap row and Column


	private int[][] rotateImage1(int[][] input)
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

	
	//Solution 2
		//

		private int[][] rotateImage2	(int[][] input)
		{

			int n=input.length-1; 
			
			int i=0;int j=input.length-1;int tempOne=0;
			while(i<j)
			{
				int k=i;
				for(int l=0;l<j-i;l++)
				{
					
					tempOne=input[k][j];
					input[k][j]=input[i][k];
					input[i][k]=input[n-k][i];
					input[n-k][i]=input[j][n-k];
					input[j][n-k]=tempOne;
					k++;
				
				}
				i++;j--;
			}
			
			return input;
		}
		//Total Time Complexity=O[N^2]
		
	//Solution 3
		private int[][] rotateImage (int[][] input)
		{
			int temp=0;int k=input.length-1;int i=0;
			while(i<k)
			{
				
				for(int j=0;j<input.length;j++)
				{
					temp=input[i][j];
					input[i][j]=input[k][j];
					input[k][j]=temp;
				}
				k--;i++;
			}
			for(i=0;i<input.length;i++)
			{
				for(int j=i+1;j<input.length;j++)
				{
					temp=input[i][j];
					input[i][j]=input[j][i];
					input[j][i]=temp;
				}
			}
			return input;
		}
		

}
