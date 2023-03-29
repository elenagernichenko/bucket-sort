import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {

    public static void main(String[] args) {
        int numArrays = 100;
        String fileName = "arrays100.txt"; // имя файла, в который будем записывать массивы

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Random random = new Random();
            for (int i = 1; i <= numArrays; i++) {
                int size = 100 * i;
                int[] array = new int[size];
                for (int j = 0; j < size; j++) {
                    array[j] = random.nextInt(10000); // заполняем массив случайными значениями
                }
                writer.write(size + "\n"); // записываем размер массива в файл
                for (int j = 0; j < size; j++) {
                    writer.write(array[j] + " "); // записываем значения массива в файл через пробел
                }
                writer.write("\n"); // переходим на новую строку после записи каждого массива
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
