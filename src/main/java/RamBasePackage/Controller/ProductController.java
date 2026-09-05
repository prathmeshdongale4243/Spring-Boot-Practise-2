package RamBasePackage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import RamBasePackage.Entity.Product;
import RamBasePackage.Service.ProductService;
import jakarta.validation.Valid;

@Controller
public class ProductController {

	@Autowired
	ProductService ps;
	
	@GetMapping({"/product-form"})
	public String productForm(Model model)
	{
		Product p=new Product();
		
		model.addAttribute("product", p);
		return "product";
	}
	@PostMapping("/save")
	public String saveForm(@Valid Product p ,BindingResult res,Model model)
	{
		if(res.hasErrors())
		{
			
			return "product";
		}
		
		ps.save(p);
		model.addAttribute("product", new Product());
		model.addAttribute("success","Data Submitted Successfully...");
		return "product";
		
	}

	@GetMapping("/display")
	public String displayData(Model model,@RequestParam(defaultValue="0") int page)
	{
		PageRequest p=PageRequest.of(page, 5);
		
		Page<Product> res=ps.findByPage(p);
		
		List<Product> l=res.getContent();
		
		model.addAttribute("products",l);
		model.addAttribute("currentPage", res.getNumber());
		model.addAttribute("totalPages", res.getTotalPages());
		
		
//		List<Product> l=ps.getAll();
//		model.addAttribute("products", l);
		
		return "display";
	}
	@GetMapping("/edit")
	public String editData(Model model, @RequestParam Integer id,@RequestParam Integer page)
	{
		Product p=ps.get(id);
		model.addAttribute("product", p);
		model.addAttribute("page", page);
		return "edit";
	}
	@PostMapping("editsave")
	public String editSave(@Valid Product p,BindingResult res,@RequestParam Integer page,Model model,RedirectAttributes attributes)
	{
		if(res.hasErrors())
		{
			return "edit";
		}
		ps.save(p);
		attributes.addFlashAttribute("success","Data Updated Successfully...");		
		return "redirect:/display?page="+page;
	}
	@GetMapping("/delete")
	public String deletedata(@RequestParam Integer id,@RequestParam Integer page ,RedirectAttributes attributes)
	{
	    ps.delete(id);
	    attributes.addFlashAttribute("delete", "Delete data Successfully");
	    
//	    List<Product> l=ps.getAll();
//		model.addAttribute("products", l);
		return "redirect:/display?page="+page;
	}

}
