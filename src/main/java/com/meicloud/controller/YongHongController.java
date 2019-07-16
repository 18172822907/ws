package com.meicloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = { "/yh" })
public class YongHongController extends BasicController {

	@GetMapping(value = "/test")
	public Object test() {

		try {
			return outBound("a");
		} catch (Exception e) {
			return errorHandler(e);
		}
	}

}
