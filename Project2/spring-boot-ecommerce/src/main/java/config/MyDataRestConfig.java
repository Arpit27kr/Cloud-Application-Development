package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.cadproject.ecommerce.entity.Product;
import com.cadproject.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	public void configureRepositoryConfiguration(RepositoryRestConfiguration config , CorsRegistry cors)
	{
		
		 HttpMethod[] theUnsupportedActions= {HttpMethod.PUT,HttpMethod.POST, HttpMethod.DELETE};
		  
		  config.getExposureConfiguration()
		  .forDomainType(Product.class )
		  .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
		  .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
		  
		  
		  config.getExposureConfiguration()
		  .forDomainType(ProductCategory.class )
		  .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
		  .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
		  
		  
		  
	
	}
	
	
}
