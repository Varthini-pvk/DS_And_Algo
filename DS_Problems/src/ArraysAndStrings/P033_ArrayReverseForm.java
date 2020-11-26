package ArraysAndStrings;
import org.junit.Test;

//Given a matrix, print it in Reverse Wave Form.
//
//Input :  1  2  3  4
//         5  6  7  8
//         9  10 11 12
//         13 14 15 16
//		 
//Output : 4 8 12 16 15 11 7 3 2 6 10 14 13 9 5 1

public class P033_ArrayReverseForm {
	
//DataSets

@Test
public void dataSetOne()
{
	int[][] input=new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	System.out.println("One:");
	printReverseWaveForm(input);
}
@Test
public void dataSetTwo()
{
	int[][] input = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	System.out.println("Two:");
	printReverseWaveForm(input);
}
@Test
public void dataSetThree()
{
	int[][] input = new int[][] { { 1, 2 }, { 3, 4 } };
	System.out.println("Three:");
	printReverseWaveForm(input);
}

private void printReverseWaveForm(int[][] input)
{
	int colCount=0;
	for(int i=input.length-1;i>=0;i--)//O[N]
	{
		if(colCount%2!=0)
		{
			for(int j=input[0].length-1;j>=0;j--)//O[N]
			{
				System.out.print(input[j][i]+",");
			}
		}
		else
		{
			for(int j=0;j<input[0].length;j++)
			{
				System.out.print(input[j][i]+",");
			}
		}
		colCount++;
	}
}

//Total Time Complexity=O[N^2]
}
