package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Parts and products to defined below to be put into repo
 */

@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        if (partDataDoesNotExist()) {
            initializePartData();
        }
        if (productDataDoesNotExist()) {
            initializeProductData();
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products "+ productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts " + partRepository.count());
        System.out.println(partRepository.findAll());

    }

    private boolean partDataDoesNotExist() {
        long partCount = partRepository.count();

        return partCount == 0;
    }

    private boolean productDataDoesNotExist() {
        long productCount = productRepository.count();

        return productCount == 0;
    }

    private void initializePartData() {
        InhousePart filter150 = new InhousePart(100150, "Aquarium Filtration 150 GPH", "Yes",25.0, 5, 4, 25);
        InhousePart filter200 = new InhousePart(100200,"Aquarium Filtration 200 GPH", "Yes",35.0, 5, 4, 25);
        InhousePart filter350 = new InhousePart(100350,"Aquarium Filtration 350 GPH", "Yes",45.0, 5, 4, 25);
        InhousePart bioCR10lbs = new InhousePart(111001,"Bio Ceramic Rings - 10lbs", "Yes",40.0, 5, 4, 25);
        InhousePart bioBalls50pc = new InhousePart(111002,"Bio Balls - 1pk of 50pcs", "Yes",10.0, 5, 4, 25);

        partRepository.save(filter150);
        partRepository.save(filter200);
        partRepository.save(filter350);
        partRepository.save(bioCR10lbs);
        partRepository.save(bioBalls50pc);
    }

    private void initializeProductData() {
        Product tenGalKit = new Product("10 Gal Aquarium Kit", 55.0, 5);
        Product twentyGalKit = new Product("20 Gal Aquarium Kit", 75.0, 5);
        Product thirtyGalKit = new Product("30 Gal Aquarium Kit", 100.0, 5);
        Product fiftyFiveGalKit = new Product("55 Gal Aquarium Kit", 125.0, 5);
        Product seventyFiveGalKit = new Product("75 Gal Aquarium Kit", 175.0, 5);

        productRepository.save(tenGalKit);
        productRepository.save(twentyGalKit);
        productRepository.save(thirtyGalKit);
        productRepository.save(fiftyFiveGalKit);
        productRepository.save(seventyFiveGalKit);
    }
}
