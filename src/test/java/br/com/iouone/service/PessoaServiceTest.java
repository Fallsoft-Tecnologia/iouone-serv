package br.com.iouone.service;

import br.com.iouone.dto.PessoaRequest;
import br.com.iouone.dto.PessoaResponse;
import br.com.iouone.entity.Pessoa;
import br.com.iouone.mapper.PessoaMapper;
import br.com.iouone.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Nested
    @DisplayName("Tests for saving a Pessoa")
    class SavePessoaTests {

        @Test
        @DisplayName("Should save Pessoa successfully")
        void testSavePessoaSuccess() {
            PessoaRequest pessoaRequest = new PessoaRequest("Nome", "email@example.com", "senha123", "123456789", "987654321", LocalDate.now(), 1);

            Pessoa pessoaEntity = new Pessoa();
            pessoaEntity.setNome(pessoaRequest.getNome());
            pessoaEntity.setEmail(pessoaRequest.getEmail());
            pessoaEntity.setSenha("encodedSenha");

            Pessoa savedPessoa = new Pessoa();
            savedPessoa.setId(1);
            savedPessoa.setNome(pessoaRequest.getNome());
            savedPessoa.setEmail(pessoaRequest.getEmail());

            PessoaResponse expectedResponse = new PessoaResponse( "Nome", "email@example.com", "123456789", "987654321", LocalDate.now(), "1");

            when(pessoaMapper.toEntity(pessoaRequest)).thenReturn(pessoaEntity);
            when(passwordEncoder.encode(pessoaRequest.getSenha())).thenReturn("encodedSenha");
            when(pessoaRepository.save(pessoaEntity)).thenReturn(savedPessoa);
            when(pessoaMapper.toResponse(savedPessoa)).thenReturn(expectedResponse);

            PessoaResponse actualResponse = pessoaService.savePessoa(pessoaRequest);

            assertEquals(expectedResponse, actualResponse);
        }

        @Test
        @DisplayName("Should throw exception when password encoding fails")
        void testSavePessoaPasswordEncodingFails() {
            PessoaRequest pessoaRequest = new PessoaRequest("Nome", "email@example.com", "senha123", "123456789", "987654321", LocalDate.now(), 1);

            when(pessoaMapper.toEntity(pessoaRequest)).thenReturn(new Pessoa());
            when(passwordEncoder.encode(pessoaRequest.getSenha())).thenThrow(new RuntimeException("Encoding failed"));

            assertThrows(RuntimeException.class, () -> pessoaService.savePessoa(pessoaRequest));
        }


        @Test
        @DisplayName("Should verify interactions with mocks during save")
        void testSavePessoaInteraction() {
            PessoaRequest pessoaRequest = new PessoaRequest("Nome", "email@example.com", "senha123", "123456789", "987654321", LocalDate.now(), 1);

            Pessoa pessoaEntity = new Pessoa();
            pessoaEntity.setNome(pessoaRequest.getNome());
            pessoaEntity.setEmail(pessoaRequest.getEmail());
            pessoaEntity.setSenha("encodedSenha");

            Pessoa savedPessoa = new Pessoa();
            savedPessoa.setId(1);
            savedPessoa.setNome(pessoaRequest.getNome());
            savedPessoa.setEmail(pessoaRequest.getEmail());

            PessoaResponse expectedResponse = new PessoaResponse( "Nome", "email@example.com", "123456789", "987654321", LocalDate.now(), "1");

            when(pessoaMapper.toEntity(pessoaRequest)).thenReturn(pessoaEntity);
            when(passwordEncoder.encode(pessoaRequest.getSenha())).thenReturn("encodedSenha");
            when(pessoaRepository.save(pessoaEntity)).thenReturn(savedPessoa);
            when(pessoaMapper.toResponse(savedPessoa)).thenReturn(expectedResponse);

            PessoaResponse actualResponse = pessoaService.savePessoa(pessoaRequest);

            verify(pessoaMapper).toEntity(pessoaRequest);
            verify(passwordEncoder).encode(pessoaRequest.getSenha());
            verify(pessoaRepository).save(pessoaEntity);
            verify(pessoaMapper).toResponse(savedPessoa);

            assertEquals(expectedResponse, actualResponse);
        }

        @Test
        @DisplayName("Should handle saving Pessoa with different data")
        void testSavePessoaWithDifferentData() {
            PessoaRequest pessoaRequest = new PessoaRequest("Outro Nome", "outro@example.com", "outraSenha", "987654321", "123456789", LocalDate.of(1990, 1, 1), 2);

            Pessoa pessoaEntity = new Pessoa();
            pessoaEntity.setNome(pessoaRequest.getNome());
            pessoaEntity.setEmail(pessoaRequest.getEmail());
            pessoaEntity.setSenha("encodedOutraSenha");

            Pessoa savedPessoa = new Pessoa();
            savedPessoa.setId(2);
            savedPessoa.setNome(pessoaRequest.getNome());
            savedPessoa.setEmail(pessoaRequest.getEmail());

            PessoaResponse expectedResponse = new PessoaResponse( "Outro Nome", "outro@example.com", "987654321", "123456789", LocalDate.of(1990, 1, 1), "2");

            when(pessoaMapper.toEntity(pessoaRequest)).thenReturn(pessoaEntity);
            when(passwordEncoder.encode(pessoaRequest.getSenha())).thenReturn("encodedOutraSenha");
            when(pessoaRepository.save(pessoaEntity)).thenReturn(savedPessoa);
            when(pessoaMapper.toResponse(savedPessoa)).thenReturn(expectedResponse);

            PessoaResponse actualResponse = pessoaService.savePessoa(pessoaRequest);

            assertEquals(expectedResponse, actualResponse);
        }
    }


    @Nested
    @DisplayName("Tests for finding Pessoa")
    class FindPessoaTests {

        @Test
        @DisplayName("Should find Pessoa by ID successfully")
        void testFindPessoaById() {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(1);
            pessoa.setNome("Nome");

            PessoaResponse expectedResponse = new PessoaResponse( "Nome", "email@example.com", "123456789", "987654321", LocalDate.now(), "1");

            when(pessoaRepository.findById(1)).thenReturn(Optional.of(pessoa));
            when(pessoaMapper.toResponse(pessoa)).thenReturn(expectedResponse);

            Optional<PessoaResponse> actualResponse = pessoaService.findPessoaById(1);

            assertTrue(actualResponse.isPresent());
            assertEquals(expectedResponse, actualResponse.get());
        }

        @Test
        @DisplayName("Should return empty when Pessoa not found by ID")
        void testFindPessoaByIdNotFound() {
            when(pessoaRepository.findById(1)).thenReturn(Optional.empty());

            Optional<PessoaResponse> actualResponse = pessoaService.findPessoaById(1);

            assertFalse(actualResponse.isPresent());
        }
    }


    @Nested
    @DisplayName("Tests for updating Pessoa")
    class UpdatePessoaTests {

        @Test
        @DisplayName("Should update Pessoa successfully")
        void testUpdatePessoa() {
            PessoaRequest pessoaRequest = new PessoaRequest("NomeAtualizado", "emailAtualizado@example.com", "novaSenha123", "123456789", "987654321", LocalDate.now(), null);

            Pessoa existingPessoa = new Pessoa();
            existingPessoa.setId(1);
            existingPessoa.setNome("Nome");
            existingPessoa.setSenha("senhaAntiga");

            Pessoa updatedPessoa = new Pessoa();
            updatedPessoa.setId(1);
            updatedPessoa.setNome(pessoaRequest.getNome());
            updatedPessoa.setEmail(pessoaRequest.getEmail());
            updatedPessoa.setSenha("encodedNovaSenha");

            PessoaResponse expectedResponse = new PessoaResponse( "NomeAtualizado", "emailAtualizado@example.com", "123456789", "987654321", LocalDate.now(), null);

            when(pessoaRepository.findById(1)).thenReturn(Optional.of(existingPessoa));
            when(passwordEncoder.encode(pessoaRequest.getSenha())).thenReturn("encodedNovaSenha");
            when(pessoaRepository.save(existingPessoa)).thenReturn(updatedPessoa);
            when(pessoaMapper.toResponse(updatedPessoa)).thenReturn(expectedResponse);

            Optional<PessoaResponse> actualResponse = pessoaService.updatePessoa(1, pessoaRequest);

            assertTrue(actualResponse.isPresent());
            assertEquals(expectedResponse, actualResponse.get());
        }

        @Test
        @DisplayName("Should return empty when Pessoa to update is not found")
        void testUpdatePessoaNotFound() {
            PessoaRequest pessoaRequest = new PessoaRequest("NomeAtualizado", "emailAtualizado@example.com", "novaSenha123", "123456789", "987654321", LocalDate.now(), 1);

            when(pessoaRepository.findById(1)).thenReturn(Optional.empty());

            Optional<PessoaResponse> actualResponse = pessoaService.updatePessoa(1, pessoaRequest);

            assertFalse(actualResponse.isPresent());
        }
    }

    @Nested
    @DisplayName("Tests for listing all Pessoas")
    class FindAllPessoasTests {

        @Test
        @DisplayName("Should return all Pessoas successfully")
        void testFindAllPessoas() {
            Pessoa pessoa1 = new Pessoa();
            pessoa1.setId(1);
            pessoa1.setNome("Nome1");

            Pessoa pessoa2 = new Pessoa();
            pessoa2.setId(2);
            pessoa2.setNome("Nome2");

            PessoaResponse response1 = new PessoaResponse( "Nome1", "email1@example.com", "123456789", "987654321", LocalDate.now(), "1");
            PessoaResponse response2 = new PessoaResponse( "Nome2", "email2@example.com", "123456789", "987654321", LocalDate.now(), "2");

            List<Pessoa> pessoas = Arrays.asList(pessoa1, pessoa2);
            List<PessoaResponse> expectedResponses = Arrays.asList(response1, response2);

            when(pessoaRepository.findAll()).thenReturn(pessoas);
            when(pessoaMapper.toResponse(pessoa1)).thenReturn(response1);
            when(pessoaMapper.toResponse(pessoa2)).thenReturn(response2);

            List<PessoaResponse> actualResponses = pessoaService.findAllPessoas();

            assertEquals(expectedResponses.size(), actualResponses.size());
            assertEquals(expectedResponses, actualResponses);
        }
    }

    @Nested
    @DisplayName("Tests for deleting Pessoa")
    class DeletePessoaTests {

        @Test
        @DisplayName("Should delete Pessoa successfully")
        void testDeletePessoa() {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(1);
            pessoa.setNome("Nome");

            when(pessoaRepository.findById(1)).thenReturn(Optional.of(pessoa));

            boolean result = pessoaService.deletePessoa(1);

            assertTrue(result);
            verify(pessoaRepository, times(1)).delete(pessoa);
        }

        @Test
        @DisplayName("Should return false when Pessoa to delete is not found")
        void testDeletePessoaNotFound() {
            when(pessoaRepository.findById(1)).thenReturn(Optional.empty());

            boolean result = pessoaService.deletePessoa(1);

            assertFalse(result);
            verify(pessoaRepository, times(0)).delete(any());
        }
    }
}