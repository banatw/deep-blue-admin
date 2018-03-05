package com.example.deepblueadmin;

import com.entity.Negara;
import com.model.Error;
import com.model.Input;
import com.repo.NegaraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@SpringBootApplication
@EntityScan("com.entity")
@EnableJpaRepositories("com.repo")
public class DeepBlueAdminApplication {
	@Autowired
	private NegaraRepo negaraRepo;

	public static void main(String[] args) {
		SpringApplication.run(DeepBlueAdminApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return (x) -> {
			String[] nama = {"bana","tri","wahyudi","fdfdfdf","dfdfdf","dfdfdfd","xxxxxxx","hhhhhhh"};
			for(int i = 0;i<nama.length;i++) {
				Negara negara = new Negara(i,nama[i]);
				if(i==5 || i==8) {
					negara.setSelected(true);
				}
				negaraRepo.save(negara);
			}
		};
	}

	@Controller
	public class MyController {

		@GetMapping("/index")
		public String showIndex(Model model) {
			model.addAttribute("index","dfdfdf");
			return "index";
		}

		@GetMapping("/blog")
		public String showBlog(Model model) {
			model.addAttribute("blog","fdfdfd");
			return "blog";
		}

		@GetMapping("/bootstrap-elements")
		public String showBootstrapElements(Model model) {
			model.addAttribute("bootstrap-elements","fdfdf");
			return "bootstrap-elements";
		}

		@GetMapping("/signup")
		public String showSignup(Model model) {
			model.addAttribute("signup","fdfdf");
			return "signup";
		}

		@GetMapping("/blank")
		public String showBlank(Model model) {
			model.addAttribute("blank","fdfdf");
			model.addAttribute("negaras",negaraRepo.findAll());
			return "blank";
		}

		@GetMapping("/forms")
		public String showForms(Model model) {
			model.addAttribute("forms","fdfdf");
			return "forms";
		}

		@GetMapping("/portfolio")
		public String showPortfolio(Model model) {
			model.addAttribute("portfolio","fdfdf");
			return "portfolio";
		}

		@GetMapping("/register")
		public String showRegister(Model model) {
			model.addAttribute("register","fdfdf");
			return "register";
		}

		@GetMapping("/timeline")
		public String showTimeline(Model model) {
			model.addAttribute("timeline","fdfdf");
			return "timeline";
		}

		@GetMapping("/typography")
		public String showTypography(Model model) {
			model.addAttribute("typography","fdfdf");
			return "typography";
		}

		@GetMapping("/bootstrap-grid")
		public String showBootstrapgrid(Model model) {
			model.addAttribute("bootstrap-grid","fdfdf");
			return "bootstrap-grid";
		}

		@PostMapping("/simpan")
		public String simpan(Input input,Model model) {
			model.addAttribute("blank","fdfdf");
			model.addAttribute("negaras",negaraRepo.findAll());
			String[] tes=input.getNegara();
			for(int i=0;i<input.getNegara().length;i++) {
				System.out.println(tes[i]);
			}
			return "simpan";
		}

		@GetMapping("/negara")
		public String showNegara(Model model) {
			model.addAttribute("negara","fdfdf");
			model.addAttribute("negaras",negaraRepo.findAll());
			return "negara";
		}

		@GetMapping("/form-tes")
		public String showFormTes(Model model) {
			model.addAttribute("negara","fdfdf");
			model.addAttribute("negaras",negaraRepo.findAll());
			return "form_tes";
		}
	}

	public interface MatchGroup {
	}


	@RestController
	public class MyRestController {

		@PostMapping("/simpan-negara")
		public Error getError(@Valid com.model.Negara negara, BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				return new Error(1,bindingResult.getFieldError().getDefaultMessage());
			}
			Negara negara1 = new Negara();
			negara1.setName(negara.getName());
			negara1.setIdNegara(Integer.valueOf(negara.getIdNegara()));
			negaraRepo.save(negara1);
			return new Error(0,"");
		}
	}
}
