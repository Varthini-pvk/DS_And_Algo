package MockAssesments;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;



public class Problem3 {

	public static String getLargestString(String s, int k) {

		String outputStr = "";
		int[] refArray=new int[26];
		int count=0;int next=0;
		for(int i=0;i<s.length();i++)
		{
			refArray[s.charAt(i)-'a']++;
		}
		for(int i=refArray.length-1;i>=0;i--)
		{
			next=i-1;
			while(refArray[i]>0)
			{
				count=0;
				while(refArray[i]>0&&count<k)
				{
					refArray[i]--;
					outputStr+=(char)(i+'a');
					count++;
				}
				while(next>0&&refArray[next]<1)
				{
					next--;
				}
				if(next==0&&refArray[next]<1) break;
				refArray[next]--;
				outputStr+=(char)(next+'a');


			}
		}
		return outputStr;

	}

	@Test
	public  void dataSetOne() {
		String s = "azzzzz";
		int k = 2;
		System.out.println(getLargestString(s, k));
	}
	@Test
	public  void dataSetTwo() {
		String s = "azzzzza";
		int k = 2;
		System.out.println(getLargestString(s, k));
	}
	@Test
	public  void dataSetThree() {
		String s = "cccba";
		int k = 2;
		System.out.println(getLargestString(s, k));
	}



}
