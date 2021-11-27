import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Exercicio1 {

    public static void main(String[] args) {

        Prato p1 = Prato.builder()
                .nome("Parmeggiana de Frango")
                .price(5.90)
                .ingredientes(Arrays.asList("Tomate", "Frango", "Arroz", "Batata", "frita"))
                .build();

        Prato p2 = Prato.builder()
                .nome("X-Egg")
                .price(16.70)
                .ingredientes(Arrays.asList("Pão", "Alface", "Ovo", "Picles", "frita", "Tomate", "Cebola"))
                .build();

        Prato p3 = Prato.builder()
                .nome("Feijão com Calabresa")
                .price(21.10)
                .ingredientes(Arrays.asList("Feijão", "Pimenta", "Calabresa","Vinagrete,"))
                .build();

        Map<String,Prato> mapPratos = new HashMap<>();

        mapPratos.put("P-865", p1);
        mapPratos.put("P-990", p2);
        mapPratos.put("P-750", p3);

//        for (Map.Entry<String, Prato> pratos : mapPratos.entrySet()){
//            System.out.println("Chave: " + pratos.getKey() + ", " + pratos.getValue().infoPrato());
//        }

//        for(String p : mapPratos.keySet()){
//            System.out.println("chave: " + p + ", " + mapPratos.get(p).infoPrato());
//        }

//        System.out.println(mapPratos.get("P-865").infoPrato());
//        System.out.println(mapPratos.get("P-990").infoPrato());
//        System.out.println(mapPratos.get("P-750").infoPrato());

        mapPratos.forEach((chave, prato) -> System.out.println("Chave: " + chave + ", " + prato.infoPrato()));


    }

}
