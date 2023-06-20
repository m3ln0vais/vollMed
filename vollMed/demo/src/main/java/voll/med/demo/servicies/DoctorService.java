package voll.med.demo.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import voll.med.demo.model.Doctor;
import voll.med.demo.repositories.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor save(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public List<Doctor> find() {
		return doctorRepository.findAll();
	}

	public Page<Doctor> find(Integer page) {
		page = Optional.ofNullable(page).orElse(0);
		page = page < 0 ? 0 : page;
		return doctorRepository.findAll(PageRequest.of(page, 5));
	}
	
	public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }
	
	 public Page<Doctor> findByName(Integer page, String name) {
	        page = Optional.ofNullable(page).orElse(0);
	        page = page < 0 ? 0 : page;
	        return doctorRepository.findByNameContainingIgnoreCase(name, PageRequest.of(page, 1));
	    }

}
