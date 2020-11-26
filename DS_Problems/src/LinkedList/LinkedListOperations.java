package LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListOperations {

	public static void main(String[] args) {
		
		try {
			List<String> teamNames=new LinkedList<>();
			teamNames.add("Bharathi");
			teamNames.add("Lakshmi");
			teamNames.add("Sethu");
			teamNames.add("Sooraj");
			teamNames.add("Varthini");
			
			System.out.println(teamNames);
			
			String searched=teamNames.listIterator(3).next();
			System.out.println(searched);
			
			teamNames.remove("Varthini");
			System.out.println(teamNames);
			
			ListIterator<String> listIterator = teamNames.listIterator();
			while(teamNames.listIterator().hasNext())
			{
				if(listIterator.next()=="Varthini")
				{
					System.out.println("true");
				}
				
			}
		} catch (Exception e) {
			System.out.println("Not found");
			
		}
		
		
	}

}
