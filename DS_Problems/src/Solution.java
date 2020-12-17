import org.junit.Test;

public class Solution 
{


	@Test
	public void sumOddLengthSubarrays() 
	{
		int[] arr= {6,9,14,5,3,8,7,12,13,1};
		int length=arr.length;int sum=0;int start=0;int end=length-1;int i=0;
		if(length==1||length==2) 
		{
			for(int j=0;j<length;j++)
				sum+=arr[j];
		}
		else if(length==3)
		{
			for(int j=0;j<length;j++)
				sum+=arr[j]*2;

		}
		else
		{
			length=  length%2==0?(length)/2:(length+1)/2;

			int temp=length+i;
			while(start<end)
			{

				sum+=arr[start]*temp;
				sum+=arr[end]*temp;
				start++;end--;
				i++;
				temp=length+i;
			}
			if(start==end)
				sum+=arr[start]*temp;

		}
		System.out.println(sum);
	}
}


