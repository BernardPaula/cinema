package com.bernardpaula.cinema.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardpaula.cinema.domain.Ator;
import com.bernardpaula.cinema.domain.Filme;
import com.bernardpaula.cinema.domain.Ingresso;
import com.bernardpaula.cinema.domain.Sala;
import com.bernardpaula.cinema.domain.Sessao;
import com.bernardpaula.cinema.domain.enums.EnumCategoriaIngresso;
import com.bernardpaula.cinema.domain.enums.EnumGeneroFilme;
import com.bernardpaula.cinema.domain.enums.EnumTipoIngresso;
import com.bernardpaula.cinema.repositories.AtorRepository;
import com.bernardpaula.cinema.repositories.FilmeRepository;
import com.bernardpaula.cinema.repositories.IngressoRepository;
import com.bernardpaula.cinema.repositories.SalaRepository;
import com.bernardpaula.cinema.repositories.SessaoRepository;

@Service
public class DBService {

	@Autowired
	private AtorRepository atorRepo;
	
	@Autowired
	private FilmeRepository filmeRepo;
	
	@Autowired
	private IngressoRepository ingressoRepo;
	
	@Autowired
	private SalaRepository salaRepo;
	
	@Autowired
	private SessaoRepository sessaoRepo;
	
	public void instantiateDatabase() {
		
		
		Filme fil1 = new Filme(null, "A Cura", 1.3, EnumGeneroFilme.AVENTURA);
		Filme fil2 = new Filme(null, "Asas", 1.25, EnumGeneroFilme.ACAO);
		Filme fil3 = new Filme(null, "Viajando", 2.25, EnumGeneroFilme.COMEDIA);
		Filme fil4 = new Filme(null, "Troia", 2.1, EnumGeneroFilme.DRAMA);
		Filme fil5 = new Filme(null, "Aquarela", 1.8, EnumGeneroFilme.SUSPENSE);
		
		
		Ator ator1 = new Ator(null, "Jones", "Codjuvante");
		Ator ator2 = new Ator(null, "Fernando", "Principal");
		Ator ator3 = new Ator(null, "Leny", "Codjuvante");
		Ator ator4 = new Ator(null, "Raquel", "vilão");
		Ator ator5 = new Ator(null, "Cristian", "Codjuvante");
			
		
		fil1.getAtores().addAll(Arrays.asList(ator1, ator2, ator3));
		fil2.getAtores().addAll(Arrays.asList(ator1, ator5));
		fil3.getAtores().addAll(Arrays.asList(ator3, ator4));
		fil4.getAtores().addAll(Arrays.asList(ator3, ator5));
		fil5.getAtores().addAll(Arrays.asList(ator1, ator3, ator2));
		
		ator1.getFilmes().addAll(Arrays.asList(fil1, fil2, fil5));
		ator2.getFilmes().addAll(Arrays.asList(fil1, fil5));
		ator3.getFilmes().addAll(Arrays.asList(fil1, fil3, fil4, fil5));
		ator4.getFilmes().addAll(Arrays.asList(fil3));
		ator5.getFilmes().addAll(Arrays.asList(fil2, fil4));
		
		filmeRepo.saveAll(Arrays.asList(fil1, fil2, fil3, fil4, fil5));
		atorRepo.saveAll(Arrays.asList(ator1, ator2, ator3, ator4, ator5));
	
		
		Ingresso in1 = new Ingresso(null, EnumTipoIngresso.INGRESSOINTEIRO, EnumCategoriaIngresso.INGRESSOFISICO, fil5);
		Ingresso in2 = new Ingresso(null, EnumTipoIngresso.INGRESSOINTEIRO, EnumCategoriaIngresso.INGRESSOONLINE, fil4);
		Ingresso in3 = new Ingresso(null, EnumTipoIngresso.MEIOIGRESSO, EnumCategoriaIngresso.INGRESSOONLINE, fil3);
		Ingresso in4 = new Ingresso(null, EnumTipoIngresso.INGRESSOINTEIRO, EnumCategoriaIngresso.INGRESSOFISICO, fil2);
		Ingresso in5 = new Ingresso(null, EnumTipoIngresso.MEIOIGRESSO, EnumCategoriaIngresso.INGRESSOONLINE, fil1);
		
		fil1.getIngressos().addAll(Arrays.asList(in5));
		fil2.getIngressos().addAll(Arrays.asList(in4));
		fil3.getIngressos().addAll(Arrays.asList(in3));
		fil4.getIngressos().addAll(Arrays.asList(in2));
		fil5.getIngressos().addAll(Arrays.asList(in1));
		
		ingressoRepo.saveAll(Arrays.asList(in1, in2, in3, in4, in5));
		
		
		Sessao ses1 = new Sessao(null, false, 20);
		Sessao ses2 = new Sessao(null, true, 19);
		Sessao ses3 = new Sessao(null, false, 17);
		
		Sala sal1 = new Sala(null, 30, "Azul", "aaa");
		Sala sal2 = new Sala(null, 27, "Verde", "bbb");
		Sala sal3 = new Sala(null, 35, "Azul", "ccc");
				
		ses1.getSalas().addAll(Arrays.asList(sal1));
		ses2.getSalas().addAll(Arrays.asList(sal1, sal3));
		ses3.getSalas().addAll(Arrays.asList(sal2));
		
		sessaoRepo.saveAll(Arrays.asList(ses1, ses2, ses3));
		salaRepo.saveAll(Arrays.asList(sal1, sal2, sal3));

		
		
		
	}
	
}
