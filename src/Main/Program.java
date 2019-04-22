/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

    

public class Program {
    
    Dictionary d = new Dictionary();
    GUI gui = new GUI();
    
    private void exportDictionary()
    {
        this.gui.importDictionary(d);
    }
    
    public static void main(String args[]) {
        Program m = new Program();        
        m.exportDictionary();
    }
}
