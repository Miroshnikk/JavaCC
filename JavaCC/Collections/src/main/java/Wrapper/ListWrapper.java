package Wrapper;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class ListWrapper<T> {


    /**
     * Add other collection to the current list
     *
     * @param otherCollection
     */
    public abstract void addOtherCollection(Collection<? extends T> otherCollection);

    /**
     * Remove elements contained in the incoming collection
     *
     * @param collection
     * @return count deleted elements
     */
    public abstract int removeElementsByCollection(Collection<? extends T> collection);

    /**
     * @param collection
     * @return count elements contained in the list and in the incoming collection
     */
    public abstract int countDuplicates(Collection<? extends T> collection);

    /**
     * @return existing list
     */
    public abstract List<T> getList();

    /**
     * @param index
     * @return element by index from list
     */
    public abstract T getElement(int index);

    /**
     * @return beauty styled string of elements. (e.g. ["first", "second"])
     */
    public abstract String beautyString();

    /**
     * Create ListWrapper with incoming elements
     *
     * @param elements
     * @param <E>
     * @return ListWrapper by elements
     */
    public static <E> ListWrapper<E> fromElements(E... elements) {
        return Wrapper.build(elements);
    }


    public static class Wrapper<E> extends ListWrapper<E> {

        private E[] elements;

        public Wrapper(E[] elements) {
            if (elements == null) {
                throw new IllegalArgumentException("Elements should be not null!");
            }
            this.elements = elements;
        }

        public static <E> ListWrapper<E> build(E[] elements) {
            return new Wrapper<>(elements);
        }

        @Override
        public void addOtherCollection(Collection otherCollection) {
            if (Objects.isNull(otherCollection) || otherCollection.isEmpty()) {
                return;
            }
            List<E> collect = Stream.of(elements).collect(Collectors.toList());
            collect.addAll(otherCollection);
            this.elements = (E[]) collect.toArray();
        }

        @Override
        public int removeElementsByCollection(Collection collection) {
            if (Objects.isNull(collection) || collection.isEmpty()) {
                return 0;
            }
            List<E> list = Stream.of(elements).collect(Collectors.toList());
            int removed = 0;
            for (Object ob : collection) {
                if (list.remove(ob)) {
                    removed++;
                }
            }
            return removed;
        }

        @Override
        public int countDuplicates(Collection collection) {
            List<E> list = Stream.of(elements).collect(Collectors.toList());
            if (Objects.isNull(collection) || collection.isEmpty()) {
                return Math.toIntExact(findDuplicates(list));
            }
            list.addAll(collection);
            return Math.toIntExact(findDuplicates(list));
        }

        private long findDuplicates(List<E> list) {
            return list.stream() //
                    .distinct() //
                    .filter(entry -> Collections.frequency(list, entry) > 1) //
                    .count();
        }

        @Override
        public List getList() {
            return Arrays.asList(elements);
        }

        @Override
        public E getElement(int index) {
            try {
                return elements[index];
            } catch (ArrayIndexOutOfBoundsException ex) {
                return null;
            }
        }

        @Override
        public String beautyString() {
            return Arrays.deepToString(elements);
        }
    }

}