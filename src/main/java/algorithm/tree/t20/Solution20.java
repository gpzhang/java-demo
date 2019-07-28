package algorithm.tree.t20;
import java.util.Stack;
public class Solution20 {
	Stack<Integer> stack=new Stack<Integer>();
	public void push(int node) {
		stack.push(node);//入栈操作

	}

	public void pop() {
		stack.pop();//移除栈顶元素
	}

	public int top() {
		return stack.peek();//返回栈顶元素，并没有从栈中移除元素

	}

	public int min() {//返回栈中最小的元素
		Stack<Integer> stackTemmp=new Stack<Integer>();
		if(stack.isEmpty())
			return 0;
		int min=top();
		while(!stack.isEmpty()){
			if(min>stack.peek()){
				stackTemmp.push(stack.peek());
				min=stack.pop();
			}else{
				stackTemmp.push(stack.peek());
				stack.pop();
			}
		}
		while(!stackTemmp.isEmpty()){
			/*if(!stackTemmp.peek().equals(min)){
				stack.push(stackTemmp.pop());
			}else{
				stackTemmp.pop();
			}*/
			stack.push(stackTemmp.pop());
		}
		return min;

	}

	public static void main(String[] args) {
		Solution20 su20 = new Solution20();
		su20.push(1);
		su20.push(2);
		su20.push(5);
		su20.push(6);
		su20.push(8);
		su20.push(4);
		System.out.println(su20.stack.size());
		System.out.println(su20.min());
		System.out.println(su20.min());
		System.out.println(su20.min());

	}
}
