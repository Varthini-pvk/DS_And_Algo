import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//
//Given an array of intervals where intervals[i] = [starti, endi], merge
//all overlapping intervals, and return an array of the non-overlapping 
//intervals that cover all the intervals in the input.


public class P085_MergeIntervals 
{

	@Test
	public void dataSetOne()
	{
		int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};
		System.out.println(Arrays.deepToString(merge(intervals)));
	}
	
	@Test
	public void dataSetTwo()
	{
		int[][] intervals= {{1,4},{1,5}};
		System.out.println(Arrays.deepToString(merge(intervals)));
	}

	public int[][] merge1(int[][] intervals) 
    {
		List<int[]>output=new ArrayList<>();
        //int[][]output=new int[intervals.length][2];
        int j=0;int k=0; Boolean overlap=false;int start=j;
        while(j<intervals.length)
        {
            start=j;
            while(j<intervals.length-1&&intervals[j][1]>intervals[j+1][0])
            {
                j++;
                overlap=true;
            }
            if(overlap)
            {
            	output.add(new int[] {intervals[start][0],intervals[j][1]});
            }   
            else
            {
            	output.add(new int[] {intervals[j][0],intervals[j][1]});
                
            }
            k++;j++;
        }
         return output.stream().toArray(int[][]::new);
    }
	
	public int[][] merge(int[][] intervals) 
    {
		List<int[]>output=new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        
        int[] current_interval=intervals[0];int current_end=0;
        output.add(current_interval);
        for(int i=0;i<intervals.length;i++) 
        {
            current_end = current_interval[1];
            if(output.isEmpty()||current_end>=intervals[i][0])
            {
                current_interval[1]=Math.max(current_end,intervals[i][1]);
            }
            else
            {
                current_interval=intervals[i];
                output.add(current_interval);
            }
           
        }
         return output.stream().toArray(int[][]::new);
    }
       
}
