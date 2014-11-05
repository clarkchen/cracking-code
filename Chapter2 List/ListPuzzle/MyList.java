package ListPuzzle;
import java.util.*;
public class MyList {
	Node head,tail;
	int size = 0;
	public void insert(int a[])
	{
		if(a==null||a.length==0) return;
		if(head==null) head = new Node(a[0]);
		Node cur = head;
		for(int i=1;i<a.length;i++)
		{
			cur.next =  new Node(a[i]);
			cur = cur.next;
		}
		tail = cur;
		size +=a.length;
	}
	public void output()
	{
		Node cur =head;
		while(cur!=null)
		{
			System.out.print( cur.value+"  ");cur= cur.next;
		}
		System.out.println();
	}
	public Node search(int value)
	{
		Node cur = head;
		while(cur!=null && cur.value!=value) cur =cur.next;
		return cur;
	}
	public boolean equalTest(int []a)
	{
		int i=0;
		Node cur =head;
		while(i<a.length && cur!=null && cur.value == a[i])
		{
			cur =cur.next;i++;
		}
		return cur==null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
