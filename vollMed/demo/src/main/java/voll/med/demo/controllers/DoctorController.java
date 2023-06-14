package voll.med.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import voll.med.demo.model.Doctor;
import voll.med.demo.servicies.DoctorService;

@Controller
@RequestMapping("/medicos")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;

	@GetMapping()
	public String list(Model model) {
		return "doctorsList";
	}

	@GetMapping("/form")
	public String register(Model model) {
		return "doctorForm";
	}

	@PostMapping
	public String form(Model model, @Valid Doctor doctor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			model.addAttribute("doctor", doctor);
			return "doctorForm";
		}

		doctorService.save(doctor);
		return "redirect:/doctorsList";
	}

}
