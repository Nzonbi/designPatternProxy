package pres;

import metier.IMetier;
import proxy.Proxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Client {
    private IMetier metier = new Proxy();
    public Client(){
        try {

            BufferedReader br = new BufferedReader(new FileReader(new File("config.txt")));
            String className = br.readLine();
            metier = (IMetier) Class.forName(className).newInstance();
            System.out.println(metier.cacul());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
