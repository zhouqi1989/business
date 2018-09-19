package org.zuul.handler;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.zuul.pojo.Account;

@RepositoryEventHandler
public class AccountHandler {
	
	@HandleBeforeCreate
	@HandleBeforeSave
	public void handlePersonSave(Account account) throws Exception {
		if("22".equals(account.getAccount())) {
			
		}else {
			throw new Exception("不能添加");
		}
	}
	
}
