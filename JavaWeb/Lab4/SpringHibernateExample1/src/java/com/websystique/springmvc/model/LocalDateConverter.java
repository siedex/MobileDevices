/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

import javax.persistence.*;
import java.time.*;
import java.sql.*;
/**
 *
 * @author siede
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return null == localDate ? null: Date.valueOf(localDate);}
    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return null == date ? null: date.toLocalDate();}}

