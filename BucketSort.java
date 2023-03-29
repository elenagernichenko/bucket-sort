import java.io.*;
import java.util.ArrayList;

public class BucketSort {

    public static void main(String[] args) throws IOException {

        String filename = "arrays100.txt"; // имя файла с входными данными
        ArrayList<int[]> arrays = readInput(filename); // считываем массивы из файла

        for (int i = 0; i < arrays.size(); i++) {
            int[] arr = arrays.get(i);
            long startTime = System.nanoTime(); // время начала сортировки
            int iterations = bucketSort(arr); // сортируем массив и получаем количество итераций
            long endTime = System.nanoTime(); // время окончания сортировки
            long timeElapsed = endTime - startTime; // время выполнения сортировки

            // выводим отсортированный массив, время выполнения сортировки и количество итераций
            int size = arr.length; // определение размера массива

            System.out.println("Array #" + (i + 1) + " (size: " + size + "): "); // вывод размера и отсортированного массива
            System.out.println("Time taken: " + timeElapsed + " nanoseconds");
            System.out.println("Iterations: " + iterations + "\n");

        }
    }
    public static int bucketSort(int[] array) {
        // Записываем первый элемент массива как максимальное значение
        int maximum_value = array[0];
        // Ищем максимальный элемент массива, используя цикл
        for (int a = 1; a < array.length; a++) {
            if (array[a] > maximum_value) {
                maximum_value = array[a]; // Меняем максимальное значение, если находим больший элемент
            }
        }

        int[] newbucket = new int[maximum_value + 1];// Создаем новое ведро с максимальным значением плюс одно
        int[] sorted_array = new int[array.length];  // Создаем массив для отсортированных данных
        int iterations = 0;

        for (int a = 0; a < array.length; a++) { // Проходимся по массиву и увеличиваем значение в ведре, где равно значение элемента
            newbucket[array[a]]++;
        }

        int position = 0; // Определяем начальную позицию
        for (int b = 0; b < newbucket.length; b++) { // Проходимся по всем элементам в ведре
            for (int c = 0; c < newbucket[b]; c++) {  // Проходимся по каждому элементу с текущим значением и присваеваем его отсортированному массиву
                sorted_array[position++] = b;
                iterations++;
            }
            iterations++;
        }

        return iterations; // Возвращаем количество итераций для сортировки
    }


    // Метод для чтения массивов из файла
    public static ArrayList<int[]> readInput(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<int[]> arrays = new ArrayList<int[]>();

        String line = reader.readLine();
        while (line != null) {
            int size = Integer.parseInt(line);
            int[] arr = new int[size];
            line = reader.readLine();
            String[] values = line.split(" ");
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(values[i]);
            }
            arrays.add(arr);
            line = reader.readLine();
        }

        reader.close();
        return arrays;
    }
}
