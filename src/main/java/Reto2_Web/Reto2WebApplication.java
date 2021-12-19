package Reto2_Web;

import Reto2_Web.interfaces.InterfaceCleaningProduct;
import Reto2_Web.interfaces.InterfaceOrder;
import Reto2_Web.interfaces.InterfaceUser;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Reto2WebApplication implements CommandLineRunner {

    @Autowired
    private InterfaceCleaningProduct InterfaceCleaningProduct;
    @Autowired
    private InterfaceUser interfaceUser;
    @Autowired
    private InterfaceOrder interfaceOrder;

    public static void main(String[] args) {
        SpringApplication.run(Reto2WebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        InterfaceCleaningProduct.deleteAll();
        interfaceUser.deleteAll();
        interfaceOrder.deleteAll();
    }

}
