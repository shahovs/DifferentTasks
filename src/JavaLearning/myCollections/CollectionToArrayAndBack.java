package JavaLearning.myCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// Преобразование коллекций в массивы и массивы в колеекции
public class CollectionToArrayAndBack {
    public static void main(String[] args) {

        // Массив -> в коллекцию (используем метод List.of())
        String[] stringArray = {"ab", "cd"};
        var stringCollection = new ArrayList<String>(List.of(stringArray));
        var stringSet = new HashSet<String>(List.of(stringArray));
        System.out.println(stringCollection);
        System.out.println(stringSet);

        // Коллекция -> в массив
        List<String> stringList = new ArrayList<>(List.of("ef", "gh"));
        String[] array1 = stringList.toArray(new String[0]); // первый вариант
        String[] array2 = stringList.toArray(new String[stringList.size()]); // второй вариант
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}
