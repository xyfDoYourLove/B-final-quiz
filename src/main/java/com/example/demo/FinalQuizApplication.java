package com.example.demo;

import com.example.demo.common.util.InitUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class FinalQuizApplication implements ApplicationRunner {

	InitUtil initUtil;

	@Autowired
	public void setInitUtil(InitUtil initUtil) {
		this.initUtil = initUtil;
	}

	public static void main(String[] args) {
		SpringApplication.run(FinalQuizApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("=========数据初始化开始=========");
		initUtil.initTraineeRepo();
		log.info("=========数据初始化完成=========");
	}
}
