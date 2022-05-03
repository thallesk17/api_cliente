package api.api_exe.services;

import java.util.List;
import java.util.stream.Collectors;
import api.api_exe.dto.ResponseDto;
import api.api_exe.dto.ClienteDTO;
import api.api_exe.entities.Cliente;
import api.api_exe.enums.Status;
import api.api_exe.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    ClienteRepository clienteRepository;

    public ResponseDto saveCliente(Cliente cliente) {
        responseDto.setId(clienteRepository.save(cliente).getId());
        responseDto.setMenssage("Cliente incluído com sucesso...");
        responseDto.setStatus(Status.SUCCESS.value());
        return responseDto;
    }

    public List<ClienteDTO> getAllCliente() {
        List<ClienteDTO> listAllClienteDTO = clienteRepository.findAll().stream()
                .map(Cliente -> modelMapper.map(Cliente, ClienteDTO.class))
                .collect(Collectors.toList());
        return listAllClienteDTO;
    }

    public List<ClienteDTO> getAllClienteOrderByName() {
        List<ClienteDTO> listAllClienteDTO = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome")).stream()
                .map(Cliente -> modelMapper.map(Cliente, ClienteDTO.class))
                .collect(Collectors.toList());
        return listAllClienteDTO;
    }

    public ClienteDTO getClienteById(Long id) {
        return modelMapper.map(clienteRepository.findById(id).get(), ClienteDTO.class);
    }

    public ResponseDto updateCliente(Cliente cliente) {
        responseDto.setId(clienteRepository.save(cliente).getId());
        if (cliente.getId() > 0) {
            clienteRepository.save(cliente);
            responseDto.setMenssage("Cliente alterado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Cliente inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

    public ResponseDto deleteCliente(Long id) {
        responseDto.setId(id);
        if (id > 0) {
            clienteRepository.deleteById(id);
            responseDto.setMenssage("Cliente deletado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Cliente inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

}