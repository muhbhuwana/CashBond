/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashbond;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import static javax.management.Query.value;

/**
 *
 * @author MuhammadBhuwana
 */
public class DataSiswa {
    private final StringProperty absencol;
    private final StringProperty namacol;
    private final StringProperty saldocol;
    private final StringProperty ttl;
    private final StringProperty tempatcol;
    private final StringProperty jk;
    private final StringProperty alamatcol;
        public DataSiswa(String absen, String nama, String tgl, String saldo,String tempat,String jenis,String alamat) {
        this.absencol = new SimpleStringProperty(absen);
        this.namacol = new SimpleStringProperty(nama);
        this.saldocol = new SimpleStringProperty(saldo);
        this.ttl = new SimpleStringProperty(tgl);
        this.tempatcol = new SimpleStringProperty(tempat);
        this.jk = new SimpleStringProperty(jenis);
        this.alamatcol = new SimpleStringProperty(alamat);
}

    DataSiswa(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        public String getAbsen(){
            return absencol.get();
        }
        public String getNama(){
        return namacol.get();
        }
        public String getSaldo(){
        return saldocol.get();
        }
        public String getTgl(){
        return ttl.get();
        }     
        public String getTempat(){
        return tempatcol.get();
        }
        public String getJk(){
        return jk.getValue();
        }
        public String getAlamat(){
        return alamatcol.get();
        }
        public void setAbsen(String value){
            absencol.set(value);
        }
        public void setNama(String value){
         namacol.set(value);
        }
        public void setSaldo(String value){
        saldocol.set(value);
        }
        public void setTgl(String value){
        this.ttl.set(value);
        }        
        public void setTempat(String value){
        tempatcol.set(value);
        }
        public void setJk(String value){
        jk.set(value);
        }
         public void setAlamat(String value){
        alamatcol.set(value);
        }
        public StringProperty absenProperty() {
        return absencol;
        }
        public StringProperty namaProperty() {
        return namacol;
        }
        public StringProperty saldoProperty() {
        return saldocol;
        }
        public StringProperty tglProperty() {
        return ttl;
        }
        public StringProperty tempatProperty() {
        return tempatcol;
        }
        public StringProperty jenisProperty() {
        return jk;
        }
        public StringProperty alamatProperty() {
        return alamatcol;
        }
    Object getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}