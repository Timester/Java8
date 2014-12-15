package net.talqum.learning.util;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by Tömösvári Imre on 2014.06.23..
 * Model object for the demos. Implements Comparable.
 */
public class Person implements Comparable<Person>{

    public enum Sex {
        MALE, FEMALE
    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge(){
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public void printPerson() {
        System.out.println(name + ", " + birthday);
    }

    @Override
    public int compareTo(Person other)
    {
        return this.name.compareTo(other.getName());
    }
}
