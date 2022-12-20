package observable;


import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class ObservableController implements Initializable {
  @FXML
  private Text alphabetLabel;

  @FXML
  private TextField tf1;
  @FXML
  private TextField tf2;
  private AlphabetAnimation alphabetAnimation;
  @Override public void initialize(URL url, ResourceBundle resourceBundle) {
    sumNonObservable();
    sumObservable();
    alphabetAnimation = new AlphabetAnimation();
    Timer timer = new Timer(true);
    timer.schedule(alphabetAnimation, 1000 , 1000);
    alphabetLabel.textProperty().bind(alphabetAnimation.textProperty());
  }


  private void sumNonObservable() {
    int a  = 10;
    int b = 10;
    int sum  = a + b;
    System.out.println(sum);
    a = 20;
    System.out.println(sum);
  }

  private void sumObservable() {
    //In java we have special type for observables such as SimpleStringProperty, SimpleIntegerProperty
    SimpleIntegerProperty a = new SimpleIntegerProperty(10);
    SimpleIntegerProperty b = new SimpleIntegerProperty(10);
    //method to add in observables, return type is NumberBinding
    NumberBinding sum = a.add(b); //the sum is bound to value of a and b, so whenever a or b changes the sum will be changed automatically
    System.out.println(sum.getValue());
    b.set(20);
    System.out.println(sum.getValue());
  }

}
