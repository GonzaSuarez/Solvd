package com.solvd.bank.interfaces.sorter;

import com.solvd.bank.paymethods.Currency;
import java.util.List;

public class BubbleSort implements ISorter{

    public BubbleSort() {}

    @Override
    public void sort(List<Currency> sortedList) {
        Currency temp = new Currency();
        for(int i = 0; i<sortedList.size(); i++){
            for(int j = 1; j<(sortedList.size()-i); j++){
                if(sortedList.get(j-1).getAmmount() > sortedList.get(j).getAmmount()){
                    temp = sortedList.get(j-1);
                    sortedList.set(j-1, sortedList.get(j));
                    sortedList.set(j,temp);
                }
            }
        }
    }
}
