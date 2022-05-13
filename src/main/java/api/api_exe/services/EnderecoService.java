package api.api_exe.services;

import api.api_exe.dto.ResponseDto;
import api.api_exe.entities.Endereco;
import api.api_exe.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import api.api_exe.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EnderecoService {


    @Autowired
    private ResponseDto responseDto;

    EnderecoRepository enderecoRepository;

    public ResponseDto saveEndereco(Endereco endereco) {
        responseDto.setId(enderecoRepository.save(endereco).getId());
        responseDto.setMenssage("Endereco incluído com sucesso...");
        responseDto.setStatus(Status.SUCCESS.value());
        return responseDto;
    }
}