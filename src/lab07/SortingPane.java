package lab07;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;

public class SortingPane extends BorderPane {
    
    private LineChart<Number, Number> graph;
    private NumberAxis x, y;
    protected int times = 0;
    
    private int valRange = 1000; // range from 0 - 999 since the truncated value from Math.random will be 999
    private int[] list_50000;
    private int[] list_100000;
    private int[] list_150000;
    private int[] list_200000;
    private int[] list_250000;
    private int[] list_300000;
        
    private XYChart.Series bubble = new XYChart.Series();
    private XYChart.Series counting = new XYChart.Series();
    private XYChart.Series insertion = new XYChart.Series();
    private XYChart.Series merge = new XYChart.Series();
    private XYChart.Series quick = new XYChart.Series();
    private XYChart.Series radix = new XYChart.Series();
    private XYChart.Series selection = new XYChart.Series();
    
    public SortingPane() {
        list_50000 = new int[500];
        list_100000 = new int[1000];
        list_150000 = new int[1500];
        list_200000 = new int[2000];
        list_250000 = new int[2500];
        list_300000 = new int[3000];
        
        bubble.setName("Bubble");
        counting.setName("Counting");
        insertion.setName("Insertion");
        merge.setName("Merge");
        quick.setName("Quick");
        radix.setName("Radix");
        selection.setName("Selection");
        
        generateAllLists();
        x = new NumberAxis(); 
        y = new NumberAxis();
        graph = new LineChart<>(x,y);
        this.setCenter(graph);
    }
    
    public void run() {
        runMerge();
        runQuick();
        runInsertion();
        runSelection();
        runRadix();
        runCounting();
        runBubble();
        times++;
    }
    
    public void runAgain() {
        bubble.getData().clear();
        counting.getData().clear();
        insertion.getData().clear();
        merge.getData().clear();
        quick.getData().clear();
        radix.getData().clear();
        selection.getData().clear();
        this.getChildren().remove(graph);
        graph.getData().clear();
        run();
        graph.getData().addAll(bubble, counting, insertion, merge, quick, radix, selection);
        
        this.setCenter(graph);
    }
    
    public void updateLine(XYChart.Series line,int listSize, double time) {
        line.getData().add(new XYChart.Data(listSize, time));
        graph.getData().remove(line);
        graph.getData().add(line);
    }
    
    private void generateAllLists() {
        generateOriginalList(list_50000);
        generateOriginalList(list_100000);
        generateOriginalList(list_150000);
        generateOriginalList(list_200000);
        generateOriginalList(list_250000);
        generateOriginalList(list_300000);
    }
    
    private void generateOriginalList(int[] list) {
        int[] originalList = new int[list.length];
        
        for(int i = 0; i < list.length; i++) 
            originalList[i] = (int) ((Math.random() * valRange));
        
        System.arraycopy(originalList, 0, list, 0, list.length);
    }
    
    private ArrayList<Integer> getCopy(int[] list) {
        ArrayList<Integer> other = new ArrayList<>(list.length);
        for(int x : list) 
            other.add(x);        
        return other;
    }
    
    private int[] getCopyAsArray(int[] list) {
        int[] other = new int[list.length];
        System.arraycopy(list, 0, other, 0, list.length);
        return other;
    }
    
    private void runBubble() {
        ArrayList<Integer> list_50 = getCopy(list_50000);
        runBubbleSort(list_50);
        ArrayList<Integer> list_100 = getCopy(list_100000);
        runBubbleSort(list_100);
        ArrayList<Integer> list_150 = getCopy(list_150000);
        runBubbleSort(list_150);
        ArrayList<Integer> list_200 = getCopy(list_200000);
        runBubbleSort(list_200);
        ArrayList<Integer> list_250 = getCopy(list_250000);
        runBubbleSort(list_250);
        ArrayList<Integer> list_300 = getCopy(list_300000);
        runBubbleSort(list_300);
    }
    
    private void runCounting() {
        int[] list_50 = getCopyAsArray(list_50000);
        runCountingSort(list_50);
        int[] list_100 = getCopyAsArray(list_100000);
        runCountingSort(list_100);
        int[] list_150 = getCopyAsArray(list_150000);
        runCountingSort(list_150);
        int[] list_200 = getCopyAsArray(list_200000);
        runCountingSort(list_200);
        int[] list_250 = getCopyAsArray(list_250000);
        runCountingSort(list_250);
        int[] list_300 = getCopyAsArray(list_300000);
        runCountingSort(list_300);
    }
    
    private void runInsertion() {
        ArrayList<Integer> list_50 = getCopy(list_50000);
        runInsertionSort(list_50);
        ArrayList<Integer> list_100 = getCopy(list_100000);
        runInsertionSort(list_100);
        ArrayList<Integer> list_150 = getCopy(list_150000);
        runInsertionSort(list_150);
        ArrayList<Integer> list_200 = getCopy(list_200000);
        runInsertionSort(list_200);
        ArrayList<Integer> list_250 = getCopy(list_250000);
        runInsertionSort(list_250);
        ArrayList<Integer> list_300 = getCopy(list_300000);
        runInsertionSort(list_300);
    }
    
