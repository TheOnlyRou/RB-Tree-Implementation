package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Dictionary {
    
    private File f;
    
    public void importFile(File f) throws IOException
    {
        this.f = f;
        printFile();
    }
    
    private void printFile() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(this.f)); 
        String st; 
        while ((st = br.readLine()) != null) 
            System.out.println(st); 
    }
    
    
    
}
