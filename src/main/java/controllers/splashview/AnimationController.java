package controllers.splashview;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class AnimationController {

    private final int speedOfAnimation = 1000;

    private SplashViewController nodes;



    public void showInfoLabel(Node node,int duration){
        Thread thread = new Thread(() -> {
            try {


                node.setVisible(true);
                Thread.sleep(duration);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            node.setVisible(false);
        });
        thread.start();
    }

    public void showInfoLabelWithMove(Node node,int duration){
        Thread thread = new Thread(() -> {
            try {

                changeView(0,880);

                Thread.sleep(speedOfAnimation);
                node.setVisible(true);
                Thread.sleep(duration);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            node.setVisible(false);
        });
        thread.start();
    }

    public void changeView(int positionScene, int positionScene2) {
        Thread thread = new Thread(() -> {
            try {
                slideAnimation(nodes.changeViewLayer,positionScene);
                slideAnimation(nodes.logInAndSignInLayer,positionScene2);

                Thread.sleep(speedOfAnimation);

                if (positionScene == 0) {
                    disableNodesSignUp();
                    nodes.validationChecker.resetTextFields();
                }else
                    disableNodesSignIn();


                slideAnimation(nodes.logInAndSignInLayer,0);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public void slideAnimation(Node layer,int position){
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(1));
        slide.setNode(layer);
        slide.setToX(position);
        slide.play();
    }

    public void disableNodesSignIn(){

        nodes.signInBtn.setVisible(true);
        nodes.signInLabel.setVisible(false);
        nodes.nicknameSiTF.setVisible(false);
        nodes.passwordSiPF.setVisible(false);
        nodes.signInIcon.setVisible(false);
        nodes.wrongLogInDataLabel.setVisible(false);

        nodes.signUpBtn.setVisible(false);
        nodes.nicknameSuTF.setVisible(true);
        nodes.firstnameSuTF.setVisible(true);
        nodes.emailSuTF.setVisible(true);
        nodes.lastnameSuTF.setVisible(true);
        nodes.passwordSuPF.setVisible(true);
        nodes.confirmPasswordSuPF.setVisible(true);
        nodes.signUpIcon.setVisible(true);
        nodes.signUpLabel.setVisible(true);

    }

    public void disableNodesSignUp(){
        nodes.signInBtn.setVisible(false);
        nodes.nicknameSuTF.setVisible(false);
        nodes.firstnameSuTF.setVisible(false);
        nodes.emailSuTF.setVisible(false);
        nodes.lastnameSuTF.setVisible(false);
        nodes.passwordSuPF.setVisible(false);
        nodes.confirmPasswordSuPF.setVisible(false);
        nodes.signUpIcon.setVisible(false);
        nodes.signUpLabel.setVisible(false);
        nodes.userExistInDataBaseLabel.setVisible(false);

        nodes.signInLabel.setVisible(true);
        nodes.nicknameSiTF.setVisible(true);
        nodes.passwordSiPF.setVisible(true);
        nodes.signInIcon.setVisible(true);
        nodes.signUpBtn.setVisible(true);
    }
    
    public void setNodes(SplashViewController nodes) {
        this.nodes = nodes;
    }
}
