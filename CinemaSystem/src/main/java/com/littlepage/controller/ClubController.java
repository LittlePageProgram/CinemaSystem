package com.littlepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/club")
public class ClubController {

		@RequestMapping("/buycard")
		public String buycard() {
			return "common/clubcard/buycard";
		}
}
