/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclickerfx;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 *
 * @author alex
 */
public class ClickerController {
    
    public TextField hourField,minField,secField;
    
    public void startButtonAction() {
        int hour,min,sec;
      try{
        hour = Integer.parseInt(hourField.getText());
        min = Integer.parseInt(minField.getText());
        sec = Integer.parseInt(secField.getText());
      }catch(NumberFormatException e){
          e.getMessage();
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Attention!");
          alert.setHeaderText("");
          alert.setContentText("Enter correct values in all fields!");
          alert.showAndWait();
          return;
      }
        Calendar calendar = Calendar.getInstance();
calendar.set(Calendar.HOUR_OF_DAY, hour);
calendar.set(Calendar.MINUTE, min);
calendar.set(Calendar.SECOND, sec);

Date clickedTime = calendar.getTime();

Timer timer = new Timer();
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        try {
            Robot robot = new Robot();
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            timer.cancel();
        } catch (AWTException ex) {
            ex.getMessage();
        }
    }
}, clickedTime);
}
}
