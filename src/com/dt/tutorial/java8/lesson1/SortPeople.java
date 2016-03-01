package com.dt.tutorial.java8.lesson1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Step2: 
 * - why do we like anonymous classes?
 * - make it lambda
 * - add printSorted method
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
    
    // I know this is ugly, but it's Friday ;)
    Collections.sort(people, createComparatorByName());
    
    // printing
    for (Person p : people) {
      System.out.println(p);
    }
  }

  private static Comparator<Person> createComparatorByName() {

    return new Comparator<Person>() {

      @Override
      public int compare(Person p1, Person p2) {

        return compareToName(p1, p2);
      }
    };
  }

  private static Comparator<Person> createComparatorByAge() {

    return new Comparator<Person>() {

      @Override
      public int compare(Person p1, Person p2) {

        return p1.getAge() - p2.getAge();
      }
    };
  }

  private static Comparator<Person> createComparatorByAgeThenName() {

    return new Comparator<Person>() {

      @Override
      public int compare(Person p1, Person p2) {

        int result = compareToAge(p1, p2);
        if (result == 0) {
          result = compareToName(p1, p2);
        }
        return result;
      }
    };
  }

  private static int compareToName(Person p1, Person p2) {

    return p1.getName().compareTo(p2.getName());
  }

  private static int compareToAge(Person p1, Person p2) {

    return p1.getAge() - p2.getAge();
  }
}
