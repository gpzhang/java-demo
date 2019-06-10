package Sort;

import java.util.Arrays;

public class InsertSort {

	public byte[] Sort(byte[] by) {
		for (int i = 1; i < by.length; i++) {
			int temp = by[i];//ȡ��Ҫ�������������
			int j = i;
			while (j > 0 && by[j - 1] > temp) {//Ҫ��������ݺ����ź�������ݣ����մ��ҵ������αȽ�
			
				by[j] = by[j - 1];//�������ֵ���ڵ�ǰλ�õ�ֵ����ǰλ�õ�ֵ�����һλ
				j--;
			}
			by[j] = (byte) temp;
			System.out.println("���������" + (i) + "�Σ�" + Arrays.toString(by));
		}
		return by;
	}
	
	public byte[] mySort(byte[] by){
		for(int i=1;i<by.length;i++){
			int temp=by[i];
			int j=i;
			while(j>0 && temp < by[j-1] ){
				by[j]=by[j-1];//����������ֵ���ڴ������ֵ�����������ֵ����һλ��
				j--;//ͬʱ�������ֵ�����ʹ������ֵ���бȽ�				
			}//���������ֵ�����������ֵ����ǰλ�þ��Ǵ�����Ĵ��λ�ã���Ϊ��ߵĶ���С�ڴ�����ֵ
			//��ʱ��λ��Ӧ����j
			by[j]=(byte)temp;
			System.out.println("���������" + (i) + "�Σ�" + Arrays.toString(by)+"::");
		}
		return by;
	}
}
