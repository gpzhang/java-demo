package algorithm.tree.t21;

import java.util.Stack;
//栈的压入、弹出序列，出栈的数据不允许在再进入栈
public class Solution21 {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if(pushA.length==0||popA.length==0)
			return false;
		
		Stack<Integer> stack=new Stack<>();//创建一个栈,把入栈序列一次放入到占中,
		//比较的条件是
		for(int i=0,j=0;i<pushA.length;i++){
			stack.push(pushA[i]);//每把一个数字放入栈中之后,下一步都要进行判断，和已知的出栈序列的数值进行比较，如果入栈不为空，并且如果值相等了，就进行出栈操作，
			while(!stack.isEmpty()&&stack.peek()==popA[j]){//只要入栈的栈顶元素和popA[j]的值相等，就出栈
				j++;
				stack.pop();
			}
		}
		//最后如果入栈空了的话，说明出栈顺序的数据是按照入栈的顺序来的，入栈
		return stack.isEmpty()?true:false;

	}

	public static void main(String[] args) {

	}
}
