/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashbond;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MuhammadBhuwana
 */
public class CashBondController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private JFXTextField username;
    String Username;
    @FXML
    private JFXPasswordField password;
    String Password;
    @FXML
    private JFXButton login;
    public String user="admin";
    public String pass="admin";

    /**
     * Initializes+ the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void proseslogin(ActionEvent event) {
        Username=username.getText();
        Password=password.getText();
         if(Username.equalsIgnoreCase(user) && Password.equalsIgnoreCase(pass)){
        try {
            JOptionPane.showMessageDialog(null, "Anda Berhasil Login");
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("CashBond");
            stage.show();
            } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal Login");;
        }
         }
        else if (Username.equals(""))
        {JOptionPane.showMessageDialog(null, "Mohon Isi Username Anda");}
        else if (Password.equals(""))
        {JOptionPane.showMessageDialog(null, "Mohon Isi Password Anda");}
        else {JOptionPane.showMessageDialog(null, "Username dan Password Anda Salah");
        }
  }
}