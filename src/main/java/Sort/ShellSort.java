package Sort;

import java.util.Arrays;

public class ShellSort {
	public byte[] Sort(byte[] by) {
		int d = by.length;
		while (true) {
			d = d / 2;
			// x��ʾ������������ֶ�����λ��
			for (int x = 0; x < d; x++) {// ȡ���������������ȵ�����
				// i��ʾ��x��Ӧ����������λ��
				for (int i = x + d; i < by.length; i = i + d) {// ȡ����������ݣ����ʼֵ�Ƚϡ�
					int temp = by[i];// ȡ�����������
					int j;// j��ʾ��������λ���ϵ��ֶ�����λ��
					for (j = i - d; j >= 0 && temp < by[j]; j = j - d) {// ��ֵ�Ƚϴ�ķŵ���λ
						by[j + d] = by[j];// ��Ϊtemp<by[j]������jλ�õ�ֵ����,����[j]λ�õ�������Ҫ�ƶ���[j+d]λ����
					}
					by[j + d] = (byte) temp;
				}
				System.out.println("ϣ�������" + (x + 1) + "�Σ�" + Arrays.toString(by));
			}
			if (d == 1) {
				break;
			}
		}
		return by;
	}

	public byte[] MySort(byte[] by) {
		int d = by.length;
		while (true) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < by.length; i = i + d) {
					int temp = by[i];
					int j;
					for (j = i - d; j >= 0 && temp < by[j]; j = j - d) {
						by[j + d] = by[j];
					}
					by[j + d] = (byte) temp;
				}
			}
			System.out.println("ϣ������ڴΣ�" + Arrays.toString(by));
			if (d == 1) {
				break;
			}
		}
		return by;
	}
}
