import java.util.Arrays;

import org.junit.Test;

public class P034_MaxPlatForm {
	
	//DataSet
	@Test
	public void dataSetOne()
	{
		int[] arrival= {900,940,950,1100,1500,1800};
		int[] departutre= {910,1200,1120,1130,1900,2000};
		System.out.println(findPlatformNeeded(arrival,departutre));
		
	}
	
	private int findPlatformNeeded(int[] arrival,int[] departure)
	{
//		Arrays.sort(arrival);
//		Arrays.sort(departure);
		int maximumneed=1;int currentNeed=1;
		int i=1;int j=0;
		while(i<arrival.length)
		{
			if(arrival[i]>departure[j]&&currentNeed>1)
			{
				currentNeed--;
			}
			if(arrival[i]<departure[j])
			{
				currentNeed++;
			}
			if(currentNeed>maximumneed)
			{
				maximumneed++;
			}
			i++;j++;
		}
		return maximumneed;
	}

}
