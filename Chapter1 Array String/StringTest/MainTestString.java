package StringTest;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import StringPuzzles.Main;

/**
 * @author chenxi
 * Cracking Code Test Scripts
 */
public class MainTestString {
	Main m = new Main();
	@Test
	public void testreorderTheSame() {
		String s1="abcd";
		String s2 = "dcba";
		
		assertTrue(m.reorderTheSame(s1, s2));
		assertTrue(m.reorderTheSame(s1, s2+"abc")==false);
		String s3="acdd";
		assertFalse(m.reorderTheSame(s1, s3));
		
	}
	
	@Test
	public void testreplaceSpace()
	{
		char s[] = new char [100];
		String s1= "nice to meet you ";
		int i=0;
		for(char c:s1.toCharArray())
		{
			s[i++] = c;
		}
		int len2 = m.replaceSpace(s, s1.length());
		String s2 ="";
		
		for(i=0;i<len2;i++)
		{
			s2+=s[i];
		}
		assertTrue(s2.equals("nice%20to%20meet%20you%20"));
		
	}
	@Test
	public void testcompressString()
	{
		String s1 = "aabaa";
		String s2 = m.compressString(s1);
		assertTrue(s1.equals(s2));
		s1 = "aaaaabaaaaaa";
		s2 = m.compressString(s1);
		assertTrue(s2.equals("a5b1a6"));
	}
	
	@Test
	public void testtransferMatrix()
	{
		int [][] n = {{1,2,3,4},
					  {5,6,7,8},
					{9,10,11,12},{13,14,15,16}};
		int [][] newN =  {{4,8,12,16},{3,7,11,15},{2,6,10,14},{1,5,9,13}};
		
		m.transferMatrix(n);
		
		boolean same=true;
		for(int i=0;i<n.length;i++)
		{
			for(int j=0;j<n.length;j++)
			{
				if(n[i][j]!=newN[i][j]) 
				{
					same = false;break;
				}
			}
			if(!same) break;
		}
		
		for(int[]l:n)
		{
			for(int i:l)
				System.out.print(i+" ");
			System.out.println();
		}
		
		assertTrue(same);
	}
	
	@Test
	public void testresetMatrix()
	{
		int [][] n = {{1,2,3,4},
				      {5,6,7,8},
				      {9,10,11,12},
				      {13,14,0,16}};
		int [][] newN =  {{1,2,0,4},
					      {5,6,0,8},
					      {9,10,0,12},
					      {0,0,0,0}};
		m.resetMatrix(n);
		boolean same=true;
		for(int i=0;i<n.length;i++)
		{
			for(int j=0;j<n.length;j++)
			{
				if(n[i][j]!=newN[i][j]) 
				{
					same = false;break;
				}
			}
			if(!same) break;
		}
		assertTrue(same);
	}
	@Test
	public void testcanbeMoved()
	{
		String s1 = "terbottlewa";
		String s2 = "waterbottle";
		assertTrue(m.canbeMoved(s1, s2));
 
		s1= "wwwabbb";
		s2 ="wwabbbw";
		assertTrue(m.canbeMoved(s1, s2));
		assertTrue(m.canbeMoved(s2, s1));
	}
}
