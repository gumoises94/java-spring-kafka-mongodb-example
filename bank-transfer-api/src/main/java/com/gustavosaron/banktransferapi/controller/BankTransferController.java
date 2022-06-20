package com.gustavosaron.banktransferapi.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gustavosaron.banktransferapi.dto.BankTransferDTO;
import com.gustavosaron.banktransferapi.service.BankTransferService;

@RestController
@RequestMapping("/transfers")
public class BankTransferController {
	
	@Autowired
	public BankTransferService bankTransferService;

	@PostMapping
	public ResponseEntity<?> transfer(@Valid @RequestBody BankTransferDTO bankTransfer) {
		bankTransferService.transfer(bankTransfer);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.build();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult()
		.getAllErrors()
		.forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
