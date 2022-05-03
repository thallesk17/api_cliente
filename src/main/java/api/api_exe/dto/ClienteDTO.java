package api.api_exe.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    Long id;
    String cpf;
    String nome;
    String sexo;  
    Date data_nascimento; 
}
