package algorithm.insertSort;

//����λ�ô���ʼ������
//insert sort
public class InsertSort {


    public static void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int value = data[i];
            int[] tmp = new int[2];
            int change = i;
            for (int j = 0; j < i; j++) {
                if (value >= data[j]) {
                    continue;
                }
                int index = j % 2;
                if (change == i) {
                    tmp[Math.abs(index - 1)] = data[j];
                    change = j;
                }
                tmp[index] = data[j + 1];
                if (0 == index) {
                    data[j + 1] = tmp[j + 1];
                } else {
                    data[j + 1] = tmp[j - 1];
                }
                data[change] = value;

            }
        }
    }
}