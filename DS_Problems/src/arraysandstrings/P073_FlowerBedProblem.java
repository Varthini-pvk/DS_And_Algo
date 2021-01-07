package arraysandstrings;

import org.junit.Test;

public class P073_FlowerBedProblem {
	
	@Test
	public void dataSetOne()
	{
		int[] input= {1,0,0,0,1};
		int n=1;
		System.out.println(plantFlower(input,n));
	}

	@Test
	public void dataSetTwo()
	{
		int[] input= {1,0,0,0,1};
		int n=2;
		System.out.println(plantFlower(input,n));
	}
	
	@Test
	public void dataSetThree()
	{
		int[] input= {0,0,0,0,1};
		int n=2;
		System.out.println(plantFlower(input,n));
	}

	@Test
	public void dataSetFour()
	{
		int[] input= {0,0,0,0,1};
		int n=0;
		System.out.println(plantFlower(input,n));
	}


	public boolean plantFlower(int[] flowerbed, int n) {
	       
       int i=0;
       while(n>0&&i<flowerbed.length)
        {
           
            if(flowerbed[i]==0)
            {
                if((i==0||flowerbed[i-1]==0)&&(i==flowerbed.length-1||flowerbed[i+1]==0))
                {
                    n--;i++;
                }
            }
            else
            {
               i++;
            }
           i++;
        }
        return (n==0);
    }
}
