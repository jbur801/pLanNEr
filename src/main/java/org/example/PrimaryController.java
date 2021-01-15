package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    //if you look at the fxml file or the code tab in scenebuilder you will see that this method is bound to the button (onAction)
    //to be able to call a method with a button the simplest way is to put this @FXML tag above it and then bind it as shown
    //there are some other ways I could show you
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
