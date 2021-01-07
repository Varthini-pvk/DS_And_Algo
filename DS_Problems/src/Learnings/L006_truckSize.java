package Learnings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

//Input: mobileTypes = [[1,3],[2,2],[3,1]], truckSize = 4 mobileSizes
//Output: 8

//Loop through the length of array(for each row)
//Find the max mobile number
//For each row calculate , the number of mobiles( model*number of mobiles)
//decrement the model count from the trucksize
//continue  till the trucksize is zero


public class L006_truckSize 
{

@Test
public void dataSetOne()
{
	int[][] mobiles= {{2,2},{3,1},{1,3}};
	int truckModelLimit=4;
	maxMobile(mobiles,truckModelLimit);
	
	
}

private void maxMobile(int[][] mobiles, int truckModelLimit)
{
	Arrays.sort(mobiles, 0,mobiles.length);
	//Arrays.sort(mobiles, compareby
	System.out.println(Arrays.deepToString(mobiles));
}
}
