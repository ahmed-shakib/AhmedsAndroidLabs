package algonquin.cst2335.ahmedsandroidlabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import algonquin.cst2335.ahmedsandroidlabs.data.ChatRoomViewModel;
import algonquin.cst2335.ahmedsandroidlabs.databinding.ActivityChatRoomBinding;
import algonquin.cst2335.ahmedsandroidlabs.databinding.ReceiveMessegeBinding;
import algonquin.cst2335.ahmedsandroidlabs.databinding.SentMessegeBinding;

public class ChatRoom extends AppCompatActivity {

    private ChatRoomViewModel chatModel ;
    private ActivityChatRoomBinding binding;
    private ArrayList<ChatMessage> messages = new ArrayList<>();
    private RecyclerView.Adapter myAdapter;
    boolean position;

    //boolean isSend;

    SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a");
    String currentDateandTime = sdf.format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChatRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        chatModel = new ViewModelProvider(this).get(ChatRoomViewModel.class);
        messages= chatModel.messages;

        MessageDatabase db = Room.databaseBuilder(getApplicationContext(), MessageDatabase.class, "database-name").build();
        ChatMessageDAO mDAO= db.cmDAO();

        if(messages == null)
        {
            //chatModel.messages.setValue(messages = new ArrayList<>()); // setValue is not working
            chatModel.messages.addAll(messages = new ArrayList<>());

            Executor thread = Executors.newSingleThreadExecutor();
            thread.execute(() ->
            {
                messages.addAll( mDAO.getAllMessages() ); //Once you get the data from database

                runOnUiThread( () ->  binding.recycleView.setAdapter( myAdapter )); //You can then load the RecyclerView
            });
        }

        // Event-handler to capture receive button clicks
        binding.sendButton.setOnClickListener( click ->{
            position = true;
            messages.add(new ChatMessage(binding.textInput.getText().toString(),currentDateandTime,true));
            myAdapter.notifyDataSetChanged();
            // clear the previous text:
            binding.textInput.setText("");
        });
        // Event-handler to capture receive button clicks
        binding.receiveButton.setOnClickListener( click ->{
            position = false;
            messages.add(new ChatMessage(binding.textInput.getText().toString(),currentDateandTime,false));
            myAdapter.notifyDataSetChanged();
            // clear the previous text:
            binding.textInput.setText("");
        });

        binding.recycleView.setAdapter(myAdapter = new RecyclerView.Adapter<MyRowHolder>() {
            @NonNull
            @Override
            public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                // This inflates the row layout depending on the view type.
                if(viewType == 0){
                    SentMessegeBinding binding = SentMessegeBinding.inflate(getLayoutInflater(), parent,false);
                    return new MyRowHolder( binding.getRoot() );
                }
                else{
                    ReceiveMessegeBinding binding = ReceiveMessegeBinding.inflate(getLayoutInflater(), parent, false);
                    return new MyRowHolder( binding.getRoot() );
                }
            }

            // This is to decide which layout will be used
            @Override
            public int getItemViewType(int position) {
                if (messages.get(position).isSentButton==true){
                    return 0;
                }
                else{
                    return 1;
                }
            }

            @Override
            public void onBindViewHolder(@NonNull MyRowHolder holder, int position) {

                // Clearing up the previous message and the time stamp
                holder.messageText.setText("");
                holder.timeText.setText("");

                // Creating an instance of ChatMessage class
                ChatMessage obj = messages.get(position);

                // Setting the message text and the time stamp
                holder.messageText.setText(obj.message);
                holder.timeText.setText(obj.timeSent);
            }

            @Override
            // Counts how many rows

            public int getItemCount() {
                return messages.size();
            }
        });
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    protected class MyRowHolder extends RecyclerView.ViewHolder {

        TextView messageText;
        TextView timeText;
        public MyRowHolder(@NonNull View itemView) {
            super(itemView);
            messageText = itemView.findViewById(R.id.messageText);
            timeText = itemView.findViewById((R.id.timeText));
        }
    }
}