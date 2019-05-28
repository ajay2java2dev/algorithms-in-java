package dev.algorithms.search;

public class BinarySearchIteration {

    public int doSearchAndReturnIndex(int [] arr, int searchKey, int left, int right) {
        long startTime = System.nanoTime();
        int searchIndex = -1;

        if (arr!= null && arr.length>0) {
            while (left <= right) {

                int middleIndex = (left + right) / 2;
                if (middleIndex > arr.length - 1) {
                    break;
                }

                if (arr[middleIndex] == searchKey) {
                    searchIndex = middleIndex;
                    break;
                } else {
                    if (arr[middleIndex] < searchKey) {
                        left = middleIndex + 1;
                    } else if (arr[middleIndex] > searchKey) {
                        right = middleIndex - 1;
                    }
                }
            }
        } else {
            searchIndex  = -2;
        }
        System.out.println("Time taken : " + (System.nanoTime() - startTime));
        return searchIndex;
    }

    public static void main(String[] args) {
        BinarySearchIteration bsi = new BinarySearchIteration();
        int [] arr = {1,2,3,10,15,20};
        int searchKey = 21;
        int indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = 20;
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = -1;
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = -10000;
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = 100000;
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = 15;
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = 1;
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = 2;
        indexPos = bsi.doSearchAndReturnIndex(arr,searchKey,0,arr.length-1);
        System.out.println(indexPos!= -1 ? "Found : at "+ indexPos : "Not Found");

        searchKey = 222;
        indexPos = bsi.doSearchAndReturnIndex(null,0,0,arr.length-1);
        System.out.println(indexPos!= -2 ? "Found : at "+ indexPos : "Invalid Input");
    }
}
