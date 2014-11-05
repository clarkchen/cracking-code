/**
 * 
 */
package ListPuzzle;
import java.util.*;
/**
 * @author chenxi
 *
 */
public class Main {
	
	
	//2.1 remove the duplicate elements of an unsorted list 
	public void removeDuplitcate(List<Integer> a)
	{
		if(a==null ||a.size()==0 ) return ;
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for(int i=a.size()-1;i>=0;i--)
		{
			if(hm.containsKey(a.get(i)))
			{
				a.remove(i);
			}
			else hm.put(a.get(i), 1);
		}
	}
	
	
	//2.2 return the last K element of a list
	public Node theLastNele(MyList ml,int  k)
	{
		if(ml==null|| ml.head==null) return null;
		Node rt=ml.head,cur = ml.head;
		int i;
		for( i=0;i<k-1;i++) {
			if(cur == null) break;
			cur = cur.next;
		}
		if(i!=k-1) return null;
		
		while(cur!=ml.tail)
		{
			cur = cur.next;
		    rt = rt.next;
		}
		
		return rt;
	}
	//2.3 delete a node and you can only visit it 
	//we can only do this if the node has a next element 
	//reset all the value of nodes after n 
	public void deleteNodeFrom(Node n)
	{
		if(n==null||n.next==null)
		{
			System.out.println("Can not handle such situation");
			return;
		}
		Node cur = n.next, pre = n;
		while(cur.next!=null)
		{
			pre.value = cur.value;
			cur = cur.next;
			pre = pre.next;
		}
		pre.value = cur.value;
		pre.next = null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
