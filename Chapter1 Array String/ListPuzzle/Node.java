package ListPuzzle;
import java.util.*;
public class Node {
	Integer value;
	Node next;
	public Node(Integer value, Node next) {
		 
		this.value = value;
		this.next = next;
	}
	
	public Node(Integer value  ) {
		 
		this.value = value;
		this.next = null;
	}
}
