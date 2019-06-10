package Sort;

import java.util.Arrays;

public class BubbleSort {
	public byte[] Sort(byte[] by) {
		for (int i = 0; i < by.length; i++) {
			//ÿ�Ƚ���һ�Σ��������ݶ������ģ���˲���Ҫ����Ƚϡ�
			for (int j = 0; j < by.length-i-1; j++) {				
				if (by[j] > by[j + 1]) {
					byte temp = by[j + 1];
					by[j + 1] = by[j];
					by[j] = temp;
				}
			}
			System.out.println("ð�������"+(i+1)+"�Σ�"+Arrays.toString(by));
		}
		return by;
	}
}
