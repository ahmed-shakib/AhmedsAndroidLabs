package algonquin.cst2335.ahmedsandroidlabs.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//correspond to what's on mainAcitivity
public class MainActivityViewModel extends ViewModel {

    public String theText = "Hello World";
    public String buttonText = "Click me";
    public MutableLiveData<Boolean> isOn = new MutableLiveData<>(false);

}
