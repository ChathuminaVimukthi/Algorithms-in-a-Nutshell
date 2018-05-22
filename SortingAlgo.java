public class SortingAlgo {

    public static void main(String[] args){
        int[] list = {3,6,8,1,2,7,10,100,15,14,16,18,1000,10002,1002,12345,123,12345,111,1238};
        selectionSort(list);
        System.out.println("***************************");
        insertionSort(list);
        System.out.println("***************************");
        mergeSort(list,0,19);
    }

    /**
     * Selection Sort
     * @param list The Array to be sorted
     * @return returning the sorted Array
     * iterations - Big O(n^n)
     */
    public static int[] selectionSort(int[] list){
        long startTime = System.nanoTime();
        int i,j,minValue,minIndex,temp=0;
        for(i=0;i<list.length;i++){
            minValue = list[i];
            minIndex = i;

            for(j=i;j<list.length;j++){
                if(list[j]<minValue){
                    minValue = list[j];
                    minIndex = j;
                }
            }

            if(minValue<list[i]){
                temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }

            System.out.print(minValue+"-");
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("");
        System.out.println("Time cost : "+totalTime+" ms");
        return list;
    }

    /**
     * Insertion Sort
     * @param list The Array to be sorted
     * @return returning the sorted Array
     * iterations - Big O(n^n)
     */
    public static int[] insertionSort(int[] list){
        long startTime = System.currentTimeMillis();
        int i,j,key,temp =0;
        for(i = 1;i<list.length;i++){
            key = list[i];
            j = i - 1;

            while(j >= 0 && key < list[j]){
                temp = list[j];
                list[j] = list[j+1];
                list[j+1] = temp;
                j--;
            }

            System.out.print(key+"-");
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("");
        System.out.println("Time cost : "+totalTime+" ms");

        return list;
    }


    /**
     * Merge Sort
     * @param list list The Array to be sorted
     * @param lowIndex starting index of the Array (= 0)
     * @param highIndex ending index of the Array
     * iterations - O(n log n)
     * Recursive method (Calling itself)
     */
    public static void mergeSort(int[] list, int lowIndex, int highIndex){
        if (lowIndex == highIndex)
            return;
        else {
            int midIndex = (lowIndex + highIndex) / 2;
            mergeSort(list, lowIndex, midIndex);
            mergeSort(list, midIndex + 1, highIndex);
            merge(list, lowIndex, midIndex, highIndex);
        }
    }

    public static void merge(int[] list, int lowIndex, int midIndex, int highIndex) {

        long startTime = System.currentTimeMillis();

        int[] L = new int[midIndex - lowIndex + 2];

        for (int i = lowIndex; i <= midIndex; i++) {
            L[i - lowIndex] = list[i];
        }
        L[midIndex - lowIndex + 1] = Integer.MAX_VALUE;
        int[] R = new int[highIndex - midIndex + 1];

        for (int i = midIndex + 1; i <= highIndex; i++) {
            R[i - midIndex - 1] = list[i];
        }
        R[highIndex - midIndex] = Integer.MAX_VALUE;
        int i = 0, j = 0;

        for (int k = lowIndex; k <= highIndex; k++) {
            if (L[i] <= R[j]) {
                list[k] = L[i];
                i++;
                System.out.print(list[k]+"-");
            }
            else {
                list[k] = R[j];
                j++;
                System.out.print(list[k]+"-");
            }
        }

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("");
        System.out.println("Time cost : "+totalTime+" ms");

    }

}
