package com.baidu.service;

import java.text.DecimalFormat;
import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

@Component
public class CacheSequenceService {

    private Format numberFormat = new DecimalFormat("000000");

    static enum Entity {
        device, user,
    }

    static class CacheSequence {
        String sequenceEntity;
        String sequenceKey;
        int sequenceValue = 1;
    }

    public String getCode(Entity entity, Supplier<String> key) {
        String sequenceKey = key.get();
        CacheSequence sequence = mockSelect(entity.name(), sequenceKey);

        if (Objects.isNull(sequence)) {
            sequence = mockInsert(entity.name(), sequenceKey);
        }
        else {
            sequence.sequenceValue++;
            mockUpdate(sequence);
        }

        return numberFormat.format(sequence.sequenceValue);
    }

    private Map<String, CacheSequence> db = new HashMap<>();

    private CacheSequence mockSelect(String entity, String sequenceKey) {
        return db.get(entity + sequenceKey);
    }

    private CacheSequence mockInsert(String entity, String sequenceKey) {
        CacheSequence sequence = new CacheSequence();
        sequence.sequenceEntity = entity;
        sequence.sequenceKey = sequenceKey;
        db.put(entity + sequenceKey, sequence);

        return sequence;
    }

    private void mockUpdate(CacheSequence sequence) {
        db.put(sequence.sequenceEntity + sequence.sequenceKey, sequence);
    }

    public static void main(String[] args) {

        CacheSequenceService service = new CacheSequenceService();

        Supplier<String> supplier = () -> LocalDate.now().format(DateTimeFormatter.ofPattern("YYYYMM"));

        for (int i = 0; i < 120002; i++) {
            Entity entity = i % 2 == 1 ? Entity.device : Entity.user;
            String code = "DO-" + supplier.get() + "-" + service.getCode(entity, supplier);
            System.out.println(entity.name() + ": " + code);
        }
    }
}
