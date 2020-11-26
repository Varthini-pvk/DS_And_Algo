package trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import trees.Tree.Node;

public class AddToTree {

	@Test
	public void setOne()
	{
		int[] input= {2,5,6};
		
		System.out.println(CheckBST(input));
	}

	Tree<Integer> t=new Tree<Integer>();
	static Node root;

	//Solution 1
	public Boolean CheckBST(int[] array)
	{
		List<Integer>output=new LinkedList<>();
		List<Integer> ref=new LinkedList<>();
		root=t.new Node(array[0]);
		for(int i=1; i<array.length;i++)
		{
			t.insertBST(root, array[i]);
		}

		output=t.InorderTraversal(root);
		ref=t.InorderTraversal(root);
		Collections.sort(ref);
		if(output.equals(ref))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Solution 2

	public void insert(int[] array)
	{
		root=t.new Node(array[0]);
		for(int i=1; i<array.length;i++)
		{
			t.insertBST(root, array[i]);
		}
	}
	public Boolean CheckBST2(Node node)
	{
		if(node!=null)
		{

			CheckBST2(node.left);
			CheckBST2(node.right);
		}
		else
		{
			if(node.left!=null)
			{
				if(node.left.data.compareTo(node.data)>0)
				{
					return false;
				}
			}
			if(node.right!=null)
			{
				if(node.data.compareTo(node.right.data)>0)
				{
					return false;
				}
			}

			
		}

		return true;
	}

	}
