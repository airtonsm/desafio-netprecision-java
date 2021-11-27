import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class Exercicio2 {

    public static void main(String[] args) {

        Gson gson = new Gson();

        Map<String, List<Prato>> mapCardapio = new HashMap<>();

        Prato p1 = Prato.builder()
                .nome("Bacon fries")
                .price(22.70)
                .ingredientes(Arrays.asList("Bacon", "Batata frita", "cheddar"))
                .build();

        Prato p2 = Prato.builder()
                .nome("Spaghetti kids")
                .price(13.20)
                .ingredientes(Arrays.asList("Tomate", "Macarrão", "Orégano"))
                .build();

        Prato p3 = Prato.builder()
                .nome("Mini pastel")
                .price(10.90)
                .ingredientes(Arrays.asList("Mussarela", "Carne"))
                .build();

        Prato p4 = Prato.builder()
                .nome("X-Burguer")
                .price(14.80)
                .ingredientes(Arrays.asList("Pão", "Hamburguer", "Queijo"))
                .build();

        Prato p5 = Prato.builder()
                .nome("Parmeggiana de Frango")
                .price(5.90)
                .ingredientes(Arrays.asList("Tomate", "Frango", "Arroz", "Batata", "frita"))
                .build();

        Prato p6 = Prato.builder()
                .nome("X-Egg")
                .price(16.70)
                .ingredientes(Arrays.asList("Pão", "Alface", "Ovo", "Picles", "frita", "Tomate", "Cebola"))
                .build();

        Prato p7 = Prato.builder()
                .nome("Feijão com Calabresa")
                .price(21.10)
                .ingredientes(Arrays.asList("Feijão", "Pimenta", "Calabresa","Vinagrete,"))
                .build();

        mapCardapio.put("executivo", Arrays.asList(p5,p7));
        mapCardapio.put("Kid", List.of(p2));
        mapCardapio.put("Aperitivos", Arrays.asList(p1,p3));
        mapCardapio.put("Sanduíches", Arrays.asList(p4,p6));


//        for (String chave : mapCardapio.keySet()) {
//            System.out.println();
//                System.out.println("Categoria: " + chave);
//            for (Prato p: mapCardapio.get(chave)) {
//                System.out.println(p.infoPrato());
//            }
//        }


//        mapCardapio.forEach((chave, prato) -> {
//            System.out.println();
//            System.out.println(gson.toJson(chave));
//            prato.forEach(p -> {
//                System.out.println(gson.toJson(p.infoPrato()));
//            });
//        });

    }

}
