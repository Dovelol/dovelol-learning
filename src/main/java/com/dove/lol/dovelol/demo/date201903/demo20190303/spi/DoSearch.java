package com.dove.lol.dovelol.demo.date201903.demo20190303.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Dovelol
 * @date 2019/3/3 22:34
 */
public class DoSearch {

    public static void main(String[] args) {
        ServiceLoader<Search> sl = ServiceLoader.load(Search.class);

        Iterator<Search> iterable = sl.iterator();
        iterable.forEachRemaining(Search::search);
    }

}
