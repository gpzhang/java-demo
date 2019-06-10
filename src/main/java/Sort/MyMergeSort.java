package Sort;

import java.util.Arrays;

public class MyMergeSort {
	/**
	 * ��·�鲢����ĵݹ��㷨-���
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T extends Comparable> boolean mergeSortRecursive(T[] t){
		if(t==null || t.length <= 1) return true;
		
		MSortRecursive(t, 0, t.length-1);
		
		return true;
	}
	
	/**
	 * ��·�鲢����ĵݹ��㷨-�ݹ�����
	 * @param <T>
	 * @param t
	 * @param low
	 * @param high
	 * @return
	 */
	private static <T extends Comparable> boolean MSortRecursive(T[] t, int low, int high){
		
		if(t==null || t.length <= 1 || low == high) return true;
		
		int mid = (low+high)/2;
		MSortRecursive(t, low, mid);
		MSortRecursive(t, mid+1, high);
		merge(t, low, mid ,high);
		
		return true;
	}
	
	/**
	 * 2-·�鲢����ķǵݹ��㷨��
	 * �㷨˼·��
	 * �ӹ鲢�εĳ���Ϊ1��ʼ��һ��ʹ�鲢�εĳ��ȱ�Ϊԭ����2����
	 * ��ÿ�˹鲢�Ĺ����У�Ҫע�⴦��鲢�εĳ���Ϊ������
	 * ���һ���鲢�εĳ��Ⱥ�ǰ��Ĳ��ȵ����
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T extends Comparable> boolean mergeSortNonRecursive(T[] t){
		if(t==null || t.length<=1) return true;
		
		int len = 1;
		//����߽�Ĵ���ǳ���Ҫ
		while(len <= t.length){
			for(int i = 0 ; i+len<=t.length-1 ;i += len*2){
				int low = i, mid = i+len-1, high = i+len*2-1;
				if(high>t.length-1) high = t.length-1;
				merge(t, i, mid, high);
			}
			
			len *= 2;
		}
		return true;
	}
	
	
	/**
	 * �������鲢�κϲ���һ���鲢��
	 * @param <T>
	 * @param t
	 * @param low
	 * @param mid
	 * @param high
	 * @return
	 */
	private static <T extends Comparable> boolean merge(T[] t, int low, int mid, int high){		
		T[] s = t.clone();//�ȸ���һ����������
		
		int i, j, k;//����ָʾ����iָʾt[low...mid]��jָʾt[mid+1...high]��kָʾs[low...high]
		for(i=low, j=mid+1, k=low ; i<=mid && j<=high ; k++){
			if(t[i].compareTo(t[j]) <= 0){
				s[k] = t[i++];
			}else{
				s[k] = t[j++];
			}
		}
		
		//��ʣ�µ�Ԫ�ظ��Ƶ�s��
		if(i <= mid){
			for( ; k <= high; k++){
				s[k] = t[i++];
			}
		}else{
			for( ; k<=high; k++){
				s[k] = s[j++];
			}
		}
		for(int m = low; m<=high ; m++){//�����������е�����õ�Ԫ�ظ��ƻ�ԭ����
			t[m] = s[m];
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{2,3,6,8,9,2,0,1,88,99,12,17};
		long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
		//mergeSortNonRecursive(arr);
		mergeSortRecursive(arr);
		long endTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
		System.out.println("ִ��ʱ�䣺"+(endTime-startTime));
		System.out.println(Arrays.toString(arr));
	}
}

