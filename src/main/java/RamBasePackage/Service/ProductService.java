package RamBasePackage.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import RamBasePackage.Entity.Product;
import RamBasePackage.repository.productRepository;

@Service
public class ProductService {
	
	@Autowired
	productRepository pr;
	
	public void save(Product p)
	{
		pr.save(p);
		
	}
	
	public List<Product> getAll()
	{
		
		List<Product> l=pr.findAll();
		return l;
		
	}
	
	public Product get(Integer id)
	{
		Optional<Product> o=pr.findById(id);
		Product p=null;
		if(o.isPresent())
		{
			p=o.get();
		}
		return p;
		
	}
	public void delete(Integer id)
	{
		pr.deleteById(id);
	}

	public Page<Product> findByPage(PageRequest p)
	{
		Page<Product> page=pr.findAll(p);
		return page;
	}
	
	
}
