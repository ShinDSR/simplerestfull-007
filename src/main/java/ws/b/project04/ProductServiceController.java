/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.b.project04;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fa506
 */
@RestController
@ControllerAdvice
public class ProductServiceController {//Membuat class ProductServiceController
    
    private static Map<String, Product> productRepo = new HashMap<>();//Deklarasi variable Map bernama productRepo berupa HashMap baru
    static {
        Product honey = new Product();//Membuat value/product variable baru bernama honey
        honey.setId("1");//Mengatur id variable honey
        honey.setName("Honey");//Mengatur name variable honey
        honey.setPrice(80000);
        honey.setNumber(2);
        productRepo.put(honey.getId(), honey);//Membuat productRepo untuk variable honey dan menapilkan isinya

        Product almond = new Product();//Membuat value/product variable baru bernama almond
        almond.setId("2");//Mengatur id variable almond
        almond.setName("Almond");//Mengatur name variable almond
        almond.setPrice(50000);
        almond.setNumber(3);
        productRepo.put(almond.getId(), almond);//Membuat productRepo untuk variable almond dan menapilkan isinya
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)//Mengatur RequsetMapping dengan value berdasarkan id dan mengatur method yang digunakan
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {//Membuat method delete berdasarkan id
        if(!productRepo.containsKey(id)){//Mengatur kondisi jika id tidak ditemukan
            return new ResponseEntity<>("Product id is NOT FOUND!!", HttpStatus.NOT_FOUND);//Menampilkan keterangan bahwa data tidak ditemukan
        }
        productRepo.remove(id);//Menghapus data berdasarkan id
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);//Menampilkan keterangan bahwa data berhasil dihapus
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)//Mengatur RequsetMapping dengan value berdasarkan id dan mengatur method yang digunakan
    public ResponseEntity<Object> updateProduct(@PathVariable ("id") String id,@RequestBody Product product) {//Membuat method update berdasarkan id
        if(!productRepo.containsKey(id)){//Mengatur kondisi jika id tidak ditemukan
            return new ResponseEntity<>("Product id is NOT FOUND!!", HttpStatus.NOT_FOUND);//Menampilkan keterangan bahwa data tidak ditemukan
        }
        productRepo.remove(id);//Menghapus data berdasarkan id
        product.setId(id);//Mengatur id variable prouct
        productRepo.put(id, product);//Mengubah/Update data product berdasarkan id
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);//Menampilkan keterangan bahwa data berhasil diubah/update
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)//Mengatur RequsetMapping dengan value dan mengatur method yang digunakan
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {//Membuat method crate
        if(productRepo.containsKey(product.getId())){//Mengatur kondisi jika id sudah ada/digunakan
            return new ResponseEntity<>("Product id is ALREADY EXIST!!", HttpStatus.NOT_FOUND);//Menampilkan keterangan bahwa id tersebut sudah digunakan
        }
        productRepo.put(product.getId(), product);//Update data product berdasarkan id
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);//Menampilkan keterangan bahwa data berhasil dibuat
    }

    @RequestMapping(value = "/products")//Mengatur RequsetMapping dengan value
    public ResponseEntity<Object> getProduct() {//Membuat method crate untuk menampilkan data
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);//Menampilkan semua data yang sudah dibuat
    }
}
