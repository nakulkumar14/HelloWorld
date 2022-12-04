package com.company;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class ListIterator implements Iterator<Integer> {

  Iterator<Iterator<Integer>> iterators;
  Iterator<Integer> current;
  ListIterator(Iterator<Iterator<Integer>> iterators) {
    this.iterators = iterators;
    this.current = iterators.next();
  }

  @Override
  public boolean hasNext() {
    if (!current.hasNext()) {
      if (!iterators.hasNext())
        return false;
      current = iterators.next();
      hasNext();
    }
    return true;
  }

  @Override
  public Integer next() {
    hasNext();
    return current.next();
  }

  @Override
  public void remove() {
    Iterator.super.remove();
  }
}

public class MultipleIterators {
  public static void main(String[] args) {
    Iterator<Integer> iterator = List.of(1, 2, 3, 4).iterator();
    Iterator<Integer> iterator1 = List.of(7, 8).iterator();
    Iterator<Integer> listIterator = new ListIterator(Arrays.asList(iterator, iterator1).iterator());
    while (listIterator.hasNext()) {
      System.out.println(listIterator.next());
    }
  }
}
