package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.lang.reflect.GenericDeclaration;
import java.util.*;

public class Main {



    public static void main(String[] args) {

        Service service = new Service();

        service.addProduct("1","abc",10.00, 2);
        service.addProduct("2","abc",10.00, 2);

        service.list();
        //service.delete("1");

//        service.updateProduct("1","fddg",null, null);

    }

        }



