package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserInfo;
import com.example.demo.service.TestInterFace;

@RestController
@RequestMapping("test")
public class TestController {

	
	/*private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/test")
    public Test dealTest(@RequestParam(value="name", defaultValue="World") String name) {
        return new Test(counter.incrementAndGet(),
                            String.format(template, name));
    }@RequestMapping("/test1")
    public Test dealTest1(@RequestParam(value="name", defaultValue="World") String name) {
        return new Test(counter.incrementAndGet(),
                            String.format(template, name));
    }@RequestMapping("/hello")
    public String hello111() {
        return "Hello World!";
    }	*/
	
	private final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestInterFace testInterFace;
	
	@RequestMapping("/num")
	@ResponseBody
	int home() {
		log.info("spring boot集成日志 测试1....");
		int i = testInterFace.testInterFace();
	    return i;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	String insertUser() {
		log.info("spring boot inser测试....");
		testInterFace.insertUser("herongjian123", "123");
		return "新增会员成功!";
	}
	
	@RequestMapping("/user")
	@ResponseBody
	UserInfo selectUser() {
		log.info("spring boot select测试....");
		UserInfo userInfo = testInterFace.findUserById(8);
		return userInfo;
	}
	
	@RequestMapping("/userList")
	@ResponseBody
	List<UserInfo> selectUserList() {
		log.info("spring boot selectList测试....");
		List<UserInfo> userList = testInterFace.findUserList();
		return userList;
	}
	
	@RequestMapping("/upUserPwd")
	@ResponseBody
	String updateUserPwd() {
		log.info("spring boot update测试....");
		testInterFace.updateUserPwd(9, "12345678");
		return "更改会员密码成功";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	String deleteUser() {
		log.info("spring boot delete测试....");
		testInterFace.deleteUser(10);
		return "删除会员成功";
	}
	
}
