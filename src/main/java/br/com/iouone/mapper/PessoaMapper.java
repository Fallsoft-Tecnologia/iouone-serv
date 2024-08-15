    package br.com.iouone.mapper;

    import br.com.iouone.dto.PessoaRequest;
    import br.com.iouone.dto.PessoaResponse;
    import br.com.iouone.entity.AtividadeFisica;
    import br.com.iouone.entity.Pessoa;
    import br.com.iouone.repository.AtividadeRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;

    @Component
    public class PessoaMapper {

        @Autowired
        private AtividadeRepository atividadeRepository;

        public Pessoa toEntity(PessoaRequest pessoaRequest) {
            Pessoa pessoa = new Pessoa();
            pessoa.setCpf(pessoaRequest.getCpf());
            pessoa.setNome(pessoaRequest.getNome());
            pessoa.setEmail(pessoaRequest.getEmail());
            pessoa.setSenha(pessoaRequest.getSenha());
            pessoa.setCelular(pessoaRequest.getCelular());
            pessoa.setDataNascimento(pessoaRequest.getDataNascimento());

            if (pessoaRequest.getAtividadeFisicaId() != null) {
                AtividadeFisica atividadeFisica = atividadeRepository
                        .findById(pessoaRequest.getAtividadeFisicaId())
                        .orElse(null);
                pessoa.setAtividadeFisica(atividadeFisica);
            }

            return pessoa;
        }

        public PessoaResponse toResponse(Pessoa pessoa) {
            PessoaResponse pessoaResponse = new PessoaResponse();
            pessoaResponse.setId(pessoa.getId());
            pessoaResponse.setCpf(pessoa.getCpf());
            pessoaResponse.setNome(pessoa.getNome());
            pessoaResponse.setEmail(pessoa.getEmail());
            pessoaResponse.setCelular(pessoa.getCelular());
            pessoaResponse.setDataNascimento(pessoa.getDataNascimento());

            if (pessoa.getAtividadeFisica() != null) {
                pessoaResponse.setAtividadeFisica(pessoa.getAtividadeFisica().getAtividadeFisica());
            }

            return pessoaResponse;
        }
    }
