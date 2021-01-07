package arraysandstrings;

import org.junit.Test;

public class CountOne_DC 
{
	
	@Test
	public void dataSetOne(){
		int[] array  = {0,0,0,0,1,1};
		System.out.println(countOne(array));
	}
	
	@Test
	public void dataSetTwo(){
		int[] array  = {1,1,1,1,1,1};
		System.out.println(countOne(array));
	}
	
	@Test
	public void dataSetThree(){
		int[] array  = {0,0,1,1,1};
		System.out.println(countOne(array));
	}
	
	

private int countOne(int[] array)
{
	
	
	return divideAndCount(0,array.length-1,array);
	
}

private int divideAndCount(int start, int end, int[] array )
{
	if(array[end]==0) return 0;
	
	if(array[start]==1) return end-start+1;
	
	int mid=(end+start)/2;
	return divideAndCount(start, mid, array)+divideAndCount(mid+1, end, array);
	
}
}
