package controllers;

import javafx.scene.paint.Color;
import javafx.scene.text.*;

import java.util.ArrayList;

public class ValidationChecker {

    private static final int minLength = 3;
    private static final int maxLength = 20;

    private TextFlow textFlow;
    private int[] tab;


    public void checkRegisterValidation(String text,int index){
        textFlow.getChildren().clear();

        if ( lengthCheck(text) && characterCheck(text))
            tab[index]=1;
        else
            tab[index]=0;

    }

    public void checkRegisterEmailValidation(String text,int index){
        textFlow.getChildren().clear();

        lengthCheck(text);
        characterEmailCheck(text);
        if (lengthCheck(text) && characterEmailCheck(text))
            tab[index]=1;
        else
            tab[index]=0;
    }

    public void checkPasswordsValidation(String passsword,String confirmPassword,int index){
        textFlow.getChildren().clear();


        if ( lengthCheck(passsword) && characterCheck(passsword) && equalsCheck(passsword,confirmPassword)) {
            tab[index] = 1;
            tab[index+1] = 1;
        }else {
            tab[index] = 0;
            tab[index+1] = 0;
        }
    }

    public boolean characterCheck(String text){
        if(text.length() >= 3) {
            Text characterText = null;
            for (int i = 0; i < text.length(); i++) {
                if ((text.charAt(i) >= '0' && text.charAt(i) <= '9') || (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') || (text.charAt(i) >= 'a' && text.charAt(i) <= 'z')) {
                    characterText = new Text("Character correctly\n");
                    characterText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                    characterText.setFill(Color.GREEN);


                } else {
                    characterText = new Text("Incorrect character\n");
                    characterText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                    characterText.setFill(Color.RED);
                    textFlow.getChildren().add(characterText);
                    return false;
                }
            }
            textFlow.getChildren().add(characterText);
            return true;
        }
        return false;
    }

    public boolean characterEmailCheck(String text){
        if(text.length() >= 3) {
            Text characterText = null;
            for (int i = 0; i < text.length(); i++) {
                if ((text.charAt(i) >= '0' && text.charAt(i) <= '9') ||
                    (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') ||
                    (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') ||
                    text.charAt(i) == '@' ||
                    text.charAt(i) == '.') {

                    characterText = new Text("Character correctly\n");
                    characterText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                    characterText.setFill(Color.GREEN);

                } else {
                    characterText = new Text("Incorrect character\n");
                    characterText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                    characterText.setFill(Color.RED);
                    textFlow.getChildren().add(characterText);
                    return false;
                }
            }
            textFlow.getChildren().add(characterText);
            return true;

        }
        return false;
    }

    public boolean equalsCheck(String password, String confirmPassword){
        Text equalsText;
        if(password.equals(confirmPassword)){
            equalsText = new Text("Passwords equals\n");
            equalsText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            equalsText.setFill(Color.GREEN);
            textFlow.getChildren().add(equalsText);
            return true;
        }else{
            equalsText = new Text("Passwords different\n");
            equalsText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            equalsText.setFill(Color.RED);
            textFlow.getChildren().add(equalsText);
            return false;
        }

    }

    public boolean lengthCheck(String text){
        Text lengthText;

        if(text.length() >= minLength && text.length() <= maxLength) {
            lengthText = new Text("Length correctly\n");
            lengthText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            lengthText.setFill(Color.GREEN);
            textFlow.getChildren().add(lengthText);
            return true;
        }else {
            lengthText = new Text("Incorrect length\n");
            lengthText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            lengthText.setFill(Color.RED);
            textFlow.getChildren().add(lengthText);
            return false;
        }

    }

    public void setTextFlow(TextFlow textFlow) {
        this.textFlow = textFlow;
    }

    public void setTab(int[] tab) {
        this.tab = tab;
    }
}
