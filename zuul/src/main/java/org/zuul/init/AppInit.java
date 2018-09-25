package org.zuul.init;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.zuul.entity.Account;
import org.zuul.repository.AccountRepository;

@Component
public class AppInit implements ApplicationRunner {

	//@Value("${news.com}")
	String name;
	
	@Autowired
	private AccountRepository accountRepository;
	//@Autowired
	//private ElasticsearchTemplate elasticsearchTemplate;
	
	private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("启动后执行:"+name);
		
		Account account=new Account();
		account.setAccount("13423731804");
		account.setEmail("1216309226@qq.com");
		account.setIcon("icon");
		account.setCreateTime(new Date());
		account.setLastLoginTime(new Date());
		account.setLastUpdateTime(new Date());
		account.setName("zhou qi");
		account.setPassword(passwordEncoder.encode("123456"));
		account.setPhone("13423731804");
		account.setStatus(0);
		account.setType(0);
		
		Account r = accountRepository.save(account);
		System.out.println("ID是:"+r.getId());
		/*String name="你好啊";
		IndexQuery indexQuery = new IndexQueryBuilder().withIndexName("index_zq")
                .withType("type_qq").withId("isId").withObject(name).build();
		
		String s = elasticsearchTemplate.index(indexQuery);
		System.out.println(s);*/
		
	}

}
