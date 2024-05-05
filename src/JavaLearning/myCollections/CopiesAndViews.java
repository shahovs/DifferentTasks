package JavaLearning.myCollections;

import java.util.*;

// Представления и оболочки
public class CopiesAndViews {

    public static void main(String[] args) {

        // **********************************************************************
        // Small Collections (unmodifiable)
        // The elements, keys, or values may not be null
        List<String> list = List.of("One");
        List<String> names = new ArrayList<>(List.of("One", "Two")); // unmodifiable -> modifiable

        Set<String> set = Set.of("One");

        Map<String, Integer> map = Map.of("One", 1);
        Map<String, Integer> map2 = Map.ofEntries(
                Map.entry("one", 1),
                Map.entry("two", 2));

        List<String> ones = Collections.nCopies(100, "one");

        // **********************************************************************
        // Subranges Поддиапазоны
        /*
        staff.subList(lO, 20);

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

        // **********************************************************************
        // Synchronized Views
        var synchronizedMap = Collections.synchronizedMap(new HashMap<String, Integer>());

    }
}
