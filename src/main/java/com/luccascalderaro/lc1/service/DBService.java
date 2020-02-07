package com.luccascalderaro.lc1.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luccascalderaro.lc1.domain.Agenda;
import com.luccascalderaro.lc1.domain.Agendamento;
import com.luccascalderaro.lc1.domain.CadastroAgenda;
import com.luccascalderaro.lc1.domain.Especialidade;
import com.luccascalderaro.lc1.domain.GrupoProcedimento;
import com.luccascalderaro.lc1.domain.Medico;
import com.luccascalderaro.lc1.domain.Paciente;
import com.luccascalderaro.lc1.domain.Prestador;
import com.luccascalderaro.lc1.domain.PrestadorEndereco;
import com.luccascalderaro.lc1.domain.Procedimento;
import com.luccascalderaro.lc1.domain.SubEspecialidade;
import com.luccascalderaro.lc1.domain.enums.StatusAgendamento;
import com.luccascalderaro.lc1.domain.enums.StatusCadastroAgenda;
import com.luccascalderaro.lc1.repositories.AgendaRepository;
import com.luccascalderaro.lc1.repositories.AgendamentoRepository;
import com.luccascalderaro.lc1.repositories.CadastroAgendaRepository;
import com.luccascalderaro.lc1.repositories.EspecialidadeRepository;
import com.luccascalderaro.lc1.repositories.GrupoProcedimentoRepository;
import com.luccascalderaro.lc1.repositories.MedicoRepository;
import com.luccascalderaro.lc1.repositories.PacienteRepository;
import com.luccascalderaro.lc1.repositories.PrestadorEnderecoRepository;
import com.luccascalderaro.lc1.repositories.PrestadorRepository;
import com.luccascalderaro.lc1.repositories.ProcedimentoRepository;
import com.luccascalderaro.lc1.repositories.SubEspecialidadeRepository;

@Service
public class DBService {

	@Autowired
	private ProcedimentoRepository procedimentoRepository;

	@Autowired
	private GrupoProcedimentoRepository grupoProcedimentoRepository;
	
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@Autowired
	private SubEspecialidadeRepository subEspecialidadeRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PrestadorRepository prestadorRepository;
	
	@Autowired
	private PrestadorEnderecoRepository prestadorEnderecoRepository;
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private CadastroAgendaRepository cadastroAgendaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	
	
	

	public void instantiateDatabase() throws ParseException {
		
		GrupoProcedimento grup1 = new GrupoProcedimento(null, "Grupo 1");
		GrupoProcedimento grup2 = new GrupoProcedimento(null, "Grupo 2");
		
		Procedimento proc1 = new Procedimento(null, "Procedimento 1", grup1);
		
		Procedimento proc2 = new Procedimento(null, "Procedimento 2", grup1);
		
		Procedimento proc3 = new Procedimento(null, "Procedimento 3", grup2);
		
		grup1.getProcedimentos().addAll(Arrays.asList(proc1,proc2));
		grup2.getProcedimentos().addAll(Arrays.asList(proc3));
		
		grupoProcedimentoRepository.saveAll(Arrays.asList(grup1,grup2));
		procedimentoRepository.saveAll(Arrays.asList(proc1,proc2,proc3));
		
		Especialidade esp1 = new Especialidade(null, "Cardiologia");
		
		Especialidade esp2 = new Especialidade(null, "Ortopedia");
		
		
		SubEspecialidade sub1 = new SubEspecialidade(null, "Sub1-C.", esp1);
		
		SubEspecialidade sub2 =  new SubEspecialidade(null, "Sub2-C", esp1);
		
		SubEspecialidade sub3 = new SubEspecialidade(null, "Sub1-O", esp2);
		
		SubEspecialidade sub4 = new SubEspecialidade(null, "Sub2-O", esp2);
		
		SubEspecialidade sub5 = new SubEspecialidade(null, "Sub3-O", esp2);
		
		esp1.getSubEspecialidade().addAll(Arrays.asList(sub1,sub2));
		
		esp2.getSubEspecialidade().addAll(Arrays.asList(sub3,sub4,sub5));
		
		
		
		especialidadeRepository.saveAll(Arrays.asList(esp1,esp2));
		
		subEspecialidadeRepository.saveAll(Arrays.asList(sub1,sub2,sub3,sub4,sub5));
		
		
		
		Medico med1 = new Medico(null, "Luccas", "luccasc@hotmail.com", "6566565", "Rua teste 1");
		
		med1.getTelefone().addAll(Arrays.asList("36337436","36355689"));
		
		med1.getSubEspecialidade().addAll(Arrays.asList(sub1,sub3));
		
		
		medicoRepository.saveAll(Arrays.asList(med1));
		
		
		Prestador pre1 = new Prestador(null, "99593374000125", "Prestador 1");
		
		Prestador pre2 = new Prestador(null, "66988325000132", "Prestador 2");
		
		PrestadorEndereco pEnd1 = new PrestadorEndereco(null, "P.Endereco 1", pre1);
		
		PrestadorEndereco pEnd2 = new PrestadorEndereco(null, "P.Endereco 2", pre1);

		PrestadorEndereco pEnd3 = new PrestadorEndereco(null, "P.Endereco 1", pre2);
		
		
		pre1.getEnderecos().addAll(Arrays.asList(pEnd1,pEnd2));
		
		pre2.getEnderecos().addAll(Arrays.asList(pEnd3));
		
		prestadorRepository.saveAll(Arrays.asList(pre1,pre2));
		
		prestadorEnderecoRepository.saveAll(Arrays.asList(pEnd1,pEnd2,pEnd3));
		
		
		CadastroAgenda cadAg1 = new CadastroAgenda(null, StatusCadastroAgenda.ATIVO );
		
		Agenda agenda1 = new Agenda(null, med1, new Date(System.currentTimeMillis()), 12, 15,cadAg1, StatusCadastroAgenda.ATIVO);
		
		cadAg1.getAgendas().addAll(Arrays.asList(agenda1));
		
		SimpleDateFormat smf = new SimpleDateFormat("dd/mm/yyyy");
		
		Date n1 = smf.parse("01/01/1990");
		
		Paciente paciente1 = new Paciente(null, "Adriano", "Rua teste paciente", n1 , "luccashmc@hotmail.com");
		
		Agendamento agendamento1 = new Agendamento(null, agenda1, paciente1, sub1, StatusAgendamento.ATIVO);
		
		agenda1.getAgendamento().add(agendamento1);
		
		
		
		
		cadastroAgendaRepository.saveAll(Arrays.asList(cadAg1));
		
		pacienteRepository.saveAll(Arrays.asList(paciente1));
		
		agendaRepository.saveAll(Arrays.asList(agenda1));
		
		agendamentoRepository.saveAll(Arrays.asList(agendamento1));
		

	}

}
