package ArraysAndStrings;
import org.junit.Test;

public class P013_FindThePeakElementMountainArray {
	
	//Problem
//	 Find the peak index in a mountain array
//
//	 Example 1:
//
//	 Input: arr = [0,1,0]
//	 Output: 1
//	 Example 2:
//
//	 Input: arr = [0,4,2,0]
//	 Output: 1
//
//	 Example 3:
//
//	 Input: arr = [0,10,5,2]
//	 Output: 1
	
//DataSets
	
@Test
public void dataSetOne()
{
	int[] array= {0,10,5,2};
	System.out.println("One:"+findPeak(array));
}
@Test
public void dataSetTwo()//Peak element is less than n/2
{
	int[] array= {0,10,8,7,5,4,0};
	System.out.println("Two:"+findPeak(array));
}
@Test
public void dataSetThree()//with duplicate elements
{
	int[] array= {0,5,6,7,7,9,9,10,8,7,6,5,4,3};
	System.out.println("Three:"+findPeak(array));
}

@Test
public void dataSetFour()//with negative numbers and duplicate peak number
{
	int[] array= {-3,-2,0,5,6,7,7,9,9,8,7,6,5,4,3};
	System.out.println("Four:"+findPeak(array));
}

@Test
public void dataSetFive()//Peak element is greater than n/2
{
	int[] array= {0,5,8,9,10,0};
	System.out.println("Five:"+findPeak(array));
}
//Approach One

//(Peak element is always the highest number in the array)


//1.Loop through the length of the array to find index of the highest number

private int findPeak1(int[] array)
{
	int peakIndex=0;
	int temp=0;//O[1]
	for(int i=1;i<array.length;i++)
	{
		if(array[0]<array[i])//O[N]
		{
			temp=array[0];
			array[0]=array[i];
			array[i]=temp;
			peakIndex=i;
		}
	}
	return peakIndex;//O[N]	
}
//Total time complexity=O[N]

//Approach Two
//Till Peak element the array keeps increasing and then Keeps decreasing

//1. Loop Through the length of array
// 		check if the next element is greater than the current element
//		if true: continue
//		else:	return the current element

private int findPeak(int[] array)
{
	int i=0;
	for(;i<array.length;i++)
	{
		if(array[i]>array[i+1])//O[M]
		{
			break;
			
		}
	}
	return i;//O[N]	
}
//Total time complexity=O[M]

//Approach 3
//Mostly Peak Element is near to the middle of the Array,
//Loop starting from middle to right /left to find the peak

//1. Calculate length/2=k
//2. compare k and next element
//3.if the next element is greater, then loop towards right
//     	find the element, for which the next element is lesser than current element
// 		return the current element
//else: loop towards left to find the peak
//      find the element for which the previous element is lesser than the current element 
//      return the current element

private int findPeak3(int[] array)
{
	System.out.println(array.length);
	int middle=array.length/2;
	Boolean peakIsInLeft=false;int j=1;
	
	if(array[middle]==array[middle+1])//To handle duplicate elements
	{
		while(array[middle]==array[middle+j])//O[1]
		{
			j++;
		}
	peakIsInLeft=findPeakSide(array[middle],array[middle+j]);//O[1]
	}
	
	peakIsInLeft=findPeakSide(array[middle],array[middle+j]);//O[1]
	
	if(peakIsInLeft)//O[M]
	{
		while(array[middle-1]>array[middle] && middle>0)
		{
			middle--;
		}
	}
	else
	{

		while(array[middle+1]>array[middle] && middle<array.length)
		{
			middle++;
		}
	}
	return middle;
}

private boolean findPeakSide(int middleNnumber,int numberToCompare)
{
	if(middleNnumber>numberToCompare)
	{
		return true;
	}
	else
	{
		return false;
	}
}
//Total Time Complexity==>3*O[1]+O[M]==>O[M]

}
