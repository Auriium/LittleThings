package xyz.auriium.littlethings.optionals.test.model;

import java.util.Optional;
import java.util.UUID;

public class DataClass {

    private final String nullableString;
    private final UUID nullableID;
    private final String otherNullableString;

    public DataClass(String nullableString, UUID nullableID, String otherNullableString) {
        this.nullableString = nullableString;
        this.nullableID = nullableID;
        this.otherNullableString = otherNullableString;
    }

    public Optional<String> getString() {
        return Optional.of(nullableString);
    }

    public Optional<UUID> getUUID() {
        return Optional.of(nullableID);
    }

    public Optional<String> getOther() {
        return Optional.of(otherNullableString);
    }
}
