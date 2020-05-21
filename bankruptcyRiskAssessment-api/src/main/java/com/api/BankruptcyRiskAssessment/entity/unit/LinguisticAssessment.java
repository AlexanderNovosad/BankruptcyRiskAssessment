package com.api.BankruptcyRiskAssessment.entity.unit;

public class LinguisticAssessment {
    private String name;
    private double a;
    private double b;
    private double c;
    private double d;

    public LinguisticAssessment(){
        this.name = "null";
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
    }


    public LinguisticAssessment(String name){
        this.name = name;
        if(name.equals("Дуже низький")){
            this.a = 0;
            this.b = 0;
            this.c = 0.15;
            this.d = 0.25;
        }
        if(name.equals("Низький")){
            this.a = 0.15;
            this.b = 0.25;
            this.c = 0.35;
            this.d = 0.45;
        }
        if(name.equals("Середній")){
            this.a = 0.35;
            this.b = 0.45;
            this.c = 0.55;
            this.d = 0.65;
        }
        if(name.equals("Високий")){
            this.a = 0.55;
            this.b = 0.65;
            this.c = 0.75;
            this.d = 0.85;
        }
        if(name.equals("Дуже високий")){
            this.a = 0.75;
            this.b = 0.85;
            this.c = 1;
            this.d = 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }
}
