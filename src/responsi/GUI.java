/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */

public class GUI extends JFrame{
    JLabel labelid = new JLabel("ID");
    JLabel labelbarang = new JLabel("Nama Barang");
    JLabel labelkasir = new JLabel("Nama Kasir");
    JLabel labelqty = new JLabel("QTY");
    JLabel labelprice = new JLabel("Harga");
    JLabel labeldiskon = new JLabel("Diskon (%)");
    
    public JTextField id = new JTextField();
    public JTextField namabarang = new JTextField();
    public JTextField namakasir = new JTextField();
    public JTextField qty = new JTextField();
    public JTextField price = new JTextField();
    public JTextField diskon = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel DTM;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"ID", "Nama Barang", "Nama Kasir", "Quantity", "Harga Satuan","Diskon","Harga Total"};

    public GUI() {
        DTM = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(DTM);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Transactions");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(800,600);
        
        add(scrollPane);
        scrollPane.setBounds(100,20,600,300);
        
        add(labelid);
        labelid.setBounds(300,330,90,20);
        add(id);
        id.setBounds(160,330,120,20);
        
        add(labelbarang);
        labelbarang.setBounds(300,370,90,20);
        add(namabarang);
        namabarang.setBounds(160,370,120,20);
        
        add(labelkasir);
        labelkasir.setBounds(300,410,90,20);
        add(namakasir);
        namakasir.setBounds(160,410,120,20);
        
        add(labelqty);
        labelqty.setBounds(580,330,90,20);
        add(qty);
        qty.setBounds(440,330,120,20);

        add(labelprice);
        labelprice.setBounds(580,370,90,20);
        add(price);
        price.setBounds(440,370,120,20);

        add(labeldiskon);
        labeldiskon.setBounds(580,410,90,20);
        add(diskon);
        diskon.setBounds(440,410,120,20);

        //button
        add(btnTambah);
        btnTambah.setBounds(200, 460, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(300, 460, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(400, 460, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(500, 460, 90, 20);
    }
    
    public String getId(){

        return id.getText();
    }
    
    public String getnb(){

        return namabarang.getText();
    }
    
    public String getnk(){

        return namakasir.getText();
    }
    
    public String getqty(){
        return qty.getText();
    }

    public String gethrg(){
        return price.getText();
    }

    public String getdiskon(){
        return diskon.getText();
    }
}
