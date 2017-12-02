/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashbond;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.awt.Label;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javax.swing.Action;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author MuhammadBhuwana
 */
public class MenuController implements Initializable {

    @FXML
    private javafx.scene.control.Label label;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    JFXTextField cariabsen;
    
    @FXML
    private JFXTextField absencol;
    
    @FXML
    private JFXTextField namatext;
    

    @FXML
    private JFXTextField saldotext;

    @FXML
    private JFXHamburger krabby;

    @FXML
    private JFXDrawer drawer;

    
    private Config dc;
    private ObservableList<DataSiswa> data;
    
    @FXML
    void cari(ActionEvent event) {
        Boolean flag = false;
                 if(cariabsen.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mohon Isi Nomer Absen");
        }
        else{
        try {
            java.sql.Connection con = dc.configDB();
            data = FXCollections.observableArrayList();
            String absen2 = cariabsen.getText();
            String hasil = "SELECT * FROM `siswa` WHERE Absen='"+absen2+"'";
            ResultSet rs = con.createStatement().executeQuery(hasil);

            while (rs.next()) {
               String bAbsen = rs.getString("absen");
               String bNama = rs.getString("nama");
               String bsaldo = rs.getString("saldo");
                absencol.setText(bAbsen);
                namatext.setText(bNama);
                saldotext.setText(bsaldo);
                flag = true;
            }
            if(!flag){
            JOptionPane.showMessageDialog(null, "Siswa Belum Terdaftar");};
        } catch (SQLException ex) {
           System.out.println("Erorr"+ex);    }     
        }
    }
    @FXML
    void tambah(ActionEvent event) {
        if(cariabsen.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Mohon Cari Data Dahulu");}
        else{
            int kas = 2000;
            int kas2 = Integer.parseInt(saldotext.getText());
            int kastotal= kas2+kas;   
            String total = String.valueOf(kastotal);
            saldotext.setText(total);
        }
    }
    @FXML
    public void update(ActionEvent event) {
        if(cariabsen.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Mohon Isi Nomer Absen");}
        else{
        try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("UpdateSiswa.fxml"));
            
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("CashBond");
            stage.show();
            
            UpdateSiswaController Data = new UpdateSiswaController();
            Data = fxmlLoader.getController();
            String absen2 = cariabsen.getText();
            Data.setdata(absen2);
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
        }
    }

    @FXML
    private void simpan(ActionEvent event) {
                if(cariabsen.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Mohon Cari Data Dahulu");}
        else{
                try {
            java.sql.Connection con = dc.configDB();
            data = FXCollections.observableArrayList();
            String absen2 = cariabsen.getText();
            String hasil = "UPDATE siswa SET Saldo = '"+saldotext.getText()+"' WHERE Absen='"+cariabsen.getText()+"'";
            java.sql.PreparedStatement pst=con.prepareStatement(hasil);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sukses Membayar Kas");

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Gagal Membayar Kas");
            }  
        }
    }

    @FXML
    private void hapus(ActionEvent event) {
                if(cariabsen.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Mohon Cari Data Dahulu");}
        else{
            try {
            java.sql.Connection con = dc.configDB();
            data = FXCollections.observableArrayList();
            String hasil = "DELETE FROM siswa WHERE Absen='"+cariabsen.getText()+"'";
            java.sql.PreparedStatement pst=con.prepareStatement(hasil);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sukses Menghapus Siswa");
            cariabsen.setText("");
            absencol.setText("");
            namatext.setText("");
             saldotext.setText("");
            } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Gagal Menghapus Siswa");
            }
        }  
    }
}