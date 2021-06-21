package com.solvd.bank.interfaces.searcher;

import com.solvd.bank.paymethods.Currency;

import java.util.List;

public interface ICurrencySearcher {

    List<Currency> search(List<Currency> currencyList);
}
