package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {


   /* @Query("SELECT case  when  count (s) > 0 then true  else  false  end " +
            "from  Student  s  where s.email = ?1")
    Boolean selectExistEmail(String email);*/
   boolean existsByEmail (String email);

}
