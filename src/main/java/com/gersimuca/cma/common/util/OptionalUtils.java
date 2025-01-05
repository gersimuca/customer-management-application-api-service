package com.gersimuca.cma.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalUtils {
    /**
     * Returns an Optional for the given value if it is non-null, non-empty String, and non-empty
     * Collection.
     *
     * <p>If the value is null, an empty string, or an empty collection, this method returns an empty
     * Optional. Otherwise, it returns the optional of the value
     *
     * @param <T> the type of the value
     * @param value the value to be checked
     * @return an Optional
     */
    public static <T> Optional<T> ofNonEmpty(T value) {
        return switch (value) {
            case null -> Optional.empty();
            case String string when string.isEmpty() -> Optional.empty();
            case Collection<?> collection when collection.isEmpty() -> Optional.empty();
            default -> Optional.of(value);
        };
    }
}
