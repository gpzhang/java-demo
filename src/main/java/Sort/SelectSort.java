package Sort;

import java.util.Arrays;

public class SelectSort {
	public byte[] Sort(byte[] by) {
		// �򵥵�ѡ������
		for (int i=0; i<by.length;i++) {
			int min = by[i];//����ȡ����ֵΪ��Сֵ0
			int n = i; // �ٶ�����С����λ������
			for (int j = i + 1; j < by.length; j++) {
				if (by[j] < min) { // �ҳ���С����
					min = by[j];//����С������ֵ������min��j����ʵ��С����λ������
					n = j;//�޸ļ������С����λ������
				}
			}
			by[n] = by[i];//�����ҵ�����С������Ѽ�����Ǹ���С��ֵ�ŵ���ȡ��ʵ����С����ԭ��λ��,����һ�˱Ƚϵ���Сֵָ��λ��
			by[i] = (byte) min;//�ѱȽ�֮���ȡ����С��ֵ�ŵ���Ӧ��λ��
			System.out.println("ѡ�������"+(i+1)+"�Σ�"+Arrays.toString(by));
		}
		return by;
	}
	
	public byte[] mysort(byte[] by){
		for(int i=0;i<by.length;i++){
			int min=by[i];
			int positionIndex=i;
			for(int j=i+1;j<by.length;j++){
				if(by[j]<min){
					min=by[j];
					positionIndex=j;
				}
			}
			by[positionIndex]=by[i];
			by[i]=(byte) min;
			System.out.println("ѡ�������"+(i+1)+"�Σ�"+Arrays.toString(by)+" :::");
		}
		return by;
	}
}
