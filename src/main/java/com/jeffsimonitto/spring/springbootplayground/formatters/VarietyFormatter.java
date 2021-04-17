package com.jeffsimonitto.spring.springbootplayground.formatters;

import com.jeffsimonitto.spring.springbootplayground.entities.Variety;
import com.jeffsimonitto.spring.springbootplayground.services.VarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class VarietyFormatter implements Formatter<Variety> {
    private VarietyService varietyService;

    @Autowired
    public void setVarietyService(VarietyService varietyService) {
        this.varietyService = varietyService;
    }

    @Override
    public Variety parse(String text, Locale locale) throws ParseException {
        final Integer varietyId = Integer.valueOf(text);
        return this.varietyService.findById(varietyId);
    }

    @Override
    public String print(Variety object, Locale locale) {
        return (object != null ? object.getId().toString() : "");
    }
}
