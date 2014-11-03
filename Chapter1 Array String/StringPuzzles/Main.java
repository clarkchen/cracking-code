/**
 * 
 */
package StringPuzzles;
import static org.junit.Assert.assertTrue;

import java.util.*;
/**
 * @author chenxi
 *
 */
public class Main {
	//1.3 given two strings tell if s1 can be reordered and become s2
	//we assert that s1 and s2 is consist of 'a-z'
	//but we can also make it TO ANSCII which is 256 characters
	public boolean reorderTheSame(String s1, String s2)
	{
		if(s1==null ){return s2==null;}
		if(s1.length()!=s2.length()) return false;
		
		int[] charNum =  new int[256];
		 	
		for(char c: s1.toCharArray())
		{
			charNum[c]++;
		}
		//normally we test if sc1[i]!=0 it is false
		//but if they are not same will definately be some place where sc1[c] less than 0
		for(char c: s2.toCharArray())
		{
			if(--charNum[c]<0) return false;
		}
	 
		return true;
	}
	
	//1.4 given a char []s and len of string, where s.length >> len,find a way to replace all the space to "%20"
	//offer a solution time com O(N) space O(1)
	//very wonderful idea, from the back to front 
	public int replaceSpace(char[] s, int length )
	{
		if (length<=0) return -1;
		
		//count space
		int space = 0;
		for(char c:s){if(c==' ') space++;}
		
		int newLen = length+ 2*space;
		if(s.length-1 < newLen) return -1; 
		s[newLen] = '\0';
		for(int i= length-1,j=newLen-1;i>=0;i--)
		{
			if(s[i]==' ')
			{
				s[j--] = '0';s[j--] = '2';s[j--]='%';
				
			}
			else {
				s[j--] = s[i];
			}
		}
		return newLen;
		
	}
	
	/**
	 * 1.5 Compress String 
	 * aabaa covert to a2b1a2 but the new string len is larger so stay in  aabaa;	
	 * aaaaabaaaaaa  convert to a5b1a6 smaller so be it 
	 * trick is pre check the lenght, save the space to O(1) for long test cases
	 */
	public String compressString(String s1)
	{
		if(s1==null || s1.length()<=2) return s1;
		
		int size = 0;
		int i=0,j;
		while(i<s1.length())
		{
			j=0;
			while(i<s1.length()-1 && s1.charAt(i)== s1.charAt(i+1)){j++;i++;}
			i++;
			size += 1+String.valueOf(j+1).length();
		}
		if(size>=s1.length()) return s1;
		StringBuffer sb = new StringBuffer();
		i=0;
		while(i<s1.length())
		{
			j=0;
			while(i<s1.length()-1 && s1.charAt(i)== s1.charAt(i+1)){j++;i++;}
			i++;
			sb.append(s1.charAt(i-1)+String.valueOf(j+1));
		}
		return sb.toString();
	}
	
	
	
	// 1.6 N*N matrix turn 90 degree counterclockwise
	// row i turn to cloumn i
	public void transferMatrix(int [][] N)
	{
		int height = N.length;
		int width  = N[0].length;
		
		for(int i=0;i<height/2;i++)
		{
			for(int j=0;j<width/2;j++)
			{
				Transfer(i,j,4,N,N[i][j]);
			}
		}
	}
	//for transferMatrix
	void Transfer(int i, int j, int c, int [][]N, int value)
	{
		if(c==0) return;
		int x = N.length-1-j;
		int y = i;
		int temp =N[x][y];
		N[x][y] =value;
		Transfer(x,y,(c-1),N,temp);
	}
	
	//1.7 for a M*N matrix A if A[i][j] equals 0, then row i and column j will be set all zeros
	//record first and set letter
	public void resetMatrix (int [][]A)
	{
		int height = A.length;
		int width = A[0].length;
		boolean rows []=  new boolean[height];
		boolean cols [] =  new boolean [width];
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				if(A[i][j]==0)
				{
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				if(rows[i]||cols[j])
					A[i][j] = 0;
			}
		}
		
	}
	
	//1.8 tell if s2 can be moved to s1 in a cycle 
	//like "terbottlewa" can be moved starting from "waterbottle"
	// "wwwaabbb" cna be moved from "wwabbbw"
	// and is sub string can be used only once;
	public boolean canbeMoved(String s1, String s2)
	{
		if(s1.length()!=s2.length()) return false;
		if(s1.equals(s2)) return true;
		if(s1.length()<2) return false;
		
		String n = s1+s1;
		
		return n.indexOf(s2)>-1;
		 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		String s1 = "terbootlewa";
		String s2 = "waterbottle";
//		assertTrue(m.canbeMoved(s1, s2));
	}

}
