import java.util.ArrayList;
import java.util.Random;

public class task{
    // +Реализовать алгоритм сортировки слиянием
    public static void main(String[] args){
        int[] array = getRandomArrayList(10, 100);
    }

    public static int[] getRandomArrayList(int arraySize, int maxRandomValue){
        int[] array = new int[arraySize];
        Random element = new Random();
        for (int i = 0; i < arraySize; i++){
            array[i] = element.nextInt(maxRandomValue);
            //System.out.println(array[i]);
        }
        return array;
    }
}