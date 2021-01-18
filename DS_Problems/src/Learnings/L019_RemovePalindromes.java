package Learnings;

import org.junit.Test;

public class L019_RemovePalindromes
{
	
	@Test
	public void dataSetOne()
	{
		String input="ababa";
		removePalindromes(input);
		System.out.println(count);
	}
	
	@Test
	public void dataSettwo()
	{
		String input="abab";
		removePalindromes(input);
		System.out.println(count);
	}
	
	//Declare Two variables start=0, end=arraysize
	//Calculate mid=left+right/2
	//check from mid or mid and adjacent character on both sides, whether the characters are equal on both sides
	//if not break and repeat with next character as mid
	//continue till the length of string on both sides
	
	int count=0;
	private void removePalindromes(String input)
	{
		char[] inputArray=input.toCharArray();
		removePalindromeRec(0,input.length()-1,inputArray);
	}
	private void removePalindromeRec(int start, int end, char[] a) {
		int mid=(start+end)/2;
		int i=1;
		if(mid<0||mid>end)
		{
			return;
		}
//		if(a[mid]==a[mid+1]&&a[mid]!=a[mid-1])
//		{
//			int midTwo=mid+1;
//			while(a[midTwo+i]==a[mid-i])
//			{
//				i++;
//			}
//			
//		}
//		else if(a[mid]==a[mid-1]&&a[mid]!=a[mid+1])
//		{
//			int midTwo=mid-1;
//			while(midTwo-i==mid+i)
//			{
//				i++;
//			}
//			
//		}
		else
		{
			while((mid-i>=start&&mid+i<=end)&&a[mid+i]==a[mid-i])
			{
				i++;
			}
		}
		count++;
		removePalindromeRec(0,mid-i-1,a);
		removePalindromeRec(mid+i+1,end,a);
		
	}

}
