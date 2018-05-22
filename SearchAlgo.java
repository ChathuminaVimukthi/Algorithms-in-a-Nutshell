public class SearchAlgo {
    public static void main(String[] args){
        int[] list = {3,6,8,1,2,7,10,100,15,14,16,18,1000,10002,1002,1002,12345,123,12345,111,1238};
        linearSearch(list,1002);
        System.out.println("***************************");
        binarySearch(selectionSort(list),1002);//sorted array is passed to the method
        System.out.println("***************************");
        binarySearch(selectionSort(list),1002,0,19);//sorted array is passed to the method

    }

    /**
     * Selection Sort
     * @param list The Array to be sorted
     * @return returning the sorted Array
     * iterations - Big O(n^n)
     */
    public static int[] selectionSort(int[] list){
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

        }
        return list;
    }


    /**
     * Linear Search
     * @param list The Array with the value to search
     * @param key The key is the value to search
     */
    public static void linearSearch(int[] list, int key){
        long startTime = System.nanoTime();
        for(int i=0;i<list.length;i++){
            if(list[i]==key){

                System.out.println("Position of the value "+key+" is "+i);

                long endTime   = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println("Time cost : "+totalTime+" ms");

                return;
                //return statement will stop the iteration whenever the searched value is found
                //When you have duplicate elements of the searched value this will print only the first element in the array sequence
                //comment the return statement and check(it will print Position = 15. Because the iteration will not stop until the array is over)
            }
        }
    }


    /**
     * Binary Search ~ Recursive implementation
     * The Array has to be sorted inorder to do a Binary search effectively
     * @param list The Array with the value to search
     * @param key The key is the value to search
     * @param left Array starting index
     * @param right Array ending index
     * worst case - O(log2n)
     */
    public static boolean binarySearch(int[] list, int key, int left, int right){
        long startTime = System.nanoTime();

        if(left > right){
            return false;
        }

        int mid = left + ((right - left)/2); //remedy for overflowing integers

        if(list[mid]==key){
            System.out.println("Position of the value "+key+" is "+mid);

            long totalTime = System.nanoTime() - startTime;
            System.out.println("Time cost : "+totalTime+" ms");

            return true;
        }else if(key < list[mid]){
            return binarySearch(list, key, left,mid-1);
        }else{
            return binarySearch(list, key, mid+1, right);
        }
    }

    /**
     * Binary Search ~ Iterative implementation
     * The Array has to be sorted inorder to do a Binary search effectively
     * @param list The Array with the value to search
     * @param key The key is the value to search
     * worst case - O(log2n)
     */
    public static boolean binarySearch(int[] list, int key){
        long startTime = System.nanoTime();

        int left = 0;
        int right = list.length - 1;

        while(left <= right ){
            int mid = (left+right)/2;
            if(list[mid]==key){
                System.out.println("Position of the value "+key+" is "+mid);

                long endTime   = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println("Time cost : "+totalTime+" ms");

                return true;
            }else if(key < list[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }

}
