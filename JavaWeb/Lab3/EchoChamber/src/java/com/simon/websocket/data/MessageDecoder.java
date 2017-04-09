/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simon.websocket.data;
import javax.websocket.*;
import javax.json.*;
import java.io.*;
/**
 *
 * @author siede
 */
public class MessageDecoder implements Decoder.Text<Message>{
    @Override
    public Message decode(String string) throws DecodeException {
        JsonObject json = Json.createReader(new StringReader(string)).readObject();
        return new Message(json); }
    @Override
    public boolean willDecode(String string) {
        try{
            Json.createReader(new StringReader(string)).read();
            return true;
        }catch (JsonException ex){
            return false; }}
    @Override
    public void init(EndpointConfig config) {
        System.out.println("init");}
    @Override
    public void destroy() {
        System.out.println("destroy");}

}
