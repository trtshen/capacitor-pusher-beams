package com.cesarbarone.pusherbeams;

import com.getcapacitor.JSObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class PusherBeamsTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(3, 3);
    }

    @Test
    public void hashMapOf() {
        JSObject headers = mock(JSObject.class);
        Iterator<String> iterator = mock(Iterator.class);

        when(headers.getString("Authorization")).thenReturn("Bearer 123321");
        when(headers.keys()).thenReturn(iterator);
        when(iterator.hasNext()).thenReturn(true,false);
        when(iterator.next()).thenReturn("Authorization");


        HashMap<String, String> hashMap = PusherBeams.hashMapOf(headers);
        assertEquals("Bearer 123321", hashMap.get("Authorization"));
    }
}