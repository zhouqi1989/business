package org.zuul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.zuul.pojo.Approval;

@RepositoryRestResource(path="approval")
public interface ApprovalRepository extends JpaRepository<Approval, String> {
	
}
