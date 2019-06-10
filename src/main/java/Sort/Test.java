package Sort;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		
		System.out.println("*********************ð������*********************");
		byte[] by=new byte[]{6,9,11,3,4,15,13,10};
		/*ð������*/
		BubbleSort bs=new BubbleSort();
		bs.Sort(by);
		
		System.out.println("*********************��������*********************");
		byte[] by1=new byte[]{6,9,11,3,4,15,13,10};
		/*��������*/
		QuickSort qs=new QuickSort();
		System.out.println(Arrays.toString(qs.quick(by1)));
		
		System.out.println("********************��������**********************");
		byte[] by2=new byte[]{6,9,11,3,4,15,13,10};
		/*��������*/
		InsertSort is=new InsertSort();
		is.Sort(by2);
		
		System.out.println("********************ϣ������**********************");
		byte[] by3=new byte[]{6,9,11,3,4,15,13,10};
		/*ϣ������*/
		ShellSort ss=new ShellSort();
		ss.Sort(by3);
		
		System.out.println("********************ѡ������**********************");
		/*ѡ������*/
		byte[] by4=new byte[]{6,9,11,3,4,15,13,10};
		SelectSort ss2=new SelectSort();
		ss2.Sort(by4);
		
		System.out.println("********************�ǵݹ�ʽ�Ĺ鲢����**********************");
		//�ǵݹ�ʽ�Ĺ鲢����
		int[] by5=new int[]{6,9,11,3,4,15,13,10,18};
		MergeSort merge = new MergeSort();
		merge.Sort(by5);
	}
	
}
