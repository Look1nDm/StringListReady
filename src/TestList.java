import exceptions.IndexNotFoundException;
import exceptions.ItemIsNullException;
import exceptions.TestListOfBoundException;

import java.util.Arrays;
import java.util.Objects;

public class TestList implements StringList {
    private final String[] list;
    private int size;

    public TestList() {
        list = new String[6];
    }

    public TestList(int s) {
        list = new String[s];
    }

    private void validString(String item) {
        if (item == null) {
            throw new ItemIsNullException("Переданная строка ничего не содержит!");
        }
    }

    private void validIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexNotFoundException("Не найти такого индекса, Повелитель!");
        }
    }

    private void validSize() {
        if (size == list.length) {
            throw new TestListOfBoundException("Список заполнен, мой господин!");
        }
    }

    @Override
    public String add(String item) {
        validSize();
        validString(item);
        return list[size++] = item;
    }

    @Override
    public String add(int index, String item) {
        validSize();
        validString(item);
        validIndex(index);
        if (index == size) {
            return list[size++] = item;
        }
        System.arraycopy(list, index, list, index+1, size - index);
        return list[index] = item;
    }

    @Override
    public String set(int index, String item) {
        validIndex(index);
        validString(item);
        return list[index] = item;
    }

    @Override
    public String remove(String item) {
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

    @Override
    public String remove(int index) {
        validIndex(index);
        if(index==-1){
            throw new IndexNotFoundException("Нет такого элемента, повелитель!");
        }
        String s = list[index];
        if(index == size){
            list[size--]=null;
            return s;
        }
        System.arraycopy(list,index+1,list,index,size-index);
        return s;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) > -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validIndex(index);
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (this == otherList) return true;
        if (otherList == null || getClass() != otherList.getClass()) return false;
        TestList testList = (TestList) otherList;
        return size == testList.size && Arrays.equals(list, testList.list);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(list, size);
    }

    @Override
    public String toString() {
        return "TestList{" +
                "list=" + Arrays.toString(list) +
                ", size=" + size +
                '}';
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(list);
        return result;
    }
}
