package voll.med.demo.controllers;

import static java.util.Arrays.asList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import voll.med.demo.Speciality;
import voll.med.demo.model.Doctor;
import voll.med.demo.repositories.DoctorRepository;
import voll.med.demo.servicies.DoctorService;

@Controller
@RequestMapping("/medicos")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private DoctorRepository doctorRepository;

	@GetMapping()
	public String list(Model model, Optional<Integer> page, Optional<String> q) {
		model.addAttribute("page", q.isPresent() ? doctorService.findByName(page.orElse(0), q.orElse(""))
				: doctorService.find(page.orElse(0)));
		return "doctorsList";
	}

//	@GetMapping("/form")
//	public String doctorForm(Model model) {
//		model.addAttribute("doctor", new Doctor());
//		model.addAttribute("speciality", asList(Speciality.values()));
//		return "doctorForm";
//	}

	@GetMapping("/form")
	public String doctorEdit(Model model, Optional<Long> id) {
		model.addAttribute("doctor", id.isPresent() ? doctorService.findById(id.get()).get() : new Doctor());
		model.addAttribute("speciality", asList(Speciality.values()));
		return "doctorForm";
	}

	@PostMapping
	public String register(Model model, @Valid Doctor doctor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			model.addAttribute("doctor", doctor);
			model.addAttribute("speciality", asList(Speciality.values()));
			return "doctorForm";
		}

		doctorService.save(doctor);
		return "redirect:/medicos";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam(value = "id") Long id) {
		doctorRepository.deleteById(id);
		return "redirect:/medicos";
	}
}
