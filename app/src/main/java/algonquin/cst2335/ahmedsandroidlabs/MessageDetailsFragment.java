package algonquin.cst2335.ahmedsandroidlabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import algonquin.cst2335.ahmedsandroidlabs.databinding.DetailsLayoutBinding;

public class MessageDetailsFragment extends Fragment {
    ChatMessage thisMessage;
   public MessageDetailsFragment(ChatMessage toShow){
       thisMessage  = toShow;
   }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        DetailsLayoutBinding binding = DetailsLayoutBinding.inflate(inflater);
        binding.messageDetail.setText(thisMessage.message);
        binding.timeDetail.setText(thisMessage.timeSent);
        // For deciding if the message is sent or received
        if (this.thisMessage.isSentButton ==true){
            binding.sendReceiveDetail.setText("Send Message");
        }
        else
            binding.sendReceiveDetail.setText("Receive Message");
        binding.dbIdDetail.setText("Message # "+Long.toString(thisMessage.id));

        return binding.getRoot();
    }
}
