package com.dev.recyceler;

public class contract_sample_java_model {
    int img;
    String name, number;

    public contract_sample_java_model(int img, String name, String number){
        this.img=img;
        this.name=name;
        this.number=number;
    }

    public contract_sample_java_model(String name, String number){
        this.name=name;
        this.number=number;
    }
}
