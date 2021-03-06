package com.jeffsimonitto.spring.springbootplayground.repositories;

import com.jeffsimonitto.spring.springbootplayground.entities.Variety;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VarietyRepositoryImpl implements VarietyRepository {
    private final Map<Integer, Variety> varietiesById;

    public VarietyRepositoryImpl() {
        super();

        this.varietiesById = new LinkedHashMap<>();

        final Variety var1 = new Variety();
        var1.setId(1);
        var1.setName("Thymus vulgaris");
        this.varietiesById.put(var1.getId(), var1);

        final Variety var2 = new Variety();
        var2.setId(2);
        var2.setName("Thymus x citriodorus");
        this.varietiesById.put(var2.getId(), var2);

        final Variety var3 = new Variety();
        var3.setId(3);
        var3.setName("Thymus herba-barona");
        this.varietiesById.put(var3.getId(), var3);

        final Variety var4 = new Variety();
        var4.setId(4);
        var4.setName("Thymus pseudolaginosus");
        this.varietiesById.put(var4.getId(), var4);

        final Variety var5 = new Variety();
        var5.setId(5);
        var5.setName("Thymus serpyllum");
        this.varietiesById.put(var5.getId(), var5);
    }

    @Override
    public List<Variety> findAll() {
        return new ArrayList<>(this.varietiesById.values());
    }

    @Override
    public Variety findById(final int id) {
        return this.varietiesById.get(id);
    }
}
