/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simon.websocket.data;
import javax.json.*;
import java.io.*;
/**
 *
 * @author siede
 */
public class Message {
    private JsonObject json;
    public Message(JsonObject json) {
        this.json = json;}
     public JsonObject getJson() {
        return json;}
     public void setJson(JsonObject json) {
        this.json = json;}
     @Override
    public String toString(){
        StringWriter writer = new StringWriter();
        Json.createWriter(writer).write(json);
        return writer.toString();}
} 


