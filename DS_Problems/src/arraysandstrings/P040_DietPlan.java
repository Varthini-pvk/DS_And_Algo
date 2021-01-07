package arraysandstrings;
import org.junit.Test;

//A dieter consumes calories[i] calories on the i-th day. 
//
//Given an integer k, for every consecutive sequence of k days (calories[i], calories[i+1], ..., calories[i+k-1] for all 0 <= i <= n-k), they look at T, the total calories consumed during that sequence of k days (calories[i] + calories[i+1] + ... + calories[i+k-1]):
//
//If T < lower, they performed poorly on their diet and lose 1 point; 
//If T > upper, they performed well on their diet and gain 1 point;
//Otherwise, they performed normally and there is no change in points.
//Initially, the dieter has zero points. Return the total number of points the dieter has after dieting for calories.length days.
//
//Note that the total points can be negative.
//
// 
//
//Example 1:
//
//Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
//Output: 0
//Explanation: Since k = 1, we consider each element of the array separately and compare it to lower and upper.
//calories[0] and calories[1] are less than lower so 2 points are lost.
//calories[3] and calories[4] are greater than upper so 2 points are gained.
//Example 2:
//
//Input: calories = [3,2], k = 2, lower = 0, upper = 1
//Output: 1
//Explanation: Since k = 2, we consider subarrays of length 2.
//calories[0] + calories[1] > upper so 1 point is gained.
//Example 3:
//
//Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5
//Output: 0
//Explanation:
//calories[0] + calories[1] > upper so 1 point is gained.
//lower <= calories[1] + calories[2] <= upper so no change in points.
//calories[2] + calories[3] < lower so 1 point is lost.


public class P040_DietPlan {
	
	
	@Test
	public void dataSetOne() 
	{
		int[] calories= {1,2,3,4,5};
		int k=1;
		int lower=3;
		int upper=3;
		System.out.println("One: "+countPoints(calories,k,lower,upper));
		
	}
	
	@Test
	public void dataSetTwo() 
	{
		int[] calories= {3,2};
		int k=2;
		int lower=0;
		int upper=1;
		System.out.println("Two: "+countPoints(calories,k,lower,upper));
		
	}
	
	@Test
	public void dataSetThree()
	{
		int[] calories= {6,5,0,0};
		int k=2;
		int lower=1;
		int upper=5;
		System.out.println("Three: "+countPoints(calories,k,lower,upper));
	}

	
	private int countPoints(int[] array, int k,int lower,int upper)
	{
		int points=0;int i=0;int localSum=0;int localCount=0;
		if(k<array.length)
		{
			while(i<array.length)
			{
				while(i<array.length&&localCount<k)
				{
					localSum+=array[i++];
					localCount++;
					
				}
				if(localSum>upper)
				points++;
				if(localSum<lower)
				points--;
				localSum=0;
				localCount=0;
				
			}
		
		
		}
		return points;
	}
	}
