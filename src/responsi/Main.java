/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

/**
 *
 * @author ASUS
 */
public class Main {


    public static void main(String[] args) {
        // TODO code application logic here
        GUI gui = new GUI();
        Model model = new Model();
        Controller controller = new Controller(model, gui);
    }
    
}