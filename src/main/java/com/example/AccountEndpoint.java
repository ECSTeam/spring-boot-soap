package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.ecsdemo.accounts_web_service.GetAccountRequest;
import io.ecsdemo.accounts_web_service.GetAccountResponse;

@Endpoint
public class AccountEndpoint {
	private static final String NAMESPACE_URI = "http://ecsdemo.io/accounts-web-service";
	private AccountRepository accountRepository;
	
	
	@Autowired
	public AccountEndpoint(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountRequest")
	@ResponsePayload
	public GetAccountResponse getAccount(@RequestPayload GetAccountRequest request) {
		GetAccountResponse response = new GetAccountResponse();
		response.setAccount(accountRepository.findAccount(request.getPhone()));

		return response;
	}
}
