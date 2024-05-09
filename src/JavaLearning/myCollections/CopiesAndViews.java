package JavaLearning.myCollections;

import java.util.*;

// Представления и оболочки - Copies And Views
// Методы of, ofEntries, singleton, emptyList, nCopies, asList, subList,
// unmodifiable.., checked.., synchronized..
public class CopiesAndViews {

    public static void main(String[] args) {

        // **********************************************************************
        // Small Collections (unmodifiable)
        // The elements, keys, or values may not be null

        // Методы of()
        List<String> emptyList = List.of(); // пустой список (лучше - emptyList() - см. далее)
        List<String> list = List.of("One"); // можно указать любое кол-во элементов

        // инициализация обычной коллекции (изменяемой) с помощью метода of()
        List<String> names = new ArrayList<>(List.of("One", "Two")); // unmodifiable -> modifiable

        Set<String> set = Set.of("One"); // все, как у List.of()

        Map<String, Integer> map = Map.of("One", 1);
        Map<String, Integer> map2 = Map.ofEntries(
                Map.entry("one", 1),
                Map.entry("two", 2));


        /* Методы возвращают коллекции, состоящие из одного элемента (singleton)
        • static <E> List<E> singletonList(E value)
        • static <E> Set<E> singleton(E value)
        • static <K, V> Map<K, V> singletonMap(K key, V value)
         */

        /* Методы возвращют пустые коллекции, итераторы и т.д.
        • static <E> List<E> emptyList()

        • static <T> Set<T> emptySet()
        • static <E> SortedSet<E> emptySortedSet()
        • static NavigableSet<E> emptyNavigableSet()

        • static <K,V> Map<K,V> emptyMap()
        • static <K,V> SortedMap<K,V> emptySortedMap()
        • static <K,V> NavigableMap<K,V> emptyNavigableMap()

        • static <T> Enumeration<T> emptyEnumeration()
        • static <T> Iterator<T> emptyIterator()
        • static <T> ListIterator<T> emptyListIterator()
        */

        // Метод nCopies возвращает неизменяемый список из n элементов с одинковыми значениями
        // (при этом фактически создается только один объект для значений)
        List<String> ones = Collections.nCopies(100, "one");

        // Arrays.asList(...)
        /*
        static<Е> List<E>asList(Е...array)
        Возвращает представление списка элементов массива, который является модифицируемым, но
        с неизменяемым размером, то есть, можно set(), но нельзя add() и remove().
        */

        // **********************************************************************
        // Subranges Поддиапазоны
        // С ними можно делать любые операции (в том числе изменения) и это отразится на основной коллекции
        // Например, метод clear() очистит поддиапазон и одновременно удалить эти элементы из основной коллекции
        /*
        staff.subList(lO, 20); // возвращает коллекцию из элементов с 10-го по 19-ый включительно

        SortedSet<E> subSet(E from, E to)
        SortedSet<E> headSet(E to)
        SortedSet<E> tailSet(E from)

        SortedMap<K, V> subMap(K from, K to)
        SortedMap<K, V> headMap(K to)
        SortedMap<K, V> tailMap(K from)

        NavigableSet<E> subSet(E from, boolean fromInclusive, E to, boolean toInclusive)
        NavigableSet<E> headSet(E to, boolean toInclusive)
        NavigableSet<E> tailSet(E from, boolean fromInclusive)
        */

        // **********************************************************************
        // Unmodifiable Copies and Views

        ArrayList<String> names1 = new ArrayList<>();
        List<String> nameList = List.copyOf(names1); // The names as an unmodifiable list
        Set<String> nameSet = Set.copyOf(names1); // The names as an unmodifiable set

        /*
        Collections.unmodifiableCollection
        Collections.unmodifiableList

        Collections.unmodifiableSet
        Collections.unmodifiableSortedSet
        Collections.unmodifiableNavigableSet

        Collections.unmodifiableMap
        Collections.unmodifiableSortedMap
        Collections.unmodifiableNavigableMap
        */

        // **********************************************************************
        // Checked Views

        List<String> strings = new ArrayList<>();
        List<String> safeStrings = Collections.checkedList(strings, String.class);
        List rawList = safeStrings;
        rawList.add(new Date()); // checked list throws a ClassCastException

        /*
        static <E> Collection checkedCollection(Collection<E> c, Class<E> elementType)
        static <E> List checkedList(List<E> c, Class<E> elementType)
        static <E> Queue<E> checkedQueue(Queue<E> queue, Class<E> elementType)

        static <E> Set checkedSet(Set<E> c, Class<E> elementType)
        static <E> SortedSet checkedSortedSet(SortedSet<E> c, Class<E> elementType)
        static <E> NavigableSet checkedNavigableSet(NavigableSet<E> c, Class<E> elementType)

        static <K, V> Map checkedMap(Map<K, V> c, Class<K> keyType, Class<V> valueType)
        static <K, V> SortedMap checkedSortedMap(SortedMap<K, V> c, Class<K> keyType, Class<V> valueType)
        static <K, V> NavigableMap checkedNavigableMap(NavigableMap<K, V> c, Class<K> keyType, Class<V> valueType)
        */

        // **********************************************************************
        // Synchronized Views
        // Методы возвращяют коллекции, методы которых синхронизированы,
        // то есть пока метод занят первым потоком не допускается обращение к методу из другого потока

        var synchronizedMap = Collections.synchronizedMap(new HashMap<String, Integer>());

        /*
        static <E> Collection<E> synchronizedCollection(Collection<E> c)
        static <E> List synchronizedList(List<E> c)

        static <E> Set synchronizedSet(Set<E> c)
        static <E> SortedSet synchronizedSortedSet(SortedSet<E> c)
        static <E> NavigableSet synchronizedNavigableSet(NavigableSet<E> c)

        static <K, V> Map<K, V> synchronizedMap(Map<K, V> c)
        static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> c)
        static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> c)
        */

    }
}
