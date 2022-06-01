/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author ASUS
 */
public class Controller {
    Model modelData;
    GUI DataGui;
    public String data;
    
    public Controller(Model modelData, GUI DataGui){
        this.modelData = modelData;
        this.DataGui = DataGui;
        
        if (modelData.getBanyakData()!=0) {
            String GuiData[][] = modelData.readData();
            DataGui.tabel.setModel((new JTable(GuiData, DataGui.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersedia");
        }
        
         DataGui.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String ID = DataGui.getId();
                String Barang = DataGui.getnb();
                String Kasir = DataGui.getnk();
                int Qty = Integer.parseInt(DataGui.getqty());
                double Harga = Double.parseDouble(DataGui.gethrg());
                double Diskon = Double.parseDouble(DataGui.getdiskon());
                double Total = ((100-Diskon)/100*(Harga*Qty));

                modelData.insertData(ID, Barang, Kasir, Qty, Harga, Diskon, Total);
         
                String GuiData[][] = modelData.readData();
                DataGui.tabel.setModel((new JTable(GuiData, DataGui.namaKolom)).getModel());
            }
        });
         
          DataGui.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String ID = DataGui.getId();
                String Barang = DataGui.getnb();
                String Kasir = DataGui.getnk();
                int Qty = Integer.parseInt(DataGui.getqty());
                double Harga = Double.parseDouble(DataGui.gethrg());
                double Diskon = Double.parseDouble(DataGui.getdiskon());
                double Total = ((100-Diskon)/100*(Harga*Qty));

                modelData.updateData(ID, Barang, Kasir, Qty, Harga, Diskon, Total);

                String GuiData[][] = modelData.readData();
                DataGui.tabel.setModel((new JTable(GuiData, DataGui.namaKolom)).getModel());
            }
        });
         
          DataGui.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                DataGui.id.setText("");
                DataGui.namabarang.setText("");
                DataGui.namakasir.setText("");
                DataGui.qty.setText("");
                DataGui.price.setText("");
                DataGui.diskon.setText("");
            }
        });
        
    
          DataGui.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = DataGui.tabel.getSelectedRow();
                data = DataGui.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[7];
                dataUpdate[0] = DataGui.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = DataGui.tabel.getValueAt(baris, 1).toString();
                dataUpdate[2] = DataGui.tabel.getValueAt(baris, 2).toString();
                dataUpdate[3] = DataGui.tabel.getValueAt(baris, 3).toString();
                dataUpdate[4] = DataGui.tabel.getValueAt(baris, 4).toString();
                dataUpdate[5] = DataGui.tabel.getValueAt(baris, 5).toString();
                dataUpdate[6] = DataGui.tabel.getValueAt(baris, 6).toString();
                
                System.out.println(data);
                 
                
                
            }
           });
                  
          DataGui.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Anda yakin akan menghapus ID " + data + "?", "Opsi...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                modelData.deleteData(data);
                String GuiData[][] = modelData.readData();
                DataGui.tabel.setModel((new JTable(GuiData, DataGui.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });

    }
}
