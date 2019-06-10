package Sort;

import java.util.Arrays;

//�鲢����֮JAVAʵ��(������)
public class MergeSort {

	public void Merge(int[] array, int low, int mid, int high) {

		int i = low; // i�ǵ�һ�����е��±�
		int j = mid + 1; // j�ǵڶ������е��±�
		int k = 0; // k����ʱ��źϲ����е��±�
		int[] arrayTemp = new int[high - low + 1]; // arrayTemp����ʱ�ϲ�����
		// ɨ���һ�κ͵ڶ������У�ֱ����һ��ɨ�����
		while (i <= mid && j <= high) {
			// �жϵ�һ�κ͵ڶ���ȡ�������ĸ���С���������ϲ����У�����������ɨ��
			if (array[i] <= array[j]) {
				arrayTemp[k] = array[i];
				i++;// С����ǰ��
				k++;
			} else {
				arrayTemp[k] = array[j];
				j++;// С����ǰ��
				k++;
			}
		}

		// ����һ�����л�ûɨ���꣬����ȫ�����Ƶ��ϲ�����
		while (i <= mid) {
			arrayTemp[k] = array[i];
			i++;
			k++;
		}
		// ���ڶ������л�ûɨ���꣬����ȫ�����Ƶ��ϲ�����
		while (j <= high) {
			arrayTemp[k] = array[j];
			j++;
			k++;
		}

		// ���ϲ����и��Ƶ�ԭʼ������
		for (k = 0, i = low; i <= high; i++, k++) {
			array[i] = arrayTemp[k];
		}

	}

	/**
	 * 
	 * @param array
	 *            ����������
	 * @param gap
	 *            �鲢�����鳤��
	 * @param length
	 *            ����������ĳ���
	 */
	public void MergePass(int[] array, int gap, int length) {

		int i = 0; // ÿ�˺ϲ�����ʼλ������(���Ǵӵ�һ����ʼ)
		// �鲢gap���ȵ����������ӱ�
		// (i + 2 * gap - 1) ���κϲ��������������ұ����е��������λ��
		// (i = i + 2 * gap) ����ϲ�����ʼ����λ��
		// ͨ��(i + 2 * gap - 1 <length)�ıȽϿ�
		// ���жϳ��Ƿ�ʣ��������Խ��кϲ������С�ڣ�˵�����ٻ���������Խ��кϲ�,
		// �����С�ڣ�˵��ֻʣһ�飬����ʣ�µ�һ�飬���ù���
		// 1��ʣ��һ�飬����С��Ҳ���ܵ���һ��gap����
		// 2��ʣ�����飬���һ��С��һ��gap����
		for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
			Merge(array, i, i + gap - 1, i + 2 * gap - 1);// �˷���ʵ�־���ıȽϹ���
			// ÿһ������������������֮��,ͨ��(i = i + 2 * gap)����������һ��������������
		}

		// �������������µ������ӱ�,ǰ��������ĳ���Ϊ��ǰgap,���߳���С�ڱ��κϲ������е�gap
		// ͨ��(i + gap - 1 < length)�ıȽϿ��������һ��ϲ���ǰ��Ĵ�����ȥ��
		System.out.println("(" + i + "+" + gap + "-1)=" + (i + gap - 1) + "==" + length);
		if (i + gap - 1 < length) {
			Merge(array, i, i + gap - 1, length - 1);// ��������ʣ��һ��������,��(i + gap -
														// 1)==(length - 1)
		}
	}

	public int[] Sort(int[] list) {
		int cishu = 0;
		for (int gap = 1; gap < list.length; gap = 2 * gap) {
			MergePass(list, gap, list.length);// �˷���ʵ�־���ıȽϹ���
			System.out.println("�鲢�����[" + (++cishu) + "]�Σ�" + Arrays.toString(list));
		}
		return list;
	}

}
