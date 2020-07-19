package com.bp.java.funcional.curso.modulo04;

import com.bp.java.funcional.curso.domain.FileSystemProduct;
import com.bp.java.funcional.curso.domain.Product;
import com.bp.java.funcional.curso.repository.ProductRepository;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FIlesApi {

    private static final String ROOT_FOLDER = "/home/curso-programacao-funcional/products";

    @Test
    public void testSalvarModeloImperativo() {
        List<Product> products = ProductRepository.getProducts();
        for (Product product : products) {

            File fileToSave = new File(ROOT_FOLDER + File.separator + product.getId() + ".json");

            if(fileToSave.exists()) break;

            try(PrintStream out = new PrintStream(new FileOutputStream(fileToSave))) {
                out.print(product.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSalvarModoDeclarativo() {

        ProductRepository.getProducts()
                .stream()
                .map(product -> FileSystemProduct.from(product, ROOT_FOLDER))
                .forEach(FileSystemProduct::safeSaveIfNotSaved);

    }

    @Test
    public void listArquivosModoImperativo() {
        File folder = new File(ROOT_FOLDER);
        File[] files = folder.listFiles();

        for (File file : files) {
            if(file.isFile()){
                System.out.println("File: " + file.getName());
            }
        }
    }

    @Test
    public void listarArquivosDeclarativa() throws IOException {

        Files.list(Path.of(ROOT_FOLDER))
                .filter(Files::isRegularFile)
                .map(path -> path.getFileName().toString())
                .forEach(System.out::println);

    }

    @Test
    public void listerArquivosDiretoriosGrandes() throws IOException {
        Files.newDirectoryStream(Path.of(ROOT_FOLDER), path -> path.toString().endsWith(".json"))
                .forEach(System.out::println);
    }

    @Test
    public void escutarMudancasDiretorio() throws IOException, InterruptedException {

        Path rootFolder = Path.of(ROOT_FOLDER);

        WatchService watchService = rootFolder.getFileSystem().newWatchService();

        rootFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        System.out.println("Escutando...");

        WatchKey watchKey = watchService.poll(10, TimeUnit.MINUTES);

        watchKey.pollEvents()
                .stream()
                .forEach(watchEvent -> System.out.println(watchEvent.context()));
    }
}
