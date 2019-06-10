package Sort;
//LSD��ʵ�� (���λ����)
public class RadixSort {

    // ��ȡx�������dλ���ϵ�����
    // �����ȡ123��1λ�����������3
    public int getDigit(int x, int d) {
        int a[] = { 1, 1, 10, 100 }; // ��ʵ���е�������ǰ�λ��������ֻҪ��100�Ϳ�����
        return ((x / a[d]) % 10);
    }

    public void radixSort(int[] list, int begin, int end, int digit) {
        final int radix = 10; // ����
        int i = 0, j = 0;
        int[] count  = new int[radix]; // ��Ÿ���Ͱ������ͳ�Ƹ���
        int[] bucket = new int[end - begin + 1];

        // ���մӵ�λ����λ��˳��ִ���������
        for (int d = 1; d <= digit; d++) {

            // �ÿո���Ͱ������ͳ��
            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }

            // ͳ�Ƹ���Ͱ��Ҫװ������ݸ���
            for (i = begin; i <= end; i++) {
                j = getDigit(list[i], d);
                count[j]++;
            }

            // count[i]��ʾ��i��Ͱ���ұ߽�����
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            // ����������װ��Ͱ��
            // ����Ҫ��������ɨ�裬��֤�����ȶ��� 
            for (i = end; i >= begin; i--) {
                j = getDigit(list[i], d); // ����ؼ���ĵ�kλ�����֣� ���磺576�ĵ�3λ��5
                bucket[count[j] - 1] = list[i]; //�����Ӧ��Ͱ�У�count[j]-1�ǵ�j��Ͱ���ұ߽����� 
                count[j]--; // ��ӦͰ��װ������������һ  
            }

            // ���ѷ���õ�Ͱ�������ٵ���������ʱ���Ƕ�Ӧ��ǰλ������ı�
            for (i = begin, j = 0; i <= end; i++, j++) {
                list[i] = bucket[j];
            }
            
        }

    }

    public int[] sort(int[] list) {
        radixSort(list, 0, list.length - 1, 3);
        return list;
    }

    // ��ӡ��������
    public void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 50, 123, 543, 187, 49, 30, 0, 2, 11, 100,15 };
        RadixSort radix = new RadixSort();
        System.out.print("����ǰ:\t\t");
        radix.printAll(array);
        radix.sort(array);
        System.out.print("�����:\t\t");
        radix.printAll(array);
    }

}