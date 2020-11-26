package queue;

import org.junit.Test;

public class JosephusSword {
	
	
	@Test
	public void setOne()
	{
		System.out.println("Set One: "+jSword(8));
	}
	@Test
	public void setTwo()
	{
		System.out.println("Set Two: "+jSword(77));
	}
	@Test
	public void setThree()
	{
		System.out.println("Set Three: "+jSword(13));
	}
	@Test
	public void setFour()
	{
		System.out.println("Set Four: "+jSword(1));
	}
	
	@Test
	public void setFive()
	{
		System.out.println("Set Five: "+jSword(100));
	}

	//Solution 1
	public int jSword1(int number)
	{
		QueueImpl<Integer> q=new QueueImpl<>();
		
		for(int i=1;i<=number;i++)
		{
			q.enqueue(i);
		}
		while(q.size()>1)
		{
			Integer dequeue = q.dequeue();
			q.enqueue(dequeue);
			q.dequeue();
		}
		
		return q.peek();
	}
	
	//Solution 2
	public int jSword(int number)
	{
		int a=(int)(Math.log(number)/Math.log(2));
		int twoPower=(int)Math.pow(2,a);
		int l=number-twoPower;
		return 2*l+1;
	}
}
