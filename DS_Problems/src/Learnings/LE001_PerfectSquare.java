package Learnings;

import org.junit.Test;

public class LE001_PerfectSquare 
{

@Test
public void dataSetone()
{
	int input=808201;
	System.out.println(isPerfectSquare(input));
}

public boolean isPerfectSquare(int num) 
{
    if(num==1) return true;
    int start=1;int end=num/2;long temp=0;int mid=0;
    while(start<=end)
    {
        mid=((start+end)/2);
        temp=num/mid;
        if(temp==mid && num%mid==0 ) return true;
        else if(temp<mid) end=mid-1;
        else start=mid+1;
    }
   return false;
}}
