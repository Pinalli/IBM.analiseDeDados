package br.com.pinalli.analisedados.controller;

import br.com.pinalli.analisedados.model.Data;
import java.io.*;
import java.util.regex.Pattern;




public class Reader {

    BufferedReader file;
    String fileName;

    public Reader (String fileName) {
        this.fileName = fileName;
        try {
            file = new BufferedReader(new FileReader(new File(Watcher.pathToDir + "in/" + fileName)));
        } catch (FileNotFoundException e) {
            file = null;
        }
    }

    public void openFile() throws IOException {
        //  file.ready();
        file.close();
        try {
            file = new BufferedReader(new FileReader(new File(Watcher.pathToDir + fileName)));
        } catch (FileNotFoundException e) {
            file = null;
        }
    }


    public void closeFile() {
        try {
            file.close();
        } catch (IOException e) {

        }
    }

    public Data DataModel() {
        Data workData = new Data();
        String line;
        String[] data;

        try {
            while ((line = file.readLine()) != null) {
                data = line.split("ç");
                if (data[0].compareTo("001") == 0) {
                    workData.addSalesmen(data);
                } else if (data[0].compareTo("002") == 0) {
                    workData.addClient(data);
                } else if (data[0].compareTo("003") == 0) {
                    workData.addSale(data);
                }
            }
        } catch (IOException e) { }
        return workData;
    }

    public void Result(Data dataResult) {
        dataResult.computeMinMax();
        new File(Watcher.pathToDir + "out").mkdirs();
        try {
            FileWriter fw = new FileWriter(Watcher.pathToDir + "out/" + this.fileName.split(Pattern.quote("."))[0] + ".done.dat");

            fw.write("Relatório:\n");
            fw.write("Number of Salesmen: " + dataResult.getSalesmen().size() + "\n");
            fw.write("Number of Clients: "+ dataResult.getClients().size() + "\n");
            fw.write("Id of the best sale: " + dataResult.getMax().getId() + "\n");
            fw.write("The worst salesman: " + dataResult.getMin().getSalesman() + "\n");
            fw.close();
            System.out.println("Arquivo gerado com sucesso ~/data/out/" + this.fileName.split(Pattern.quote("."))[0] + ".done.dat");
        } catch (IOException e) {
            System.out.println("Falha ao gerar saída!");
        }
    }
}