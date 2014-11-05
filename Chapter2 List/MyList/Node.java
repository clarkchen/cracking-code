package MyList;
import java.util.*;
public class Node {
	public Integer value;
	public Node next;
	public Node(Integer value, Node next) {
		 
		this.value = value;
		this.next = next;
	}
	
	public Node(Integer value  ) {
		 
		this.value = value;
		this.next = null;
	}
}
