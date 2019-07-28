package algorithm.tree.t25;


public class Solution25 {
	public int MoreThanHalfNum_Solution(int[] array) {
		if(array==null){
			return 0;
		}
		if(array.length==1){
			return array[0];
		}
		array=quick(array);
		int zhi=0;
		int length=array.length;
		for(int i=0;i<length/2;i++){
			if(array[i]==array[length/2+i]){//排完序的数组,如果从第一个元素开始查询，和数组后半部分的数值相等，说明，该元素超过一半
				zhi=array[i];
				break;
			}
		}
		return zhi;

	}
	
	public  int[] quick(int[] by) {
        if(by.length>0){
            quickSort(by,0,by.length-1);
        }
        return by;
    }

    private  void quickSort(int[] by, int low, int high) {
        if(low<high){ //如果不加这个判断递归会无法退出导致堆栈溢出异常
            int middle = getMiddle(by,low,high);
            quickSort(by, 0, middle-1);//小于基数的排序
            quickSort(by, middle+1, high);//大于基数的排序
        }
    }

    private  int getMiddle(int[] by, int low, int high) {
        int temp = by[low];//基准元素
        while(low<high){
            //找到比基准元素小的元素位置
            while(low<high && by[high]>=temp){
                high--;//从右往左找
            }
            by[low] = by[high];//如果找到，就把找到小于基数的值赋给基数所在的位置？ 
            //找到比基准元素大的元素位置
            while(low<high && by[low]<=temp){
                low++;//从左往右找
            }
            by[high] = by[low];//如果找到，就把大于基数的值赋给
        }
        by[low] = temp;//low最后的位置，决定了小于low的位置上的数据都小于temp,
        //大于low的位置上的数据都大于temp,因此下一次递归判断，只需对low左右两边的子数组进行相同思路的判断即可
        return low;
    }
	public static void main(String[] args) {
		
	}
}
