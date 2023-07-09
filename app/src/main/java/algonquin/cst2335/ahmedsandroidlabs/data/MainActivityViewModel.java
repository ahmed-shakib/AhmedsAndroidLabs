package algonquin.cst2335.ahmedsandroidlabs.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//correspond to what's on mainAcitivity
public class MainActivityViewModel extends ViewModel {

    public String theText = "Hello world";
    public String buttonText = "Cilck me";
    public MutableLiveData<Boolean> isOn = new MutableLiveData<>(false);

}
