package com.dt.tutorial.java8.lesson1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Step3: 
 * - how can we create comparators in nicer way?
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

    // lambda expressions are working fine with functions...
    return (p1, p2) -> compareToName(p1, p2);
  }

  private static Comparator<Person> createComparatorByAge() {

    // ... or whole calculations
    return (p1, p2) -> p1.getAge() - p2.getAge();
  }
  
  private static Comparator<Person> createComparatorByAgeThenName() {

    // longer form of lamda expression. in case of more lines.
    return (p1, p2) -> {
      int result = compareToAge(p1, p2);
      if (result == 0) {
        result = compareToName(p1, p2);
      }
      return result;
    };
  }

  private static int compareToName(Person p1, Person p2) {

    return p1.getName().compareTo(p2.getName());
  }

  private static int compareToAge(Person p1, Person p2) {

    return p1.getAge() - p2.getAge();
  }
}
