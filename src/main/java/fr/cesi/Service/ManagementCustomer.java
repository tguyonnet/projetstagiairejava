package fr.cesi.Service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManagementCustomer {
    private static ManagementCustomer customerManagement;

    public static ManagementCustomer getCustomerService() {
        if (customerManagement == null) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
            customerManagement = context.getBean("managementCustomer", ManagementCustomer.class);
        }
        return customerManagement;
    }
}
