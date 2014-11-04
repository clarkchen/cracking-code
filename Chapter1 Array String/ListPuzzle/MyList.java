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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
