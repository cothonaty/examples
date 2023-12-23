package pack;
import java.util.ArrayList;
import java.util.List;

/**
 * @author John L
 */
public class RemoveMultipleElements {
    public static void main(String[] args) {
        List<Integer> oldArray = new ArrayList<>();
        for(int i=0; i<199999999; i++){
            oldArray.add(i);
        }

        int startIndex = 333333;
        int endIndex = 333444;

        // USE ONE AND COMMENT ANOTHER METHOD
       deleteViaRemove(oldArray,startIndex,endIndex);
//        10508 ms
//        elements deleted: 112

//       deleteViaOptimization(oldArray,333333,333444);
//        1538 ms
//        elements deleted: 112
    }
    public static void deleteViaOptimization(List<Integer> oldArray,int startIndex, int endIndex){
        if (startIndex < 0 || endIndex >= oldArray.size() || startIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid range");
        }
        System.out.println("deleteViaOptimization");
        int firstSize = oldArray.size();
        int numToRemove = endIndex - startIndex + 1;
        ArrayList<Integer> newArray = new ArrayList<>(oldArray.size() - numToRemove);
        int i = 0;

        long time1 = System.currentTimeMillis();
        while (i < oldArray.size()) {
            if (i < startIndex || i > endIndex) {
                newArray.add(oldArray.get(i));

            } else {System.out.println("deleted: " + i);}
            i++;
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1+ " ms");
        oldArray = newArray;

        int newSize = oldArray.size();
        System.out.println("elements deleted: " + (firstSize-newSize));
    }
    public static void deleteViaRemove(List<Integer> oldArray, int startIndex, int endIndex){
        if (startIndex < 0 || endIndex >= oldArray.size() || startIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid range");
        }
        System.out.println("deleteViaRemove");
        int firstSize = oldArray.size();

        int numToRemove = endIndex - startIndex + 1;

        ArrayList<Integer> newArray = new ArrayList<>(oldArray.size() - numToRemove);

        long time1 = System.currentTimeMillis();

        for (int i=0; i<oldArray.size(); i++){
            if (!(i < startIndex || i > endIndex)){oldArray.remove(i);
                System.out.println("deleted: " + i);}
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1+ " ms");

        int newSize = oldArray.size();
        System.out.println("elements deleted: " + (firstSize-newSize));
    }
}
