import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex01.KeyValueStore;

class KVSTest {
    private KeyValueStore kvs = new KeyValueStore(20);

    @Test
    void newTest() {
        kvs.newKVP("key1", "erste");
        assertEquals(kvs.getKVP("key1"), "erste");
        assertThrows(IllegalArgumentException.class, () -> kvs.newKVP("key1", "gleiche"));

    }

    @Test
    void getTest() {
        kvs.newKVP("key1", "erste");
        assertEquals(kvs.getKVP("key1"), "erste");
        assertThrows(IllegalArgumentException.class, () -> kvs.getKVP("key2"));
    }

    @Test
    void deleteTest() {
        kvs.newKVP("key1", "erste");
        assertDoesNotThrow(() -> kvs.deleteKVP("key1"));
        assertThrows(IllegalArgumentException.class, () -> kvs.deleteKVP("key2"));
    }
    @Test
    void updateTest(){
        kvs.newKVP("key1", "erste");
        assertEquals(kvs.updateKVP("key1", "updatedValue"), "updatedValue");
        assertThrows(IllegalArgumentException.class, () -> kvs.deleteKVP("key2"));
    }

}