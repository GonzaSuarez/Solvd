import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void print(List<Integer> my_list){
        for (Integer i: my_list){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static final void main(String[] args){
        List<Integer> to_sort_list = new ArrayList<>();

        for(int i=0; i< args.length; i++){
            try{
                to_sort_list.add(Integer.parseInt(args[i]));
            }
            catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }

        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("Unsorted List");
        print(to_sort_list);
        bubbleSort.sort(to_sort_list);
        System.out.println("Sorted List");
        print(to_sort_list);

    }

}
