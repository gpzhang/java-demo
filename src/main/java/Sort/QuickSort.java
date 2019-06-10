package Sort;
//��������ĵݹ�ʵ����ʽ
public class QuickSort {
	
	public  byte[] quick(byte[] by) {
        if(by.length>0){
            quickSort(by,0,by.length-1);
        }
        return by;
    }

    private  void quickSort(byte[] by, int low, int high) {
        if(low<high){ //�����������жϵݹ���޷��˳����¶�ջ����쳣
            int middle = getMiddle(by,low,high);
            quickSort(by, 0, middle-1);//С�ڻ���������
            quickSort(by, middle+1, high);//���ڻ���������
        }
    }

    private  int getMiddle(byte[] by, int low, int high) {
        int temp = by[low];//��׼Ԫ��
        while(low<high){
            //�ҵ��Ȼ�׼Ԫ��С��Ԫ��λ��
            while(low<high && by[high]>=temp){
                high--;//����������
            }
            by[low] = by[high];//����ҵ����Ͱ��ҵ�С�ڻ�����ֵ�����������ڵ�λ�ã� 
            //�ҵ��Ȼ�׼Ԫ�ش��Ԫ��λ��
            while(low<high && by[low]<=temp){
                low++;//����������
            }
            by[high] = by[low];//����ҵ����ͰѴ��ڻ�����ֵ����
        }
        by[low] = (byte) temp;//low����λ�ã�������С��low��λ���ϵ����ݶ�С��temp,
        //����low��λ���ϵ����ݶ�����temp,�����һ�εݹ��жϣ�ֻ���low�������ߵ������������ͬ˼·���жϼ���
        return low;
    }
}
