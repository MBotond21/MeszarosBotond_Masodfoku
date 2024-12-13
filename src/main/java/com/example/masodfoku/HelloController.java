package com.example.masodfoku;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField aInp;
    @FXML
    private TextField bInp;
    @FXML
    private TextField cInp;

    @FXML
    private Button calcBtn;

    @FXML
    private Label x1Out;
    @FXML
    private Label x2Out;
    @FXML
    private Label error;

    private boolean checkInputs(){

        if(aInp.getText().isEmpty() || bInp.getText().isEmpty() || cInp.getText().isEmpty()){
            error.setText("Kérlek add meg az összes számot!");
            return false;
        }

        try{
            Double.parseDouble(aInp.getText());
            Double.parseDouble(bInp.getText());
            Double.parseDouble(cInp.getText());
        }catch (NumberFormatException e){
            error.setText("Kérlek csak számot adj meg!");
            return false;
        }

        error.setText("");
        return true;
    }

    @FXML
    protected void onCalcButtonClick() {
        if (checkInputs()){

            x1Out.setText("x1 = ");
            x2Out.setText("x2 = ");

            double a = Double.parseDouble(aInp.getText());
            double b = Double.parseDouble(bInp.getText());
            double c = Double.parseDouble(cInp.getText());

            double result = b * b - 4.0 * a * c;

            if (result > 0.0) {
                double r1 = (-b + Math.pow(result, 0.5)) / (2.0 * a);
                double r2 = (-b - Math.pow(result, 0.5)) / (2.0 * a);

                x1Out.setText("x1 = " + r1);
                x2Out.setText("x2 = " + r2);

            } else if (result == 0.0) {
                double r1 = -b / (2.0 * a);
                x1Out.setText("x1 = x2 = " + r1);
                x2Out.setText("");
            } else {
                error.setText("Nem oldható meg a valós számok halmazán.");
            }
        }
    }
}