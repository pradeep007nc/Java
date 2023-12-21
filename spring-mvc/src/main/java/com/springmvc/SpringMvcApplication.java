package com.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcApplication {

	static class Add{
		public int add(int ... a){
			int ans = 0;
            for (int i: a){
				ans += i;
			}
			return ans;
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);


		Add a = new Add();
		System.out.println(a.add(12));
		System.out.println(a.add(34,34,54));
		a.add();
	}

}
