package com.bp.java.funcional.curso.utils;

import com.bp.java.funcional.curso.domain.Product;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class FullStringUpperCaseMatcher extends BaseMatcher {

    @Override
    public boolean matches(Object item) {
        if(!(item instanceof String)){
            return false;
        }
        String productDescription = (String) item;
        return !containsLowerCaseCharacter(productDescription);
    }

    private FullStringUpperCaseMatcher() {
    }

    public static FullStringUpperCaseMatcher isFullUpperCase(){
        return new FullStringUpperCaseMatcher();
    }

    private boolean containsLowerCaseCharacter(String productDescription){
       return productDescription.chars().anyMatch(character -> Character.isAlphabetic(character) &&
               Character.isLowerCase(character));
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Text should be uppercase");
    }
}
