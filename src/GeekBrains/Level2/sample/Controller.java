package GeekBrains.Level2.sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;

    @FXML
    public void clickBtnSend() {
        textArea.appendText(textField.getText()+"\n");
        textField.clear();
        textField.requestFocus();
    }


}
