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
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MuhammadBhuwana
 */
public class UpdateSiswaController implements Initializable {

    @FXML
    private JFXTextField absen;
    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField alamat;
    @FXML
    private JFXTextField tempat;
    @FXML
    private JFXComboBox<String> kelamin;
    
    ObservableList<String>  Kelamin = FXCollections.observableArrayList(
                    "Laki - Laki",
                    "Perempuan");
    private Config dc;
    
    private String cari;
    
    private ObservableList<DataSiswa> data;
    /**
     * Initializes the controller class.
     */
    
    public static final LocalDate LOCAL_DATE (String dateString){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
}
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXTextField kas;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         String Default = "Jenis Kelamin";
        kelamin.setValue(Default);
        kelamin.setItems(Kelamin);
    } 
    @FXML
    private void prosestambah(ActionEvent event) throws IOException {
{
         if(absen.getText().equals("")||nama.getText().equals("")||kas.getText().equals("")||tempat.getText().equals("")
            ||date.getValue().equals("")||kelamin.getValue().equals("Jenis Kelamin")){
            JOptionPane.showMessageDialog(null, "Lengkapi data yang tertera");
        }
        else{
        try {
            String sql = "UPDATE siswa SET Absen = '"+absen.getText()+"', "
                    + "Nama = '"+nama.getText()+"',Saldo = '"+kas.getText()+"', "
                    + "tanggal = '"+date.getValue()+"',`jk` = '"+kelamin.getValue()+"',"
                    + " tempat = '"+tempat.getText()+"',alamat = '"+alamat.getText()+"' "
                    + "WHERE Absen='"+absen.getText()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Menu.fxml"));
            
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("CashBond");
            stage.show();

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Gagal");
            }
        }
    }
}
    void setdata(String noabsen) {
        absen.setText(noabsen);
                       try {
            java.sql.Connection con = dc.configDB();
            data = FXCollections.observableArrayList();
            String hasil = "SELECT * FROM `siswa` WHERE Absen='"+noabsen+"'";
            ResultSet rs = con.createStatement().executeQuery(hasil);

            while (rs.next()) {
               String bNama = rs.getString("nama");
               String btempat = rs.getString("tempat");
               String balamat = rs.getString("alamat");
               String bsaldo = rs.getString("saldo");
               String btgl = rs.getString("tanggal");
                nama.setText(bNama);
                tempat.setText(btempat);
                date.setValue(LOCAL_DATE(btgl));
                alamat.setText(balamat);
                kas.setText(bsaldo);
            }

        } catch (SQLException ex) {
           System.out.println("Erorr"+ex);
           
        }    
    }

    @FXML
    private void hapus(ActionEvent event) throws IOException {
                    ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Menu.fxml"));
            
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("CashBond");
            stage.show();
    }
}
