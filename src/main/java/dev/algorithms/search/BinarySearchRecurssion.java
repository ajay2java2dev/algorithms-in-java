package dev.algorithms.search;

public class BinarySearchRecurssion {

    public int doSearchAndReturnIndex(int [] arr, int searchKey, int left, int right) {
        int searchIndex = -1;
        if (arr != null && arr.length > 0) {
            int middleIndex = (left + right) / 2; //base value
            if (arr[middleIndex] == searchKey) {
                return middleIndex;
            }
            if (arr[middleIndex]>searchKey) {
                doSearchAndReturnIndex(arr,searchKey,left,middleIndex-1);
            }
            if (arr[middleIndex]<searchKey) {
                doSearchAndReturnIndex(arr,searchKey,middleIndex+1,right);
            }

        }
        return searchIndex;
    }

    public static void main(String[] args) {
        BinarySearchIteration bsi = new BinarySearchIteration();
        int [] arr = {1,2,3,10,15,20};
        int searchKey = 21;
        long startTime = System.nanoTime();
        int indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println("time taken:" + (System.nanoTime()-startTime));
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = 20;
        startTime = System.nanoTime();
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println("time taken:" + (System.nanoTime()-startTime));
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = -1;
        startTime = System.nanoTime();
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println("time taken:" + (System.nanoTime()-startTime));
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = -10000;
        startTime = System.nanoTime();
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println("time taken:" + (System.nanoTime()-startTime));
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = 100000;
        startTime = System.nanoTime();
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println("time taken:" + (System.nanoTime()-startTime));
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = 15;
        startTime = System.nanoTime();
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println("time taken:" + (System.nanoTime()-startTime));
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = 1;
        startTime = System.nanoTime();
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println("time taken:" + (System.nanoTime()-startTime));
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = 2;
        startTime = System.nanoTime();
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println("time taken:" + (System.nanoTime()-startTime));
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = 222;
        startTime = System.nanoTime();
        indexPos = bsi.doSearchAndReturnIndex(null,0,0,arr.length-1);
        System.out.println("time taken:" + (System.nanoTime()-startTime));
        System.out.println(indexPos!= -2 ? "Found : at "+ indexPos : "Invalid Input");
    }
}
