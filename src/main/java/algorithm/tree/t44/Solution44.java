package algorithm.tree.t44;

public class Solution44 {
	public String ReverseSentence(String str) {
		if (str.length() <= 0 || str.trim().equals("")) {
			// 要trim()，可能输入多个空格组成的字符串
			return str;
		}
		String[] strArray = str.split(" ");
		int length = strArray.length;
		
		StringBuffer sb = new StringBuffer();
		int j=length-1;
		for (;j>0; j--) {
			sb.append(strArray[j] + " ");
		}
		sb.append(strArray[0]);
		return sb.toString();

	}

	public static void main(String[] args) {
		Solution44 su44 = new Solution44();
		String str = "a b c d e";
		System.out.println(su44.ReverseSentence(str));

	}
}
