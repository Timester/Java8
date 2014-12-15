package net.talqum.learning.lang.streaming;

import org.junit.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StreamingTest {

    @Test
    public void testSumEvenInts() throws Exception {
        List<Integer> ints = new ArrayList<>();
        for(int i=0; i<50; i++){
            ints.add(new Integer(i));
        }

        assertEquals(600, Streaming.sumEvenIntsStreaming(ints));
        assertEquals(Streaming.sumEvenInts(ints), Streaming.sumEvenIntsStreaming(ints));

    }

    @Test
    public void testAvgHostLength() throws Exception {
        List<URL> URLs = new ArrayList<>(3);
        URLs.add(new URL("http://index.hu/foo/bar"));
        URLs.add(new URL("http://facebook.com/foo/fighters"));
        URLs.add(new URL("http://goog.le"));

        assertEquals((Double) 9.0, Streaming.avgHostLength(URLs));
        assertEquals(Streaming.avgHostLength(URLs), Streaming.avgHostLengthStreaming(URLs));
    }
}