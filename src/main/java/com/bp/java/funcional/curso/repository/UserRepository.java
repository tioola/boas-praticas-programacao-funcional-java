package com.bp.java.funcional.curso.repository;

import com.bp.java.funcional.curso.dtos.UserDto;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class UserRepository {

    private static Gson GSON = new Gson();

    public static UserDto getUserById(Integer id){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(String.format("https://reqres.in/api/users/%s",id)).openStream()));) {

            String jsonUser = reader.readLine().lines()
                    .collect(Collectors.joining("\n"));

            return GSON.fromJson(jsonUser, UserDto.class);
        }catch (IOException ex){
            throw new IllegalArgumentException(String.format("Could not call the api %s", ex.getMessage(), ex));
        }
    }

}
