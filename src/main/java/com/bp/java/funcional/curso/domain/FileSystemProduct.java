package com.bp.java.funcional.curso.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSystemProduct {

    private static final String FILE_SYSTEM_EXTENSION = "json";
    private Product product;
    private Path rootFolderPath;
    private Path filePath;

    private FileSystemProduct(Product product, Path rootFolderPath) {
        this.product = product;
        this.rootFolderPath = rootFolderPath;
        this.filePath = Path.of(rootFolderPath.normalize().toString(),
                                String.format("%s.%s", product.getId(), FILE_SYSTEM_EXTENSION));

    }

    public static FileSystemProduct from(Product product, String rootFolder){
        Path rootPath = Path.of(rootFolder);

        if(!Files.isDirectory(rootPath)){
            throw new IllegalArgumentException(String.format("Provided path %s is not a folder or do not exist", rootFolder));
        }

        return new FileSystemProduct(product, rootPath);
    }

    public boolean isSaved(){
        return Files.exists(filePath);
    }

    public void save() throws IOException {
        Files.write(filePath, product.toString().getBytes());
    }

    public void safeSaveIfNotSaved(){

        if(this.isSaved()) return;

        try {
            this.save();
        } catch (IOException e) {
            throw new IllegalArgumentException("File could not be saved",e);
        }
    }

}

