package com.dt.tutorial.java8.lesson1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Step1: 
 * - what does this code do? 
 * - how does it sort? -> check Person class
 * - remove implemented interface definition
 * - move implemented method out and change .sort parameters
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
    // TODO: what if the requirements will change?
    Collections.sort(people);
    
    // printing
    for (Person p : people) {
      System.out.println(p);
    }
  }
}
