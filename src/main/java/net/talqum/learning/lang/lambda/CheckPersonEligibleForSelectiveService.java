package net.talqum.learning.lang.lambda;

import net.talqum.learning.util.Person;

/**
 * Created by Tömösvári Imre on 2014.06.23..
 */
public class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
        return p.getGender() == Person.Sex.MALE &&
                p.getAge() >= 18 &&
                p.getAge() <= 25;
    }
}
