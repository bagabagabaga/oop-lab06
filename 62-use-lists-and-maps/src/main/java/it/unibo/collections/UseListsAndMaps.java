package it.unibo.collections;

import java.util.*;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> al = new ArrayList<Integer>();
        for(int i = 1000; i < 2000; i++){
            al.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> llint = new LinkedList<Integer>(al);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer tmp = al.get(al.size() - 1);
        al.set(al.size() - 1, al.get(0));
        al.set(0, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer intg : al) {
            System.out.print(intg + " ");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for(int i = 0; i <= 999999; i++){
            al.add(1234);
        }
        time = System.nanoTime() - time;
        System.out.println("\nfor wirting to arraylist it took: " + time + "ns");

        time = System.nanoTime();
        for(int i = 0; i <= 999999; i++){
            llint.add(1234);
        }
        time = System.nanoTime() - time;
        System.out.println("for writing linkedlist it took: " + time + "ns");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for(int i = al.size()/2; i <= al.size()/2+1000; i++){
            al.get(i);
        }
        time = System.nanoTime() - time;
        System.out.println("for reading from arraylist it took: " + time + "ns");

        time = System.nanoTime();
        for(int i = al.size()/2; i <= al.size()/2+1000; i++){
            llint.get(i);
        }
        time = System.nanoTime() - time;
        System.out.println("for reading from linkedlist it took: " + time + "ns");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000 <XD
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> world = new HashMap<String, Long>();
        final long africaPop =  1110635000l;
        world.put("Africa", africaPop);
        final long AmericasPop = 972005000l;
        world.put("Americas", AmericasPop);
        final long AntarticaPop =  0l;
        world.put("Africa", AntarticaPop);
        final long AsiaPop = 4298723000l;
        world.put("Americas", AsiaPop);
        final long EuropePop =  742452000l;
        world.put("Africa", EuropePop);
        final long OceaniaPop = 38304000l;
        world.put("Americas", OceaniaPop);
        /*
         * 8) Compute the population of the world
         */
        long population = 0;
        for(Long pop : world.values()){
            population += pop;
        }
        System.out.println("popolazione totale: " + population);
    }
}
