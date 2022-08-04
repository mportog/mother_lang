package br.com.ufabc.motherLanguage.datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MotherSymbolTable {
    private HashMap<String, MotherVariable> map;

    public MotherSymbolTable() {
        map = new HashMap<String, MotherVariable>();

    }

    public void add(MotherVariable symbol) {
        map.put(symbol.getName(), symbol);
    }

    public boolean exists(String symbolName) {
        return map.get(symbolName) != null;
    }

    public MotherVariable get(String symbolName) {
        return map.get(symbolName);
    }

    public ArrayList<MotherSymbol> getAll() {
        ArrayList<MotherSymbol> lista = new ArrayList<MotherSymbol>();
        for (MotherSymbol symbol : map.values()) {
            lista.add(symbol);
        }
        return lista;
    }

    public void replace(String id, MotherVariable newSymbol) {
        map.replace(id, newSymbol);
    }

    public Collection<MotherVariable> values() {
        return map.values();
    }
}