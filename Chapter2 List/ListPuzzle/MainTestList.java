package ListPuzzle;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import MyList.MyList;
import MyList.Node;


/**
 * @author chenxi
 * 为链表类写的测试脚本
 */
public class MainTestList {
	Main m = new Main();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void removeDuplitcateTest() {
		List<Integer> l =  new ArrayList<Integer>();
		l.add(1);l.add(6);l.add(2);l.add(3);
		l.add(5);l.add(2);l.add(3);l.add(4);
 		m.removeDuplitcate(l);
 		int [] res = {1,6,5,2,3,4};
		for(int i=0;i<res.length;i++)
		{
			assertTrue(res[i]==l.get(i));
		}
	}
	
	@Test
	public void theLastNeleTest()
	{
		int a[] = {1,2,3,4,5,6,7,8,9,10};
		MyList ml = new MyList();
		ml.insert(a);
		Node rt = m.theLastNele(ml, 4);
		assertTrue(rt.value==7);
		rt = m.theLastNele(ml, 10);
		assertTrue(rt.value==1);
	}

	@Test
	//2.3 deleteNodeFrom
	public void deleteNodeFrom()
	{
		int a[] = {1,2,3,4,5,6,7,8,9,10};
		MyList ml = new MyList();
		ml.insert(a);
		
		Node n = ml.search(7);
		m.deleteNodeFrom(n);
		int b[] = {1,2,3,4,5,6,8,9,10};
		ml.output();
		assertTrue(ml.equalTest(b));
		
	}
}
