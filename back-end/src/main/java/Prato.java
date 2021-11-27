import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prato {

    String nome;
    Double price;
    List<String>  ingredientes;

    public String infoPrato(){
        return "Nome do prato: " + getNome()
                + " ,Preço: " + getPrice()
                + " ,Ingredientes: " + ingredientes;
    }

}
