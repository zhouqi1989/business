package org.zuul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.zuul.pojo.News;

@RepositoryRestResource(path="news")
public interface NewsRepository extends JpaRepository<News, String> {
	
}
