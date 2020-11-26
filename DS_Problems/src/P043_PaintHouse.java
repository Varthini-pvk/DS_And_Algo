import org.junit.Test;

public class P043_PaintHouse {

	@Test
	public void dataSetOne()
	{
		int[][] cost=new int[][] {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
		System.out.println("One"+findLowestCost(cost));
	}


	@Test
	public void dataSetTwo()
	{
		int[][] cost=new int[][] {};
		System.out.println("Two"+findLowestCost(cost));
	}

	@Test
	public void dataSetThree()
	{
		int[][] cost=new int[][] {{7,6,2}};
		System.out.println("Three"+findLowestCost(cost));
	}


	@Test
	public void dataSetFour()
	{
		int[][] cost=new int[][] {{17, 2, 1}, {16, 16, 1}, {14, 3, 19}, {3, 1, 8}};
		System.out.println("Four"+findLowestCost(cost));
	}


	private int findLowestCost(int[][] input)
	{
		int minCost=0;
		if(input.length>0)
		{
		int[][] tempArray=new int[input.length][3];
		tempArray[0][0]=input[0][0];
		tempArray[0][1]=input[0][1];
		tempArray[0][2]=input[0][2];
		for(int j=1;j<input.length;j++)
		{

			{
				tempArray[j][0]=Math.min(tempArray[j-1][1], tempArray[j-1][2])+input[j][0];
				tempArray[j][1]=Math.min(tempArray[j-1][0], tempArray[j-1][2])+input[j][1];
				tempArray[j][2]=Math.min(tempArray[j-1][0], tempArray[j-1][1])+input[j][2];
			}
		}

		minCost=Math.min(tempArray[input.length-1][0], tempArray[input.length-1][1]);
		minCost=Math.min(minCost, tempArray[input.length-1][2]);
		}
		return minCost;
	}

}
