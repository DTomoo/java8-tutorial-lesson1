package com.dt.tutorial.java8.lesson1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Final version for the presentation.
 * Question 1: what is my favorite design pattern?
 * Question 2: where are these people living? 
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
    
    printSortedList(people, Comparator.comparing(Person::getName));
  }

  private static void printSortedList(List<Person> people, Comparator<Person> comparator) {

    people.stream()
          .sorted(comparator)
          .map(SortPeople::getPrintablePerson)
          .forEach(System.out::println);
  }

  private static String getPrintablePerson(Person person) {
    return "Person [ name = " + String.format("%1$-14s", person.getName()) + ", age = " + person.getAge() + " ]";
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
}
