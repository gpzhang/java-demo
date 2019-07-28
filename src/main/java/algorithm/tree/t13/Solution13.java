package algorithm.tree.t13;

import java.util.Arrays;

public class Solution13 {
	public void reOrderArray(int[] array) {
		if(array.length==0){
			return;
		}
		int j=-1;
		int temp=0;
		for(int i=0;i<array.length;i++){
			if(array[i]%2==0){//整除，为偶数
				j=i;//记录偶数的位置
			}else{
				if(j!=-1){
					for(int k=i;k>=0;k--){
						if(array[k]%2==0){//寻找最左边的偶数
							j=k;//记录偶数的位置
						}
					}
					temp=array[i];
					for(int n=i;n>j;n--){
						array[n]=array[n-1];//奇数之前的数据向右移一位
					}
					array[j]=temp;//把获取的第一个奇数放到先前偶数的位置上
				}
			}
		}

	}

	public static void main(String[] args) {
		Solution13 su = new Solution13();
		int[] array = new int[] {2,4,6,1,3,5,7};
		su.reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
}
