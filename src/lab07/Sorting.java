package lab07;

import java.util.ArrayList;

public class Sorting {
    
    private Sorting() {}
    
    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {
        
        boolean sorted = false;
        
        if(list.isEmpty() || list.size() == 1)
            sorted = true;
        
        while(!sorted) {
            E temp1, temp2;
            sorted = true;
            for(int i = 0; i < list.size()-1; i++) {
                temp1 = list.get(i);
                temp2 = list.get(i+1);
                if(temp1.compareTo(temp2) > 0) {
                    list.set(i, temp2);
                    list.set(i+1, temp1);
                    sorted = false;
                }
            }
        }        
    }
    
    public static void countingSort(int[] list) {
        int[] result = new int[list.length];
        int k = list[0];
        
        for(int x : list) {
            if(x > k)
                k = x;
        }
        int[] counts = new int[k+1];
        // each value in counts[] is already initiallized to 0
        
        for(int x = 0; x < list.length; x++)
            counts[list[x]]++;
        
        for(int x = 1; x <= k; x++) 
            counts[x] += counts[x-1];
        
        for(int x = list.length-1; x >= 0; x--) {
            int p = counts[list[x]]-1;
            result[p] = list[x];
            counts[list[x]]--;
        }
        System.arraycopy(result, 0, list, 0, list.length);
    }
    
    public static void countingSort(long[] list) {
        
        long[] result = new long[list.length];
        int k = (int)list[0];
        
        for(long x : list) {
            if(x > k)
                k = (int)x;
        }
        int[] counts = new int[k+1];
        // each value in counts[] is already initiallized to 0
        
        for(int x = 0; x < list.length; x++)
            counts[(int)list[x]]++;
        
        for(int x = 1; x <= k; x++) 
            counts[x] += counts[x-1];
        
        for(int x = list.length-1; x >= 0; x--) {
            int p = counts[(int)list[x]]-1;
            result[p] = list[x];
            counts[(int)list[x]]--;
        }
        System.arraycopy(result, 0, list, 0, list.length);
    }

    public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) {
        
        E temp1;
        int j;
        for(int i = 0; i < list.size(); i++) {
            temp1 = list.get(i);
            j = i;
            while(j > 0 && temp1.compareTo(list.get(j-1)) < 0) {
                list.set(j, list.get(j-1));
                j--;
            }
            list.set(j, temp1);
        }
    }
    
    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
        
        if(list.size() > 1) {            
            int mid = (list.size()-1) / 2;            
            ArrayList<E> left = new ArrayList<>();
            ArrayList<E> right = new ArrayList<>();
            
            for(int i = 0; i <= mid; i++) 
                left.add(list.get(i));
            mergeSort(left);
            
            for(int j = mid+1; j < list.size(); j++) 
                right.add(list.get(j));
            mergeSort(right);
            
            merge(left, right, list);            
        }
    }
    
    private static <E extends Comparable<E>> void merge(ArrayList<E> left, ArrayList<E> right, ArrayList<E> list) {
        
        int i, j, k;
        i = 0;  j = 0;  k = 0;
        
        while(i < left.size() && j < right.size()) {
            E tempLeft = left.get(i);
            E tempRight = right.get(j);
            if(tempLeft.compareTo(tempRight) < 0) {
                list.set(k, tempLeft);
                i++;
            }
            else {
                list.set(k, tempRight);
                j++;
            }
            k++;
        }
        
        while(i < left.size()) {
            list.set(k, left.get(i));
            i++;
            k++;
        }
        
        while(j < right.size()) {
            list.set(k, right.get(j));
            j++;
            k++;
        }
    }
    
    public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
        quickSort(list, 0, list.size()-1);
    }
    
    private static <E extends Comparable<E>> void quickSort(ArrayList<E> list,int low, int high) {
        if(low < high) {
            int p = partitian(list, low, high);
            quickSort(list, low, p-1);
            quickSort(list, p+1, high);
        }
    }
    
    private static <E extends Comparable<E>> int partitian(ArrayList<E> list,int low, int high) {
        E pivot = list.get(high);
        int i = low - 1;
        
        for(int j = low; j < high; j++) {
            E temp1 = list.get(j);
            if(temp1.compareTo(pivot) < 0 || temp1.equals(pivot)) {
                i++;
                list.set(j, list.get(i));
                list.set(i, temp1);
            }
        }
        
        E temp2 = list.get(i+1);
        list.set(i+1, pivot);
        list.set(high, temp2);
        return i+1;
    }
    
    public static void radixSort(int[] list) {
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for(int x = 0; x < 10; x++) 
            buckets[x] = new ArrayList<>();
        
        int max = list[0];
        for(int x : list) {
            if(x > max)
                max = x;
        }
        int digits = (int) Math.ceil(Math.log10(max));
        
        int key;
        for(int i = 0; i < digits; i++) {
            
            for(int j = 0; j < list.length; j++) {
                key = (int) ( list[j] / (Math.pow(10.0, (double)i) ) % 10);
                buckets[key].add(list[j]);
            }

            int k = 0;
            for(int j = 0; j < buckets.length; j++) {
                for(int elem : buckets[j]) {
                    list[k] = elem;
                    k++;
                }
                buckets[j].clear();;
            }
        }
    }
    
    public static void radixSort(long[] list) {
                
        ArrayList<Long>[] buckets = new ArrayList[10];
        for(int x = 0; x < 10; x++) 
            buckets[x] = new ArrayList<>();
        
        long max = list[0];
        for(long x : list) {
            if(x > max)
                max = x;
        }
        int digits = (int) Math.ceil(Math.log10(max));
        
        int key;
        for(int i = 0; i < digits; i++) {
            
            for(int j = 0; j < list.length; j++) {
                key = (int) ( list[j] / (Math.pow(10.0, (double)i) ) % 10);
                buckets[key].add(list[j]);
            }
            
            int k = 0;
            for(int j = 0; j < buckets.length; j++) {
                for(long elem : buckets[j]) {
                    list[k] = elem;
                    k++;
                }
                buckets[j].clear();;
            }
        }
    }
        
    public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
        
        int min;
        for(int i = 0; i < list.size(); i++) {
            min = i;
            for(int j = i+1; j < list.size(); j++) {
                if(list.get(j).compareTo(list.get(min)) < 0)
                    min = j;
            }
            E temp1 = list.get(i);
            E temp2 = list.get(min);
            list.set(i, temp2);
            list.set(min, temp1);
        }
    }
    
}
