package com.bp.java.funcional.curso.modulo05;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExceptionHandling {

    @Test(expected = IllegalArgumentException.class)
    public void lendoDiretorioELidandoComExcecao() {

        Stream.of("/home/curso-programacao-funcional/products/1.json",
                  "/home/curso-programacao-funcional/products/150.json")
                .map(filePath -> Path.of(filePath))
                .map(path -> {
                    try {
                        return Files.readAllLines(path)
                                .stream()
                                .collect(Collectors.joining("\n"));
                    } catch (IOException e) {
                        throw new IllegalArgumentException(
                                String.format("File could not be read %s",path),e);
                    }

                }).collect(Collectors.toList());

    }


    @Test
    public void lendoDiretorioSemExcecao() {

        List<String> collect = Stream.of("/home/curso-programacao-funcional/products/1.json",
                "/home/curso-programacao-funcional/products/150.json")
                .map(filePath -> Path.of(filePath))
                .map(path -> {
                    try {
                        return Files.readAllLines(path)
                                .stream()
                                .collect(Collectors.joining("\n"));
                    } catch (IOException e) {
                        return String.format("File could not be read %s", path);
                    }

                }).collect(Collectors.toList());

        System.out.println(collect.get(1));
    }

    @Test
    public void testandoFuncaoComExcecao() {


        List<String> collect = Stream.of("/home/curso-programacao-funcional/products/1.json",
                "/home/curso-programacao-funcional/products/150.json")
                .map(stringPath ->
                    mapPathToContent(stringPath, path -> Files.readAllLines(path)
                            .stream()
                            .collect(Collectors.joining("\n")))
                ).collect(Collectors.toList());

    }

    private String mapPathToContent(String stringFilePath, MapFileContent mapFunction){

        try {
            return mapFunction.mapPathToContent(Path.of(stringFilePath));
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    String.format("File could not be read %s",stringFilePath),e);
        }
    }
}


@FunctionalInterface
interface MapFileContent{

    String mapPathToContent(Path path) throws IOException;

}