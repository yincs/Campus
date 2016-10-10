package org.changs.campus.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public @ResponseBody String test() {
		return "测试成功12";
	}

	@RequestMapping("/hello2")
	public @ResponseBody Response<UserInfo> test(@RequestBody UserInfo userInfo) {
		return new Response<UserInfo>(userInfo);
	}
}
