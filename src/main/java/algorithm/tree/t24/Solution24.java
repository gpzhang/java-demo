package algorithm.tree.t24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Solution24 {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> list = new ArrayList<String>();
		if (str == null)
			return list;
		char[] ch = str.toCharArray();
		TreeSet<Character> hashSet=new TreeSet<Character>();
		for(int i=0;i<ch.length;i++){
			hashSet.add(ch[i]);
		}//无重复存入到set集合中
		
		Collections.sort(list);
		return list;

	}

	public static void main(String[] args) {
		Solution24 su24 = new Solution24();
	}
}
