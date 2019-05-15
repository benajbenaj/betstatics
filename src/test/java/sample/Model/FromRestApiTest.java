package sample.Model;

import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FromRestApiTest {
    org.json.JSONObject x;
    org.json.JSONArray y;

    FromRestApi restApi;
    @BeforeEach
    void setUp() {
        x=new org.json.JSONObject("{alma:körte}");
        y=new JSONArray();
    }

    @AfterEach
    void tearDown() {
        y = null;
        x = null;
    }

    @Test
    void makeJsonObjects() {
        y.put(x);
        List<org.json.JSONObject> returned = new List<JSONObject>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<JSONObject> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(JSONObject jsonObject) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends JSONObject> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends JSONObject> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public JSONObject get(int i) {
                return null;
            }

            @Override
            public JSONObject set(int i, JSONObject jsonObject) {
                return null;
            }

            @Override
            public void add(int i, JSONObject jsonObject) {

            }

            @Override
            public JSONObject remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<JSONObject> listIterator() {
                return null;
            }

            @Override
            public ListIterator<JSONObject> listIterator(int i) {
                return null;
            }

            @Override
            public List<JSONObject> subList(int i, int i1) {
                return null;
            }
        };
        assertEquals(returned,restApi.makeJsonObjects(y));

    }

}