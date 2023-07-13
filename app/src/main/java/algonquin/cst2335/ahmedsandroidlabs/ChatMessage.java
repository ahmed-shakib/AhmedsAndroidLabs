package algonquin.cst2335.ahmedsandroidlabs;

public class ChatMessage {
    public String message;
    public String timeSent;
    boolean isSentButton;

    public ChatMessage(){

    }

    public ChatMessage(String m, String t, boolean sent) {
        message = m;
        timeSent = t;
        isSentButton = sent;
    }

    public String getMessage(){
        return message;
    }

    public String getTime(){
        return timeSent;
    }

    public boolean getIsSentButton(){
        return isSentButton;
    }

}
