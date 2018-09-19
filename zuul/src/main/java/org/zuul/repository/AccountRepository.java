package org.zuul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.zuul.pojo.Account;

@RepositoryRestResource(path="account")
public interface AccountRepository extends JpaRepository<Account, String> {
	
	@RestResource(path="account",rel="account")
    public List<Account> findByAccount(@Param("account") String account);
}
