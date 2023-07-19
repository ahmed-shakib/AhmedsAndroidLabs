package algonquin.cst2335.ahmedsandroidlabs;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChatMessage {

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name="id")
    public long id;
    @ColumnInfo(name="message")
    public String message;
    @ColumnInfo(name="timesent")
    public String timeSent;
    @ColumnInfo(name="isSentButton")
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
