package com.solvd.bank.interfaces.sorter;

import com.solvd.bank.paymethods.Currency;

import java.util.List;

public interface ISorter {

    void sort(List<Currency> sortedList);
}
