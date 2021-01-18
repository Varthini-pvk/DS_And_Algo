package arraysandstrings;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;



import org.junit.Test;
import org.junit.internal.ArrayComparisonFailure;

public class P086_KclosestpointstoOrigin 
{

	@Test
	public void datasetOne()
	{
		int[][] points= {{1,3},{-2,2}};
		int k=1;
		System.out.println(Arrays.deepToString(kClosest(points,k)));
	}
	
	@Test
	public void datasetThree()
	{
		int[][] points= {{3,3},{5,-1},{-2,4}};
		int k=2;
		System.out.println(Arrays.deepToString(kClosest(points,k)));
	}
	@Test
	public void datasetFour()
	{
		int[][] points= {{2,2},{2,2},{2,2},{2,2},{2,2},{2,2},{1,1}};
		int k=1;
		System.out.println(Arrays.deepToString(kClosest(points,k)));
	}
	@Test
	public void datasetTwo()
	{
		int[][] points= {{1,0},{0,1}};
		int k=1;
		System.out.println(Arrays.deepToString(kClosest(points,k)));
	}


	//Solution 1
	public int[][] kClosest1(int[][] points, int K) 
	{

		int[] d=new int[points.length];
		
		int k=0;int j=1;int temp=0;int[] tempArray= {};int t=k;
		int[][] output=new int[points.length][2];
		for(int i=0;i<points.length;i++)
		{
			d[k]=(points[i][0]*points[i][0])+(points[i][1]*points[i][1]);
			output[k]=points[k];
			t=k;
			while(t-j>=0&&d[t-1]> d[t])
			{
				temp=d[t];
				d[t]=d[t-j];
				d[t-j]=temp;
				tempArray=output[t];
				output[t]=output[t-j];
				output[t-j]=tempArray;
				t--;

			}
			j=1;k++;

		}


		return Arrays.copyOfRange(output, 0, K);

	}
	
	public int[][] kClosest2(int[][] points, int K) 
	{

		Arrays.sort(points, (a,b)->dist(a)-dist(b));
		return Arrays.copyOfRange(points, 0, K);

	}
	private int dist(int[] point)
	{
		return point[0]*point[0]+point[1]*point[1];
	}
	
	
	public int[][] kClosest(int[][] points, int K) 
	{
		int part=-1;int start=0,end=points.length-1;
		while(part!=K-1)
		{
		part= partition(start,end,points);
		if(part>K-1)
			end=part-1;
		else
			start=part+1;
		}
		return Arrays.copyOfRange(points, 0, K);

	}

	private int partition(int start, int end, int[][] points)
	{
		int pivot=start;
		int d_pivot=points[pivot][0]*points[pivot][0]+points[pivot][1]*points[pivot][1];
		start++;
		while(start<=end)
		{
			if(points[start][0]*points[start][0]+points[start][1]*points[start][1]>d_pivot)
			{
				swap(start,end,points);
				end--;
			}
			else
				start++;
		}
		swap(end,pivot,points);
		return end;
	}
	
	private void swap(int a,int b,int[][] array)
	{
		int[] temp=array[a];
		array[a]=array[b];
		array[b]=temp;
		
	}
}
