package algorithm.tree.t54;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution54 {
	HashMap<Character, Integer> map = new HashMap<>();
	ArrayList<Character> list = new ArrayList<>();

	// Insert one char from stringstream
	public void Insert(char ch) {
		if(map.containsKey(ch)){
			map.put(ch, map.get(ch)+1);
		}else{
			map.put(ch, 1);
		}
		list.add(ch);
		
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		char c='#';
		for(char key:list){
			if(map.get(key)==1){
				c=key;
				break;
				
			}
		}
		return c;
	}
}
