/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashbond;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MuhammadBhuwana
 */
public class TambahSiswaController implements Initializable {

 @FXML
    private JFXTextField absen;


    @FXML
    private JFXDatePicker tgl;

    @FXML
    private JFXTextField nama;

    @FXML
    private JFXTextField saldo;

    @FXML
    private JFXHamburger krabby;

    @FXML
    private JFXTextField alamat;


    @FXML
    private JFXTextField tempat;
    

    @FXML
    private JFXDrawer drawer;


   @FXML
    private JFXComboBox <String> kelamin;
    
    ObservableList<String>  Kelamin = FXCollections
            .observableArrayList(
                    "Laki - Laki",
                    "Perempuan");
    private Config dc;
    private ObservableList<DataSiswa> data;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String Default = "Jenis Kelamin";
        kelamin.setValue(Default);
        kelamin.setItems(Kelamin);
       try {
            AnchorPane box = FXMLLoader.load(getClass().getResource("ToolBar.fxml"));
            drawer.setSidePane(box);} catch (IOException ex) {
            }
       HamburgerBackArrowBasicTransition task1 = new HamburgerBackArrowBasicTransition(krabby);
        task1.setRate(-1);
       krabby.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            task1.setRate(task1.getRate()*-1);
            task1.play();
            drawer.setDisable(true);
            if(drawer.isShown())
            {
                drawer.close();
            }else{
                drawer.open();
                drawer.setDisable(false);}
        });   
    }    

    @FXML
    private void prosestambah(ActionEvent event) throws IOException {
         if(absen.getText().equals("")||nama.getText().equals("")
        ||saldo.getText().equals("")||tgl.getValue().equals("")||tempat.getText().equals("")
        ||alamat.getText().equals("")||kelamin.getItems().equals("Jenis Kelamin")){
            JOptionPane.showMessageDialog(null, "Mohon Isi Data yang Lengkap");
        }
         else if(absen.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mohon Isi Absen");
         }
                else if(saldo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mohon Isi Nama");
         }
                else if(saldo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mohon Isi Kas");
         }
                 else if(tgl.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Mohon Isi Tanggal Lahir");
         }
                else if(tempat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mohon Isi Tempat Lahir");
         }
                else if(alamat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mohon Isi Alamat");
         }
                else if(kelamin.getItems().equals("Jenis Kelamin")){
            JOptionPane.showMessageDialog(null, "Mohon Isi Jenis Kelamin");
         }
        else{
        try {
             String sql = "INSERT INTO siswa (`Absen`, `Nama`, `Saldo`, `tanggal`, `jk`,"
         + " `tempat`, `alamat`)VALUES("+absen.getText()+", '"+nama.getText()+"',"
         + " "+saldo.getText()+",'"+tgl.getValue()+"', '"+kelamin.getValue()+"', "
         + "'"+tempat.getText()+"', '"+alamat.getText()+"')";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
 }
    }
    @FXML
    private void proseshapus(ActionEvent event) {
        absen.setText("");
        nama.setText("");
        saldo.setText("");
        tempat.setText("");
        alamat.setText("");
    }
          
}
