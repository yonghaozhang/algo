package hashtable;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Hashtable;

import static org.junit.Assert.*;

@Slf4j
public class HashTable2Test {

    @Test
    public void put() throws Exception {
        HashTable2<String, String> table2 = new HashTable2<String, String>(5);
        table2.put("1", "1");
        table2.put("2", "2");
        table2.put("3", "3");
        log.info(table2.toString());
    }

    @Test
    public void get() throws Exception {
        HashTable2<String, String> table2 = new HashTable2<String, String>(5);
        table2.put("1", "1");
        table2.put("2", "2");
        table2.put("3", "3");
        log.info(table2.toString());
        String value = table2.get("1");
        log.info(value);
    }

    @Test
    public void remove() throws Exception {
        HashTable2<String, String> table2 = new HashTable2<String, String>(5);
        table2.put("1", "1");
        table2.put("2", "2");
        table2.put("3", "3");
        log.info(table2.toString());
        table2.remove("1");
        log.info(table2.toString());
    }

}