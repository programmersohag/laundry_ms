package com.sohag.laundry_backend.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Gender attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public Gender convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(Gender.values())
                .filter(c -> Objects.equals(c.getValue(), dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }
}
