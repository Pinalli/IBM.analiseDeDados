package br.com.pinalli.analisedados.main;

import br.com.pinalli.analisedados.controller.Reader;
import br.com.pinalli.analisedados.controller.Watcher;
import  br.com.pinalli.analisedados.model.Data;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
    	
    	
        Data workData = new Data();

        Watcher watcher = new Watcher();
        ArrayList<String> files;
        while (true) {
            files = watcher.waitForFiles();

            for (String fileName : files) {
                System.out.println("Arquivo encontrado " + fileName);
                Reader rd = new Reader(fileName);
                workData = rd.DataModel();
                rd.closeFile();
                rd.Result(workData);
            }

        }
    }
}
