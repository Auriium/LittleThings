package xyz.auriium.littlethings.optionals.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.auriium.littlethings.optionals.Optionals;
import xyz.auriium.littlethings.optionals.test.model.DataClass;

import java.util.UUID;

public class FragmentingTest {

    Logger logger = LoggerFactory.getLogger("FragmentationTest");

    @Test
    public void triFragmentingAll() {
       DataClass data = new DataClass("test", UUID.randomUUID(), "another test string");

        Optionals
                .baseFragment(data.getString())
                .withPresent(data.getOther())
                .withPresent(data.getUUID())
                .ifPresent((string,string2,uuid) -> {
                    System.out.println(String.format("All objects are present: %s, %s, %s!", string, string2, uuid));
                });

    }

    public void triFragmentingNull() {

    }

}
