/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author siede
 */
import javax.websocket.*;
import javax.websocket.server.*;
import java.io.*;
import java.util.*;
import javax.json.*;
import com.simon.websocket.data.*;


@ServerEndpoint(value="/echo", encoders = {MessageEncoder.class}, decoders = {MessageDecoder.class}) 
public class EchoServer {
    // This might not look right as wordpress hates angle brack-ets.
private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet ());
@OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId() + " has opened a con-nection");    
        Message message = new Message(Json.createObjectBuilder()
           .add("type", "text")
           .add("data", "User has connected")
           .build());
        sendMessageToAll(message);
         try {
            Message connectedMessage = new Message(Json.createObjectBuilder()
           .add("type", "text")
           .add("data", "User has connected")
           .build());
            session.getBasicRemote().sendObject(connectedMessage);
        } catch (IOException | EncodeException ex) {}
        sessions.add(session); }
    @OnMessage
    public void onMessage(Message message, Session session){
        System.out.println("Message from " + session.getId() + ": " + message);
        sendMessageToAll(message); }
    @OnClose
    public void onClose(Session session){
        sessions.remove(session);
        System.out.println("Session " +session.getId()+" has ended");
        Message message = new Message(Json.createObjectBuilder()
           .add("type", "text")
           .add("data", "User has disconnected")
           .build());
        sendMessageToAll(message); }
    private void sendMessageToAll(Message message){
        for(Session s: sessions){
            try {
                s.getBasicRemote().sendObject(message);
            } catch (IOException | EncodeException ex) {}
        }
    }
}

