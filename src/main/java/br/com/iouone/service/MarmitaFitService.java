package br.com.iouone.service;

import br.com.iouone.dto.IngredienteDTO;
import br.com.iouone.dto.MarmitaFitDTO;
import br.com.iouone.entity.MarmitaFit;
import br.com.iouone.repository.MarmitaFitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class MarmitaFitService {

    @Autowired
    private MarmitaFitRepository repository;

    @Autowired
    private UnidadeDeMedidaService unidadeDeMedidaService;

    public List<MarmitaFit> findAll() {
        return repository.findAll();
    }

    public Optional<MarmitaFit> findById(Integer id) {
        return repository.findById(id);
    }

    public MarmitaFit create(MarmitaFit marmitaFit) {
        return repository.save(marmitaFit);
    }

    public MarmitaFit update(Integer id, MarmitaFit marmitaFit) {
        Optional<MarmitaFit> existing = repository.findById(id);
        if (existing.isPresent()) {
            MarmitaFit updatedMarmitaFit = existing.get();
            updatedMarmitaFit.setNome(marmitaFit.getNome());
            updatedMarmitaFit.setDescricao(marmitaFit.getDescricao());
            updatedMarmitaFit.setModoDePreparo(marmitaFit.getModoDePreparo());
            updatedMarmitaFit.setFoto(marmitaFit.getFoto());
            return repository.save(updatedMarmitaFit);
        }
        return null;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public MarmitaFitDTO getMarmitaFitWithIngredients(Integer id) {
        List<Object[]> results = repository.findMarmitaFitWithIngredientsNative(id);

        if (results.isEmpty()) {
            throw new EntityNotFoundException("MarmitaFit não encontrada com ID: " + id);
        }

        List<MarmitaFitDTO> marmitas = mapToMarmitaFitDTOs(results);
        return marmitas.get(0);
    }


    public List<MarmitaFitDTO> mapToMarmitaFitDTOs(List<Object[]> results) {
        Map<Integer, MarmitaFitDTO> marmitaMap = new HashMap<>();

        for (Object[] row : results) {
            Integer idMarmita = (Integer) row[0];
            MarmitaFitDTO marmitaDTO = marmitaMap.get(idMarmita);

            if (marmitaDTO == null) {
                marmitaDTO = new MarmitaFitDTO();
                marmitaDTO.setNome(row[1] != null ? row[1].toString() : null);
                marmitaDTO.setModoDePreparo(row[2] != null ? row[2].toString() : null);
                marmitaDTO.setFoto(row[3] instanceof byte[] ? Base64.getEncoder().encodeToString((byte[]) row[3]) : (String) row[3]);
                marmitaDTO.setDescricao(row[4] != null ? row[4].toString() : null);
                marmitaDTO.setIngredientes(new ArrayList<>());
                marmitaMap.put(idMarmita, marmitaDTO);
            }

            IngredienteDTO ingredienteDTO = new IngredienteDTO();
            ingredienteDTO.setNome(row[5] != null ? row[5].toString() : null);
            ingredienteDTO.setQuantidade(row[6] != null ? (Integer) row[6] : null);
            ingredienteDTO.setUnidadeDeMedida(row[7] != null ? row[7].toString() : null);

            ingredienteDTO.setMarmitaFitId(idMarmita);

            marmitaDTO.getIngredientes().add(ingredienteDTO);
        }

        return new ArrayList<>(marmitaMap.values());
    }


    public void saveImage(Integer id, MultipartFile image) throws IOException {

        var retornoMarmitaFit = findById(id).orElseThrow(() -> new RuntimeException("Marmita Fit nao encontrada"));
        retornoMarmitaFit.setFoto(image.getBytes());
        create(retornoMarmitaFit);
    }
}
