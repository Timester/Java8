package net.talqum.learning.lang.lambda;

import net.talqum.learning.util.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {

    public static void main(String[] args) {
        List<Person> roster = new ArrayList<>();

        // v3 class
        printPersons(roster, new CheckPersonEligibleForSelectiveService());
        // v3 anonymous class
        printPersons(
                roster,
                new CheckPerson() {
                    public boolean test(Person p) {
                        return p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25;
                    }
                }
        );
        // v3 lambda
        printPersons(
                roster,
                z -> z.getGender() == Person.Sex.MALE
                        && z.getAge() >= 18
                        && z.getAge() <= 25
        );
        // v4 test object with built in functional interface
        printPersonsWithPredicate(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );
        // v5 lambda for method invocation after the test, method reference
        processPersons(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::printPerson
        );
        // v6 lambda for method, return value
        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::getEmailAddress,
                System.out::println
        );
        // v7 v6 but with generics
        processElements(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::getEmailAddress,
                System.out::println
        );
        // v8 aggregate operations
        roster.stream()
                .filter(
                        p -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                .map(Person::getEmailAddress)
                .forEach(System.out::println);


        // method reference
        // lambda 1
        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);

        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        Arrays.sort(rosterAsArray, new PersonAgeComparator());

        // lambda 2
        Arrays.sort(rosterAsArray,
                (Person a, Person b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
        );

        // lambda 3
        Arrays.sort(rosterAsArray,
                (a, b) -> Person.compareByAge(a, b)
        );

        // method reference
        Arrays.sort(rosterAsArray, Person::compareByAge);
    }



    // v1 age limit
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    // v2 age range
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    // v3 test object
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // v4 test object with built in functional interface
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // v5 lambda for method invocation
    public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    // v6 lambda for method, return value
    public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester,
                                                  Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    // v7 v6 but with generics
    public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function <X, Y> mapper,
                                              Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }


}
