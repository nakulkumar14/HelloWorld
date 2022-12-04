package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PhoneIterator implements Iterable<String>{

  private List<String> phones = new ArrayList<>();

  public void add(String phone) {
    phones.add(phone);
  }

  @Override
  public Iterator<String> iterator() {
    return (Iterator<String>) new PhoneIt();
  }

  class PhoneIt implements Iterator<String>{
    private int index = 0;

    @Override
    public boolean hasNext() {
      return index < phones.size();
    }

    @Override
    public String next() {
      return phones.get(index++);
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}

public class CustomIterator {
  public static void main(String[] args) {
    PhoneIterator phoneIterator = new PhoneIterator();
    phoneIterator.add("nokia");
    phoneIterator.add("apple");
    phoneIterator.add("samsung");
    phoneIterator.add("motorola");

    for (String s : phoneIterator) {
      System.out.println(s);
    }
  }
}
