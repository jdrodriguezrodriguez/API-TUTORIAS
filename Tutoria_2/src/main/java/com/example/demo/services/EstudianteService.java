package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Estudiante;
import com.example.demo.models.commons.RequestEstudianteDto;
import com.example.demo.repositories.IEstudianteRepository;

@Service
public class EstudianteService {
	
	
	@Autowired	/*CREAMOS INSTANCIA CON AUTWIRED*/
	private IEstudianteRepository estudianteRepository;
	
	public Estudiante guardar(RequestEstudianteDto estudiante) {	
		return estudianteRepository.save(mapperEstudiante(estudiante));
	}
	 
	public List<Estudiante> getAll(){
		return (List<Estudiante>) estudianteRepository.findAll();
	}
	
	public Estudiante update(Estudiante estudiante) {
		try {
			if(existeEstudiante(estudiante.getId())){
				return estudianteRepository.save(estudiante);
			}
			return null;
			
		}catch(Exception ex) {
			return null;
		}	
	}
	
	public boolean delete(int Id) {
		
		if(existeEstudiante(Id)){
			estudianteRepository.deleteById(Id);
			return true;
		}
		return false;
		
	}
	
	public boolean existeEstudiante(int Id) {	
		return estudianteRepository.existsById(Id) ? true : false;
	}	
	
	private Estudiante mapperEstudiante(RequestEstudianteDto estudiante) {
		Estudiante est = new Estudiante();
		est.setApellidos(estudiante.getApellidos());
		est.setCelular(estudiante.getCelular());
		est.setDireccion(estudiante.getDireccion());
		est.setEmail(estudiante.getEmail());
		est.setNumeroDocumento(estudiante.getNumeroDocumento());
		est.setId(0);
		return est;
	}
		
}	