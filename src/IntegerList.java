import exceptions.IndexNotFoundException;
import exceptions.ItemIsNullException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class IntegerList {
    private Integer[] list;
    private static int size;

    public IntegerList() {
        this.list = new Integer[]{};
    }
//    public IntegerList() {
//        this.list = generateRandomArray(100000);
//    }

    public IntegerList(int s) {
        list = new Integer[s];
    }

    public Integer[] generateRandomArray(int bound) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < bound; i++) {
            Integer in = random.nextInt(100000)+100000;
            list.add(in);
            System.out.println(list.size());
        }
        return list.toArray(new Integer[0]);
    }
    private void validString(Integer item) {
        if (item == null) {
            throw new ItemIsNullException("Переданная строка ничего не содержит!");
        }
    }

    private void validIndex(Integer index) {
        if (index > size || index < 0) {
            throw new IndexNotFoundException("Не найти такого индекса, Повелитель!");
        }
    }

//    private void validSize() {
//        if (size == list.length) {
//          throw new TestListOfBoundException("Список заполнен, мой господин!");
//        }
//    }
    // 1 2 3 4 5 6 7 8 9
    public void grow(){
        int length = list.length*2- list.length/2;
        Integer[] array = new Integer[length];
        System.arraycopy(list,0,array,0,array.length);
        list = array;
    }
    public void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }
    private void swapElements(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public Integer add(Integer item) {
        //validSize();
        if (size == list.length){
            grow();
        }
        validString(item);
        return list[size++] = item;
    }

    public Integer add(int index, Integer item) {
       //validSize();
        if (size == list.length){
            grow();
        }
        validString(item);
        validIndex(index);
        if (index == size) {
            return list[size++] = item;
        }
        System.arraycopy(list, index, list, index+1, size - index);
        return list[index] = item;
    }

    public Integer set(int index, Integer item) {
        validIndex(index);
        validString(item);
        return list[index] = item;
    }

    public Integer remove(Integer item) {
        int i = indexOf(item);
        validString(item);
        if(i==-1){
            throw new IndexNotFoundException("Нет такого элемента, повелитель!");
        }
        if(i==size){
            list[size--] = null;
            return item;
        }
        System.arraycopy(list,i+1,list,i,size-i);
        return item;
    }

    public Integer remove(int index) {
        validIndex(index);
        if(index==-1){
            throw new IndexNotFoundException("Нет такого элемента, повелитель!");
        }
        Integer s = list[index];
        if(index == size){
            list[size--]=null;
            return s;
        }
        System.arraycopy(list,index+1,list,index,size-index);
        return s;
    }
    public boolean contains(Integer item) {
        validIndex(item);

        Integer [] array = toArray();
        quickSort(list,list[0], list.length);
        int min = 0;
        int max = list.length - 1;
        while (min <= max){
            int mid = min+max/2;
            if (item.equals(array[mid])){
                return true;
            }
            if (item < array.length/2){
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        } return false;
    }


    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public Integer get(int index) {
        validIndex(index);
        return list[index];
    }

    public boolean equals(IntegerList otherList) {
        if (this == otherList) return true;
        if (otherList == null || getClass() != otherList.getClass()) return false;
        IntegerList testList = otherList;
        return size == testList.size && Arrays.equals(list, testList.list);
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public void clear() {
        size = 0;
    }


    public Integer[] toArray() {
        return Arrays.copyOf(list, size);
    }

}
