package algonquin.cst2335.ahmedsandroidlabs.data;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import algonquin.cst2335.ahmedsandroidlabs.ChatMessage;

public class ChatRoomViewModel extends ViewModel {
    public ArrayList<ChatMessage> messages = new ArrayList<>();
}
