/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashbond;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author MuhammadBhuwana
 */
public class LihatSiswaController implements Initializable {

    @FXML
    private TableColumn<DataSiswa, String> absencol;  
    @FXML
    private TableColumn<DataSiswa, String> namacol;
    @FXML
    private TableColumn<DataSiswa, String> saldocol;
    @FXML
    private TableColumn<DataSiswa, String> ttl;
    @FXML
    private TableView<DataSiswa> table;
    @FXML
    private TableColumn<DataSiswa, String> tempatcol;
    @FXML
    private TableColumn<DataSiswa, String> jk;
    @FXML
    private TableColumn<DataSiswa, String> alamatcol;
    
    @FXML
    private JFXHamburger krabby;
    
    @FXML
    private JFXDrawer drawer;

    private Config dc;
    private ObservableList<DataSiswa> data;
    
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
                       try {
            java.sql.Connection con = dc.configDB();
            data = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `siswa`");
            while (rs.next()) {
                data.add(new DataSiswa(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(3), rs.getString(6), rs.getString(5), rs.getString(7)));
            }
        } catch (SQLException ex) {
           System.out.println("Erorr"+ex);
           
        }
        absencol.setCellValueFactory(new PropertyValueFactory<>("absen"));
        namacol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        saldocol.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        ttl.setCellValueFactory(new PropertyValueFactory<>("tgl"));
        tempatcol.setCellValueFactory(new PropertyValueFactory<>("tempat"));
        jk.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        alamatcol.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        
        table.setItems(null);
        table.setItems(data);
    }     
}