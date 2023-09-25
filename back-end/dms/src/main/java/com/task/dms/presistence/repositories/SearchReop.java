package com.task.dms.presistence.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.task.dms.business.dto.EmployeeDto;
import com.task.dms.presistence.models.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchReop {
    @Autowired
    private EntityManager entityManager ;

    public List<Employee> employeefilter(EmployeeDto employeeDTO) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        List<Predicate> predicates = new ArrayList<>();

        Root<Employee> root = criteriaQuery.from(Employee.class);

        if (employeeDTO.getName() != null) {
            Predicate name = criteriaBuilder.like(root.get("name"), "%" + employeeDTO.getName() + "%");
            predicates.add(name);
        }

        if (employeeDTO.getDepartment().getCode() != null) {
            Predicate department_code = criteriaBuilder.equal(root.get("department_code"), employeeDTO.getDepartment().getCode() );
            predicates.add(department_code);
        }
        if (employeeDTO.getDepartment().getName() != null) {
            Predicate department_name = criteriaBuilder.like(root.get("department_name"), "%" + employeeDTO.getDepartment().getName() + "%");
            predicates.add(department_name);
        }
        if (employeeDTO.getDepartment().getDescription() != null) {
            Predicate department_description = criteriaBuilder.like(root.get("department_description"), "%" + employeeDTO.getDepartment().getDescription() + "%");
            predicates.add(department_description);
        }
        if (employeeDTO.getCode() != null) {
            Predicate code = criteriaBuilder.equal(root.get("code"), employeeDTO.getCode());
            predicates.add(code);
        }

        if (employeeDTO.getAddress() != null) {
            Predicate address = criteriaBuilder.like(root.get("address"), "%" + employeeDTO.getAddress() + "%");
            predicates.add(address);
        }

        if (employeeDTO.getSalary() != null) {
            Predicate salary = criteriaBuilder.equal(root.get("salary"),  employeeDTO.getSalary() );
            predicates.add(salary);
        }

        if (employeeDTO.getMobile() != null) {
            Predicate mobile = criteriaBuilder.like(root.get("mobile"), "%" + employeeDTO.getMobile() + "%");
            predicates.add(mobile);
        }

        if (employeeDTO.getBirth_date() != null) {
            Predicate birth_date = criteriaBuilder.equal(root.get("birth_date"), employeeDTO.getBirth_date() );
            predicates.add(birth_date);
        }

        

        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }


}
