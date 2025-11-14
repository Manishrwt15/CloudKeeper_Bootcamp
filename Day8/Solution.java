import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Solution {

    // Find first non-repeating character
    public static char nonRepChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return '0';
    }

    // Return index of target sum
    public static int[] targetSum(int[] arr, int target) {
        if (arr == null) return new int[]{-1, -1};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    // Merge to shorted Array List
    public static ArrayList<Integer> mergeArrayList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            res.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            res.add(list2.get(j));
            j++;
        }

        return res;
    }


    // Two threads
    static class TablePrinter {
        private boolean printTwo = true;

        synchronized void printTwo() {
            for (int i = 1; i <= 10; i++) {
                while (!printTwo) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
                System.out.println("2" + "*" + i + "=" + 2 * i);
                printTwo = false;
                notifyAll();
            }
        }

        synchronized void printFour() {
            for (int i = 1; i <= 10; i++) {
                while (printTwo) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
                System.out.println("4"+ "*" + i + "=" + 4 * i);
                printTwo = true;
                notifyAll();
            }
        }
    }




    public static void main(String[] args){
        System.out.println(nonRepChar("abbcddddsssdddeedcf"));
        int[] arr = {2, 3, 46, 5, 4, 3, 6, 8, 7, 11, 15};
        int target = 9;
        int[] res = targetSum(arr, target);
        for(int num : res){
            System.out.print(num + " ");
        }

        System.out.println();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 3, 5));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(2, 4, 6, 8));
        System.out.println(mergeArrayList(a, b));


        TablePrinter tp = new TablePrinter();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(tp::printTwo);
        executor.submit(tp::printFour);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}