package pe.edu.upc.model.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.model.entity.Cuenta;
import pe.edu.upc.model.entity.Movimiento;
import pe.edu.upc.service.ICuentaService;
import pe.edu.upc.service.IMovimientoService;



@Controller
@SessionAttributes("movimiento")
public class MovimientoController {
	
	@Autowired
	private IMovimientoService movimientoService;
	@Autowired
	private ICuentaService cuentaService;

	
	@GetMapping(value="/listarmovimientos/{cuentaId}")
	public String listar(Model model,@PathVariable(value = "cuentaId") Long cuentaId) {
		
		boolean advertencia = false;
		//Mensaje de advertencia
		if(model.asMap().containsKey("warning")) {
			String mensaje = model.asMap().get("warning").toString();
			advertencia = true;
			model.addAttribute("mensaje",mensaje);
		}
		
		model.addAttribute("advertencia",advertencia);
		
		model.addAttribute("titulo", "Listar Movimiento");
		model.addAttribute("movimientos", movimientoService.listMovimientoByCuenta(cuentaId));
		model.addAttribute("idcuenta", cuentaId);
		Cuenta cuenta = cuentaService.findCuentaById(cuentaId);
		model.addAttribute("idcliente", cuenta.getCliente().getId());
		model.addAttribute("cliente", cuenta.getCliente().getNombre() + ' ' + cuenta.getCliente().getApellido());
		model.addAttribute("ncuenta", cuenta.getNroCuenta());
		model.addAttribute("banco", cuenta.getBanco());
		model.addAttribute("monto",  cuenta.getSaldo());
		
		return "listarmovimientos" ;
		
	}
	


	@GetMapping(value="/nuevomovimiento/{cuentaId}")
	public String agregar(@PathVariable(value = "cuentaId") Long cuentaId, Model model) {
		
		Movimiento movimiento = new Movimiento();
		movimiento.setCuenta(cuentaService.findCuentaById(cuentaId));
		model.addAttribute("titulo", "Agregar Movimiento");
		model.addAttribute("movimiento", movimiento);
		model.addAttribute("idcuenta", cuentaId);
		model.addAttribute("ncuenta", movimiento.getCuenta().getNroCuenta());
		model.addAttribute("banco", movimiento.getCuenta().getBanco());
		model.addAttribute("monto",  movimiento.getCuenta().getSaldo());
		
		return "nuevomovimiento";
	}
	
	@PostMapping(value="/nuevomovimiento/{cuentaId}")
	public String guardar(Model model, @Valid Movimiento movimiento,
			@PathVariable(value = "cuentaId") Long cuentaId, RedirectAttributes redirectAttr) {
		Cuenta cuenta = cuentaService.findCuentaById(cuentaId);
		movimiento.setCuenta(cuenta);
		
		if(movimiento.getTipo().equalsIgnoreCase("Retiro") && movimiento.getMonto() > cuenta.getSaldo()) {
			redirectAttr.addFlashAttribute("warning","No hay saldo suficiente en la cuenta.");
			return "redirect:/listarmovimientos/" + cuentaId;
		}
		
		movimientoService.save(movimiento);
		return "redirect:/listarmovimientos/" + cuentaId;
	}
}

	

