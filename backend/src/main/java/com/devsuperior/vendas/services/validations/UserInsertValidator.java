package com.devsuperior.vendas.services.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.devsuperior.vendas.controller.exceptions.FieldMessage;
import com.devsuperior.vendas.dto.UserInsertDTO;
import com.devsuperior.vendas.entities.User;
import com.devsuperior.vendas.repositories.UserRepository;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(UserInsertValid ann) {
    }
    List<FieldMessage> list = new ArrayList<>();



    @Override
    public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {

        User user = repository.findByEmail(dto.getEmail());
        if (user != null) {
            list.add(new FieldMessage("Email", "Email já existe"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
