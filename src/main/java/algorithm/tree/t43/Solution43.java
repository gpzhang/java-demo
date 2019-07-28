package algorithm.tree.t43;

public class Solution43 {
	public String LeftRotateString(String str, int n) {
		if(str==null||n<0)
			return str;
		int l=str.length();
		if(l>=n){
			str=(str+str).substring(n,l+n);
		}
		return str;

	}
	public static void main(String[] args) {
		Solution43 su43=new Solution43();
		String s="";
		System.out.println(su43.LeftRotateString(s, 6));
	}
}
