package com.gustavosaron.banktransferapi.service;

import com.gustavosaron.banktransferapi.dto.BankTransferDTO;

public interface BankTransferService {
	void transfer(BankTransferDTO bankTransfer);	
}
