package algorithm.tree.t26;

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution26 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(k>input.length)
			return list;
		TreeSet<Integer> temp=new TreeSet<>();
		for(int i=0;i<input.length;i++){
			temp.add(input[i]);
		}
		int j=0;
		for(Integer i:temp){
			if(j==k)break;
			list.add(i);
			j++;
			
		}
		
		return list;

	}
	public static void main(String[] args) {
		
	}
}
