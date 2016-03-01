package com.dt.tutorial.java8.lesson1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Step4: 
 * - why Collections.sort is so ugly?
 * - let's transform that into a stream
 * - move out other business logic from Person class
 * 
 * @author dt
 *
 */
public class SortPeople {

  public static void main(String[] args) {

    List<Person> people = Arrays.asList(new Person("John Ross",      43),
                                        new Person("Sue Ellen",      38),
                                        new Person("Robert James",   33),
                                        new Person("Pamela Rebecca", 30),
                                        new Person("Raymond",        40),
                                        new Person("Clifford",       33));
    
    printSortedList(people, createComparatorByName());
  }

  private static void printSortedList(List<Person> people, Comparator<Person> comparator) {

    // I know this is ugly, but it's Friday ;)
    Collections.sort(people, comparator);
    
    // printing
    for (Person p : people) {
      System.out.println(p);
    }
  }

  private static Comparator<Person> createComparatorByName() {

    // method reference can be used instead of lambda expression...
    return SortPeople::compareToName;
  }

  private static Comparator<Person> createComparatorByAge() {

    // ... or a dynamic comparator can be created in this way:
    return Comparator.comparing(Person::getAge);
  }
  
  private static Comparator<Person> createComparatorByAgeThenName() {

    // a very dynamic one
    return Comparator.comparing(Person::getAge)
                     .thenComparing(Person::getName);
  }

  private static int compareToName(Person p1, Person p2) {

    return p1.getName().compareTo(p2.getName());
  }
}
