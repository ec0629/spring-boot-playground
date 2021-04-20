package com.jeffsimonitto.spring.springbootplayground.formatters;

import com.jeffsimonitto.spring.springbootplayground.entities.Variety;
import com.jeffsimonitto.spring.springbootplayground.services.VarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.util.Locale;

public class VarietyFormatter implements Formatter<Variety> {
    @Autowired
    private VarietyService varietyService;

    @Override
    public Variety parse(String text, Locale locale) throws NumberFormatException {
        final int varietyId = Integer.parseInt(text);
        return this.varietyService.findById(varietyId);
    }

    @Override
    public String print(Variety object, Locale locale) {
        return (object != null ? String.valueOf(object.getId()) : "");
    }
}
