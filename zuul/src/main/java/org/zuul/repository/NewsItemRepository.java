package org.zuul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.zuul.pojo.NewsItem;

@RepositoryRestResource(path="newsItem")
public interface NewsItemRepository extends JpaRepository<NewsItem, String> {
	
}
