package com.dojo.projects.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dojo.projects.models.Gasto;
import com.dojo.projects.services.ServicioViajes;

@Controller
@RequestMapping("/expenses")
public class ControladorViajes {
	
	private final ServicioViajes servicio;
	
	public ControladorViajes(ServicioViajes servicio) {
		this.servicio = servicio;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(Model model) {
		
		List<Gasto> lista_gastos = servicio.get_gastos();
		
		model.addAttribute("lista_gastos", lista_gastos);
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String new_expense(@ModelAttribute("gasto") Gasto gasto) {
		return "new.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("gasto") Gasto gasto,
						 BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			servicio.save_gasto(gasto);
			return "redirect:/expenses";
		}
	}
	
	@RequestMapping(value="/delete/{id_url}", method=RequestMethod.DELETE)
	public String eliminate(@PathVariable("id_url") Long id) {
		servicio.delete_gasto(id);
		return "redirect:/expenses";
	}
	
	@GetMapping(value="/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, @ModelAttribute("gasto") Gasto gasto) {
        Gasto gasto_edit = servicio.find_gasto(id);
        System.out.println(gasto.getExpense_name());
        model.addAttribute("gasto", gasto_edit);
        return "edit.jsp";
    }
	
	@GetMapping(value="/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model, @ModelAttribute("gasto") Gasto gasto) {
        Gasto gasto_edit = servicio.find_gasto(id);
        System.out.println(gasto.getExpense_name());
        model.addAttribute("gasto", gasto_edit);
        return "detail.jsp";
    }
	
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("gasto") Gasto gasto, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			servicio.save_gasto(gasto);
			return "redirect:/expenses";
		}
	}
	
	
}
