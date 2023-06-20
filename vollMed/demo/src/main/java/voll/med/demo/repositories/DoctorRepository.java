package voll.med.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import voll.med.demo.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	public Page<Doctor> findByNameContainingIgnoreCase(String name, Pageable page);

}
