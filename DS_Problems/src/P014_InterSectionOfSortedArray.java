import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class P014_InterSectionOfSortedArray {
	
//Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.
//
//Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
//Output: [1,5]
	
//DataSets
	
@Test
public void dataSetOne()
{
	int[] arrayOne= {1,2,3,4,5};
	int[] arrayTwo= {1,2,5,7,9};
	int[] arrayThree= {1,3,4,5,8};
	Set<Integer> findIntersection = findIntersection(arrayOne,arrayTwo,arrayThree);
	System.out.println("One:");
	if(findIntersection.isEmpty())
	{
		System.out.println("No Common Values");
	}
	else
	{
		System.out.println(findIntersection);
	}
}

@Test
public void dataSetTwo()//with duplicate numbers
{
	int[] arrayOne= {1,2,3,3,5};
	int[] arrayTwo= {1,2,5,7,9};
	int[] arrayThree= {1,3,5,5,8};
	Set<Integer> findIntersection = findIntersection(arrayOne,arrayTwo,arrayThree);
	System.out.println("Two:");
	if(findIntersection.isEmpty())
	{
		System.out.println("No Common Values");
	}
	else
	{
		System.out.println(findIntersection);
	}
}

@Test
public void dataSetThree()//with negative numbers and inequal size
{
	int[] arrayOne= {-1,0,2,3,4,5,9};
	int[] arrayTwo= {1,2,5,7,9};
	int[] arrayThree= {1,3,4,5,8,9};
	Set<Integer> findIntersection = findIntersection(arrayOne,arrayTwo,arrayThree);
	System.out.println("Three:");
	if(findIntersection.isEmpty())
	{
		System.out.println("No Common Values");
	}
	else
	{
		System.out.println(findIntersection);
	}
}

//Approach One

//1. for each array loop till the length of the array
//2. Check if the element is present in the other two arrays
//	iftrue : Add to the result array

Set<Integer> result=new HashSet<Integer>();
private Set<Integer> findIntersection1(int[] arrayOne,int[] arrayTwo,int[] arrayThree)
{
	checkForIntersection(arrayOne,arrayTwo,arrayThree);
	checkForIntersection(arrayTwo,arrayOne,arrayThree);
	checkForIntersection(arrayThree,arrayTwo,arrayOne);
	return result;
	
	
}

private void checkForIntersection(int[] source, int[] referenceOne, int[] referenceTwo)
{
	Boolean flag=true;
	for(int i=0;i<source.length;i++)
	{
		for(int j=0;j<referenceOne.length;j++)//O[N^2]
		{
			flag=false;
			if(source[i]==referenceOne[j])
			{
				flag=true;
				break;
				
			}
		}


		if(flag)
		{
			for(int k=0;k<referenceTwo.length;k++)//O[N^2]
			{
				if(source[i]==referenceTwo[k])
				{
					result.add(source[i]);
					break;
					
				}
			}
		}
	}
}
 //Total Time Complexity=3*[2*[O[N^2]==>O[N^2]

//Approach Two:
//As the elements are arrange is increasing order,
//if a element is lesser, no need to compare the element in next iterations)

//Loop Till the length of arrays
//compare the current element from all arrays
//if all elements are same, add to the result set
//else find out the lowest element and increment the respective counter
//if two elements are lowest, increment he respective counters

private Set<Integer> findIntersection(int[] arrayOne,int[] arrayTwo,int[] arrayThree)
{	
	int i=0;int j=0;int k=0;
	Set<Integer> resultOne=new HashSet<Integer>();
	while(i<arrayOne.length && j<arrayTwo.length && k<arrayThree.length)
	{
		if(arrayOne[i]==arrayTwo[j] && arrayOne[i]==arrayThree[k])//O[N]
		{
			resultOne.add(arrayOne[i]);
			i++;j++;k++;
		}
		//To find the lowest of 3 numbers (also if the lowest number is present in both arrays)
		else
		{
			if(arrayOne[i]<arrayTwo[j])
			{
				if(arrayOne[i]<arrayThree[k])
				{
					i++;
				}
				else if(arrayOne[i]==arrayThree[k])
				{
					i++;k++;
				}
			}
			else if(arrayOne[i]>arrayTwo[j])
			{
					if(arrayTwo[j]<arrayThree[k])
					{
						
					if(arrayOne[i]==arrayTwo[j])
					{
						j++;i++;
					}
					else
					{
					j++;
					
					}
					}
				else
				{
					if(arrayTwo[j]==arrayThree[k])
					{
						j++;k++;
					}
					else
					{
						k++;
					}	
				}
				
			}
			else if(arrayOne[i]==arrayTwo[j])
			{
				i++;j++;
			}
		}		
				
				
		
	}
return resultOne;
	
}}
