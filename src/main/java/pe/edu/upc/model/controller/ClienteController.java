package pe.edu.upc.model.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.model.entity.Cliente;
import pe.edu.upc.service.IClienteService;

@Controller
@SessionAttributes("cliente")
@RequestMapping("/cliente/")
public class ClienteController {

	@Autowired
	private IClienteService cService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("clientes", cService.findAll());
		return "cliente/listar";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cliente/nuevo";
	}
	
	@PostMapping("/guardar")
	public String guardar(Model model,Cliente cliente) {
		cService.save(cliente);
		return "redirect:/cliente/listar";
	}
	
}
