package algonquin.cst2335.ahmedsandroidlabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import algonquin.cst2335.ahmedsandroidlabs.databinding.ActivityChatRoomBinding;
import algonquin.cst2335.ahmedsandroidlabs.databinding.SentMessegeBinding;

public class ChatRoom extends AppCompatActivity {

    ActivityChatRoomBinding binding;
    ArrayList<String> messages = new ArrayList<>();
    private RecyclerView.Adapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChatRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.sendButton.setOnClickListener( click ->{
            // Getting the typed message
            messages.add(binding.textInput.getText().toString());
            myAdapter.notifyDataSetChanged();
            // clear the previous text:
            binding.textInput.setText("");
        });

        binding.recycleView.setAdapter(myAdapter = new RecyclerView.Adapter<MyRowHolder>() {
            @NonNull
            @Override
            public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                // This inflates the row layout
                SentMessegeBinding binding = SentMessegeBinding.inflate(getLayoutInflater());
                return new MyRowHolder( binding.getRoot() );
            }

            @Override
            public void onBindViewHolder(@NonNull MyRowHolder holder, int position) {
                // This initializes the row to data

                holder.messageText.setText("");
                //holder.timeText.setText("");
                String obj = messages.get(position);
                holder.messageText.setText(obj);
                //holder.timeText.setText("Show time");
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