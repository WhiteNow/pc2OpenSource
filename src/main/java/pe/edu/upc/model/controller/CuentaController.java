package pe.edu.upc.model.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.model.entity.Cliente;
import pe.edu.upc.model.entity.Cuenta;
import pe.edu.upc.service.IClienteService;
import pe.edu.upc.service.ICuentaService;



@Controller
@SessionAttributes("cuenta")
public class CuentaController {
	
	@Autowired
	private ICuentaService cuentaService;
	@Autowired
	private IClienteService clienteService;

	
	@GetMapping(value="/listarcuentas/{clienteId}")
	public String listar(Model model,@PathVariable(value = "clienteId") Long clienteId) {
		
		
		Cliente cliente = clienteService.findClienteById(clienteId);
		model.addAttribute("titulo", "Listar Cuentas");
		model.addAttribute("cuentas", cuentaService.listCuentaByCliente(clienteId));
		model.addAttribute("idcliente", clienteId);
		model.addAttribute("nombre", cliente.getNombre()+ " " +cliente.getApellido());
		
		return "listarcuentas" ;
		
	}

	@GetMapping(value="/nuevacuenta/{clienteId}")
	public String agregar(@PathVariable(value = "clienteId") Long clienteId, Model model) {
		
		Cliente cliente = clienteService.findClienteById(clienteId);

		Cuenta cuenta=new Cuenta();
		cuenta.setCliente(cliente);
		model.addAttribute("titulo", "Agregar");
		model.addAttribute("cuenta", cuenta);
		
		return "nuevacuenta";
		
	}
	
	
	@PostMapping("/nuevacuenta")
	public String guardar(@Valid Cuenta cuenta, Model model) {


		cuentaService.save(cuenta);
		return "redirect:/listarcuentas/" + cuenta.getCliente().getId();
	}

}
