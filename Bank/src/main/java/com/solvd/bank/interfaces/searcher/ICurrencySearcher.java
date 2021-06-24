package com.solvd.bank.interfaces.searcher;

import com.solvd.bank.paymethods.Currency;

import java.util.List;

public interface ICurrencySearcher<T> {

    List<T> search(List<T> currencyList);
}
