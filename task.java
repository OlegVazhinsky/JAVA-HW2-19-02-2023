// +Реализовать алгоритм сортировки слиянием

import java.util.Arrays;
import java.util.Random;

public class task{
    public static void main(String[] args){
        int[] array = getRandomArrayList(100, 10);
        showArray(array, "Исходный массив:");
        mergeSorting(array, 0, array.length - 1);
        showArray(array, "Отсортированный массив:");
    }

    // метод вывода массива с сообщнием
    public static void showArray(int[] array, String message){
        System.out.println(message);
        System.out.println(Arrays.toString(array));
    }

    // метод генерации случайного массива
    public static int[] getRandomArrayList(int arraySize, int maxRandomValue){
        int[] array = new int[arraySize];
        Random element = new Random();
        for (int i = 0; i < arraySize; i++){
            array[i] = element.nextInt(maxRandomValue);
        }
        return array;
    }

    // метод сортировки слиянием
    public static void mergeSorting(int[] array, int rightElement, int leftElement) {
        // если единичный элемент, выходим из рекурсии
        if (leftElement <= rightElement) return;

        // находим середину массива
        int middleElement = rightElement + (leftElement - rightElement) / 2;

        // сортируем обе части
        mergeSorting(array, rightElement, middleElement);
        mergeSorting(array, middleElement + 1, leftElement);

        // производим слияние двух частей
        // создаем буфферный массив и заполняем его
        int[] buffer = Arrays.copyOf(array, array.length);
        for (int k = rightElement; k <= leftElement; k++) buffer[k] = array[k];

        int i = rightElement;
        int j = middleElement + 1;

        // заполняем исходный массив из двух частей правой и левой
        for (int k = rightElement; k <= leftElement; k++) {
            if (i > middleElement) {
                array[k] = buffer[j];
                j++;
            } else if (j > leftElement) {
                array[k] = buffer[i];
                i++;
            } else if (buffer[j] < buffer[i]) {
                array[k] = buffer[j];
                j++;
            } else {
                array[k] = buffer[i];
                i++;
            }
        }
    }
}