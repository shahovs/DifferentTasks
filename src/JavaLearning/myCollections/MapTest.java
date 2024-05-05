package JavaLearning.myCollections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

    public static void main(String[] args) {

        // Создаю мапу
        Map<Integer, Double> myMap = new HashMap<>();
        myMap.put(1, 1.1);
        myMap.put(2, 3.14);
        myMap.put(3, 3.14);
        myMap.put(4, 4.4);
        System.out.println("myMap: " + myMap);
        System.out.println("******************************");

        // Получаю из мапы keySet, удаляю из keySet элемент - проверяю, что из мапы удалилась пара ключ-значение
        Set<Integer> integers = myMap.keySet();
        System.out.println("keySet: " + integers);
        integers.remove(1);
        System.out.println("keySet after remove 1: " + integers);
        System.out.println("myMap after remove 1 from keySet: " + myMap);
        System.out.println("******************************");

        // Получаю из мапы values, удаляю из values элемент (один из двух повторяющихся - не уточняю какой)
        // Проверяю, что из мапы удалилась пара ключ-значение (одна из двух пар с указанным мною value)
        Collection<Double> values = myMap.values();
        System.out.println("values " + values);
        values.remove(3.14);
        System.out.println("values  after remove 3.14" + values);
        System.out.println("myMap after remove 3.14: " + myMap);
        System.out.println("******************************");

        // Получаю из мапы множество пар Set<Map.Entry<...>>, очищаю множество clear(), проверяю, что мапа тоже пустая
        Set<Map.Entry<Integer, Double>> entries = myMap.entrySet();
        System.out.println("entries " + entries);
        entries.clear();
        System.out.println("entries after clear" + entries);
        System.out.println("myMap after clear: " + myMap);
        System.out.println("******************************");

        // Удаление пары из мапы не удаляет объекты,
        // но удаление из коллекций, полученных из мапы (три примера выше), удаляет из мапы пары
        Integer myInteger = 5;
        Double myDouble = 5.5;
        myMap.put(myInteger, myDouble);
        System.out.println("myInteger = " + myInteger + "; myDouble = " + myDouble + "; myMap = " + myMap);
        myMap.remove(5);
        System.out.println("After remove 5, myInteger = " + myInteger + "; myDouble = " + myDouble + "; myMap " + myMap);
        System.out.println("******************************");

        // Добавлять в keySet, values и Set<Map.Entry> ничего нельзя,
        // но удалять можно и это всегда удаляет из мапы пару целиком (key + value)

    }
}