    private void runMerge() {
        ArrayList<Integer> list_50 = getCopy(list_50000);
        runMergeSort(list_50);
        ArrayList<Integer> list_100 = getCopy(list_100000);
        runMergeSort(list_100);
        ArrayList<Integer> list_150 = getCopy(list_150000);
        runMergeSort(list_150);
        ArrayList<Integer> list_200 = getCopy(list_200000);
        runMergeSort(list_200);
        ArrayList<Integer> list_250 = getCopy(list_250000);
        runMergeSort(list_250);
        ArrayList<Integer> list_300 = getCopy(list_300000);
        runMergeSort(list_300);
    }
    
    private void runQuick() {
        ArrayList<Integer> list_50 = getCopy(list_50000);
        runQuickSort(list_50);
        ArrayList<Integer> list_100 = getCopy(list_100000);
        runQuickSort(list_100);
        ArrayList<Integer> list_150 = getCopy(list_150000);
        runQuickSort(list_150);
        ArrayList<Integer> list_200 = getCopy(list_200000);
        runQuickSort(list_200);
        ArrayList<Integer> list_250 = getCopy(list_250000);
        runQuickSort(list_250);
        ArrayList<Integer> list_300 = getCopy(list_300000);
        runQuickSort(list_300);
    }
    
    private void runRadix() {
        int[] list_50 = getCopyAsArray(list_50000);
        runRadixSort(list_50);
        int[] list_100 = getCopyAsArray(list_100000);
        runRadixSort(list_100);
        int[] list_150 = getCopyAsArray(list_150000);
        runRadixSort(list_150);
        int[] list_200 = getCopyAsArray(list_200000);
        runRadixSort(list_200);
        int[] list_250 = getCopyAsArray(list_250000);
        runRadixSort(list_250);
        int[] list_300 = getCopyAsArray(list_300000);
        runRadixSort(list_300);
    }
    
    private void runSelection() {
        ArrayList<Integer> list_50 = getCopy(list_50000);
        runSelectionSort(list_50);
        ArrayList<Integer> list_100 = getCopy(list_100000);
        runSelectionSort(list_100);
        ArrayList<Integer> list_150 = getCopy(list_150000);
        runSelectionSort(list_150);
        ArrayList<Integer> list_200 = getCopy(list_200000);
        runSelectionSort(list_200);
        ArrayList<Integer> list_250 = getCopy(list_250000);
        runSelectionSort(list_250);
        ArrayList<Integer> list_300 = getCopy(list_300000);
        runSelectionSort(list_300);
    }
    
    
    private void runBubbleSort(ArrayList<Integer> list) {
        Instant start = Instant.now();        
        Sorting.bubbleSort(list);       // < - - - - - - Sorting occurs 
        Instant end = Instant.now();
        double sec = Duration.between(start, end).getNano() / 1000000000.0;
        updateLine(bubble, list.size(), sec);
    }
    
    private void runCountingSort(int[] list) {
        Instant start = Instant.now();        
        Sorting.countingSort(list);       // < - - - - - - Sorting occurs 
        Instant end = Instant.now();
        double sec = Duration.between(start, end).getNano() / 1000000000.0;
        updateLine(counting, list.length, sec);
    }
    
    private void runInsertionSort(ArrayList<Integer> list) {
        Instant start = Instant.now();        
        Sorting.insertionSort(list);       // < - - - - - - Sorting occurs 
        Instant end = Instant.now();
        double sec = Duration.between(start, end).getNano() / 1000000000.0;
        updateLine(insertion, list.size(), sec);
    }
    
    private void runMergeSort(ArrayList<Integer> list) {
        Instant start = Instant.now();        
        Sorting.mergeSort(list);       // < - - - - - - Sorting occurs 
        Instant end = Instant.now();
        double sec = Duration.between(start, end).getNano() / 1000000000.0;
        updateLine(merge, list.size(), sec);
    }
    
    private void runQuickSort(ArrayList<Integer> list) {
        Instant start = Instant.now();        
        Sorting.quickSort(list);       // < - - - - - - Sorting occurs 
        Instant end = Instant.now();
        double sec = Duration.between(start, end).getNano() / 1000000000.0;
        updateLine(quick, list.size(), sec);
    }
    
    private void runRadixSort(int[] list) {
        Instant start = Instant.now();        
        Sorting.radixSort(list);       // < - - - - - - Sorting occurs 
        Instant end = Instant.now();
        double sec = Duration.between(start, end).getNano() / 1000000000.0;
        updateLine(radix, list.length, sec);
    }
    
    private void runSelectionSort(ArrayList<Integer> list) {
        Instant start = Instant.now();        
        Sorting.selectionSort(list);       // < - - - - - - Sorting occurs 
        Instant end = Instant.now();
        double sec = Duration.between(start, end).getNano() / 1000000000.0;
        updateLine(selection, list.size(), sec);
    }
}
