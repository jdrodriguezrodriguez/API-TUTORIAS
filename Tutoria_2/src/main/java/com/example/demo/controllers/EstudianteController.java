package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Estudiante;
import com.example.demo.models.commons.RequestEstudianteDto;
import com.example.demo.models.commons.Response;
import com.example.demo.services.EstudianteService;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@PostMapping
	public ResponseEntity<Estudiante> save(@RequestBody RequestEstudianteDto estudiante){
		return ResponseEntity.ok(estudianteService.guardar(estudiante));
	}
	
	@GetMapping
	public ResponseEntity<List<Estudiante>> getAll(){
		
		return ResponseEntity.ok(estudianteService.getAll());	
	}
	
	@PutMapping
	public ResponseEntity<Response<Object>> update(@RequestBody Estudiante estudiante){

		var estudianteActualizado = estudianteService.update(estudiante);
		
		if(estudianteActualizado == null) {
			return ResponseEntity.ok(new Response<>("No se encontro el docente"));
		}
		
		return ResponseEntity.ok(new Response<>("Estudiante actualizado", estudianteActualizado));
	} 
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<Response<Object>> delete(@PathVariable("Id") int Id) {
		
		if(estudianteService.delete(Id)) {
			
			return ResponseEntity.ok(new Response<>("Estudiante eliminado"));
			
		} else {
			return ResponseEntity.ok(new Response<>("Estudiante no se ha eliminado"));
		}
	}
} 
