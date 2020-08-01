package com.bp.java.funcional.curso.modulo05;

import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

public class LidandoComResources {

    private static final String ROOT_FOLDER = "/home/curso-programacao-funcional/products";

    @Test
    public void salvarArquivoComFinally() {

        Product product = ProductRepository.getById(17L);

        File fileToSave = new File(ROOT_FOLDER + File.separator + product.getId() + ".json");

        PrintStream printStream = null;
        try{
            printStream = new PrintStream(new FileOutputStream(fileToSave));
            printStream.print(product.toString());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            printStream.close();
        }

    }


    @Test
    public void salvarArquivoComAutoClosable() {

        Product product = ProductRepository.getById(17L);
        File fileToSave = new File(ROOT_FOLDER + File.separator + product.getId() + ".json");

        try(PrintStream printStream = new PrintStream(new FileOutputStream(fileToSave))){
            printStream.print(product.toString());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void salvarArquivoLambda() {

        Product product = ProductRepository.getById(17L);

        String path = ROOT_FOLDER + File.separator + product.getId() + ".json";

        FileWriterLambda
                .writeTo(path, fileWriter -> fileWriter.write(product.toString()));
    }
}

class FileWriterLambda {

    public static void writeTo(String filePath, IOWriter<FileWriter, IOException> writerFunction){
        try(FileWriter fileWriter = new FileWriter(filePath)){
            writerFunction.write(fileWriter);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}

@FunctionalInterface
interface IOWriter<T, X extends Throwable> {
    void write(T instance) throws X;
}