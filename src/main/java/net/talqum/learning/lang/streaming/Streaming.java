package net.talqum.learning.lang.streaming;

import net.talqum.learning.util.Credential;
import net.talqum.learning.util.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Streaming {

    /**
     * Sum the even numbers in a list, traditional way.
     * @param ints Integer list to be processed.
     * @return the sum of the even numbers in the input parameter.
     */
    public static int sumEvenInts(List<Integer> ints){
        int sum = 0;
        for (Integer anInt : ints) {
            if(anInt % 2 == 0){
                sum += anInt;
            }
        }
        return sum;
    }

    /**
     * Sum the even numbers in a list, with Streaming API.
     * @param ints Integer list to be processed.
     * @return the sum of the even numbers in the input parameter.
     */
    public static int sumEvenIntsStreaming(List<Integer> ints){
        return ints.stream()
            .filter(i -> i % 2 == 0)
            .reduce(0, Integer::sum);
    }

    /**
     * Returns the average host length in a List of URLs, traditional way.
     * http://index.hu/foo/bar  <- host is index.hu, with length of 8.
     *
     * @param URLs a List of URLs
     * @return average host length in the input List.
     */
    public static Double avgHostLength(List<URL> URLs){
        int lengthSum = 0;
        for (URL url : URLs) {
            lengthSum += url.getHost().length();
        }

        return Double.valueOf(lengthSum/URLs.size());
    }

    /**
     * Returns the average host length in a List of URLs, with Streaming API.
     * http://index.hu/foo/bar  <- host is index.hu, with length of 8.
     *
     * @param URLs a List of URLs
     * @return average host length in the input List.
     */
    public static Double avgHostLengthStreaming(List<URL> URLs){
        return URLs.stream()
            .mapToInt(u -> u.getHost().length())
            .average()
            .getAsDouble();
    }

    /**
     * Converts a List of objects of type A to a list of objects of type B the traditional way.
     *
     * @param credentials a list of Credential objects
     * @return a list of User objects
     */
    public static List<User> listOfCredentialsToUsers(List<Credential> credentials) {
        List<User> users = new ArrayList<>(credentials.size());
        for (Credential credential : credentials) {
            users.add(User.fromCrendentials(credential));
        }

        return users;
    }

    /**
     * Converts a List of objects of type A to a list of objects of type B using Streaming API.
     *
     * @param credentials a list of Credential objects
     * @return a list of User objects
     */
    public static List<User> listOfCredentialsToUsersStreaming(List<Credential> credentials) {
        return credentials.stream()
                .map(User::fromCrendentials)
                .collect(Collectors.toList());
    }
}
