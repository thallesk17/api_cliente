package api.api_exe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    String cep;
    String rua;
    String uf;
    String cidade;
    String bairro;
    int numero; 
}