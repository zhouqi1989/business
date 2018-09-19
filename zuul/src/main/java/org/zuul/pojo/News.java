package org.zuul.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_news")
public class News implements Serializable {
	
	private static final long serialVersionUID = 456987L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	
	private String title;
	
	private Integer source;
	
	private int status;
	
	private String auditor;
	
	@OneToMany(targetEntity=NewsItem.class,cascade=CascadeType.REMOVE,mappedBy="newsId")
	private List<NewsItem> items;
	
	@ManyToOne(targetEntity=Approval.class,cascade=CascadeType.REMOVE)
	private Approval approval;
	
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="last_update_time")
	private Date last_update_time;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<NewsItem> getItems() {
		return items;
	}

	public void setItems(List<NewsItem> items) {
		this.items = items;
	}

	public Approval getApproval() {
		return approval;
	}

	public void setApproval(Approval approval) {
		this.approval = approval;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}
	
	
}
