package co.com.sofka.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Calculator {
    private String cadena = null;

    public Calculator(){

    }

    public Calculator(String cadena) {
        Objects.requireNonNull(cadena);
        this.cadena = cadena;
    }

    private List<Integer> validateNumbers(String numeros, String delimiter){

        //System.out.println(numeros + " " + delimiter);
        //System.out.println(numeros.split(delimiter, 0)[0]);

        List<Integer> validatedNumbers = Arrays
                .stream(numeros.split(delimiter, 0))
                .map(string -> Integer.parseInt(string))
                .filter(number -> number < 1000)
                .collect(Collectors.toList());

        if(validatedNumbers.stream().anyMatch(numero -> numero < 0)){
            throw new IllegalArgumentException("_ERROR: Numero negativo no valido");
        }

        return validatedNumbers;
    }

    private int validateChar(String cadena){
        Integer resultado = 0;


        String[] caracteres = {",", " ", "#", "/", "\n"};

        for(String charLy: caracteres){
            if(cadena.contains(charLy)){
                var listNumbers = validateNumbers(cadena, charLy);

                // resultado = (listNumbers.size() == 1) ? listNumbers.get(0) :
                //        (listNumbers.size() == 2) ? addTwoNumbers(listNumbers.get(0), listNumbers.get(1)):
                //                addThreeNumbers(listNumbers.get(0), listNumbers.get(1), listNumbers.get(2));

                if(listNumbers.size() == 1) resultado = listNumbers.get(0);

                if(listNumbers.size() == 2) resultado = addTwoNumbers(listNumbers.get(0), listNumbers.get(1));

                if(listNumbers.size() == 3) resultado = addThreeNumbers(listNumbers.get(0), listNumbers.get(1), listNumbers.get(2));
            }
        }
        return resultado;
    }


    public int add(String cadena){

        //System.out.println("esta e suna pruieba");

        return validateChar(cadena);
    }

    public Integer addThreeNumbers(Integer num1, Integer num2, Integer num3){
        return num1 + num2 + num3;
    }

    public Integer addTwoNumbers(Integer num1, Integer num2){
        return num1 + num2;
    }


}
