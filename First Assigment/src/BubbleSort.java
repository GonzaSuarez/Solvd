import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public void sort(List<Integer> myList){
        Integer temp = 0;
        for(int i = 0; i<myList.size(); i++){
            for(int j = 1; j<myList.size(); j++){
                if(myList.get(j-1).intValue() > myList.get(j).intValue()){
                    temp = myList.get(j-1);
                    myList.set(j-1, myList.get(j));
                    myList.set(j,temp);
                }
            }
        }
    }


}
