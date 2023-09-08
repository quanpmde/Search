package Controller;

import Common.Algorithm;
import Common.Library;
import Model.Element;
import View.Menu;

/**
 *
 * @author ACER
 */
public class Sort_Search_Programming extends Menu<String> {

    static String[] mc = {"Sort", "Search", "Exit"};

    protected Library library;
    protected Algorithm algorithm;
    protected int[] array;
    protected int size_array;

    public Sort_Search_Programming(Element element) {
        super("PROGRAMMING", mc);
        library = new Library();
        algorithm = new Algorithm();
        size_array = element.getSize_array();
        array = element.getArray();
    }

    public void execute(int n) {
        switch (n) {
            case 1:
                sort();
                break;
            case 2:
                search();
                break;
            case 3:
                System.exit(0);
        }
    }

    public void sort() {
        final String[] mcSort = {"Buddle Sort", "Quick Sort", "Exit"};
        class SortMenu extends Menu<String> {

            public SortMenu() {
                super("Sort Option", mcSort);
            }

            @Override
            public void execute(int n) {
                System.out.println("Unsorted array: ");
                library.display(array);
                switch (n) {
                    case 1:
                        algorithm.buddleSort(array);
                        System.out.println("\nSorted array by Buddle Sort: ");
                        library.display(array);
                        System.out.println("");
                        break;
                    case 2:
                        algorithm.quickSort(array, 0, size_array - 1);
                        System.out.println("\nSorted array by Quick Sort: ");
                        library.display(array);
                        System.out.println("");
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }
        }
        SortMenu sm = new SortMenu();
        sm.run();
    }

    public void search() {
        final String[] mcSearch = {"Linear Search", "Binary Search", "Exit"};
        class SearchMenu extends Menu<String> {

            public SearchMenu() {
                super("Search Option", mcSearch);
            }

            @Override
            public synchronized void execute(int n) {
                algorithm.buddleSort(array);
                library.display(array);
                int value = library.getInt("\nEnter number to find: ", 1, 100);
                switch (n) {
                    case 1:
                        System.out.println("Found value: " + value + " at index: " + algorithm.linearSearch(array, value));
                        break;
                    case 2:
                        System.out.println("Found value: " + value + " at index: " + algorithm.binarySearch(array, value));
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }
        }
        SearchMenu sm = new SearchMenu();
        sm.run();
    }
}