package net.talqum.learning.lang.streaming;

import java.net.URL;
import java.util.List;

/**
 * Created by Imre on 2014.11.06..
 */
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



}
