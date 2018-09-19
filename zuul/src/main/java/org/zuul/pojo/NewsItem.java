package org.zuul.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_news_item")
public class NewsItem implements Serializable {
	
	private static final long serialVersionUID = 456987L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	
	@Column(name="news_id")
	private long newsId;
	
	private String context;
	
	private Integer page;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNewsId() {
		return newsId;
	}

	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	
	
}
