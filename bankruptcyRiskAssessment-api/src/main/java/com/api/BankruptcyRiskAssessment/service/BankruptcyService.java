package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.unit.Factor;
import com.api.BankruptcyRiskAssessment.entity.unit.Indicator;
import com.api.BankruptcyRiskAssessment.entity.unit.LinguisticAssessment;

import java.util.ArrayList;
import java.util.List;

public class BankruptcyService implements IBankruptcyService {

    @Override
    public ArrayList<Indicator> setThePointsForIndicators(ArrayList<Indicator> indicators, List<LinguisticAssessment> assessments){
        assessments.forEach(assessment -> indicators.forEach(indicator -> indicator.setAssessment(assessment)));
        return indicators;
    }

//    @Override
//    public ArrayList<QuantitativeIndicator> setThePointsQuantitativeIndicators(ArrayList<QuantitativeIndicator> indicators, List<LinguisticAssessment> assessments){
//        assessments.forEach(assessment -> indicators.forEach(indicator -> indicator.setAssessment(assessment)));
//        return indicators;
//    }

    @Override
    public Factor calculateFactorPoints(ArrayList<Indicator> factorIndicators, ArrayList<String> factorDependencies){
        int[] r = new int[factorIndicators.size()];
        r[factorIndicators.size()-1] = 1;
        for(int i = factorDependencies.size(); i>0; i--){
            if(factorDependencies.get(i) == "="){
                r[i-1] = r[i];
            }
            else {
                r[i-1] = r[i]+1;
            }
        }

        int K = 0;
        for (int i = 0; i<factorIndicators.size(); i++){
            K = K+r[i];
        }

        double[] p = new double[factorIndicators.size()];
        for (int i = 0; i<factorIndicators.size(); i++){
            p[i] = r[i]/K;
        }

        Factor factor = factorIndicators.get(1).getFactor();
        for(int i = 0; i<factorIndicators.size(); i++){
            factor.getAssessment().setA(factor.getAssessment().getA()+factorIndicators.get(i).getAssessment().getA()*p[i]);
            factor.getAssessment().setB(factor.getAssessment().getB()+factorIndicators.get(i).getAssessment().getB()*p[i]);
            factor.getAssessment().setC(factor.getAssessment().getC()+factorIndicators.get(i).getAssessment().getC()*p[i]);
            factor.getAssessment().setD(factor.getAssessment().getD()+factorIndicators.get(i).getAssessment().getD()*p[i]);
        }

        LinguisticAssessment[] linguisticAssessments = {new LinguisticAssessment("Дуже низький"), new LinguisticAssessment("Низький"), new LinguisticAssessment("Середній"), new LinguisticAssessment("Високий"), new LinguisticAssessment("Дуже високий")};
        double a = Math.min(Math.abs(factor.getAssessment().getA()-linguisticAssessments[0].getA()), Math.abs(factor.getAssessment().getA()-linguisticAssessments[1].getA()));
        double b = Math.min(Math.abs(factor.getAssessment().getB()-linguisticAssessments[0].getB()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[1].getB()));
        double c = Math.min(Math.abs(factor.getAssessment().getC()-linguisticAssessments[0].getC()), Math.abs(factor.getAssessment().getC()-linguisticAssessments[1].getC()));
        double d = Math.min(Math.abs(factor.getAssessment().getD()-linguisticAssessments[0].getD()), Math.abs(factor.getAssessment().getD()-linguisticAssessments[1].getD()));
        for(int i = 2; i<5; i++){
            a = Math.min(a, Math.abs(factor.getAssessment().getA()-linguisticAssessments[i].getA()));
            b = Math.min(b, Math.abs(factor.getAssessment().getB()-linguisticAssessments[i].getB()));
            c = Math.min(c, Math.abs(factor.getAssessment().getC()-linguisticAssessments[i].getC()));
            d = Math.min(d, Math.abs(factor.getAssessment().getD()-linguisticAssessments[i].getD()));
        }
        if(a<0.15 && a>=0 && b<0.25 && b>=0 && c<0.35 && c>0.15 && d<0.45 && d>0.25)
            factor.getAssessment().setName("Дуже низький");
        if(a<0.35 && a>=0.15 && b<0.45 && b>=0.25 && c<0.55 && c>=0.35 && d<0.65 && d>=0.45)
            factor.getAssessment().setName("Низький");
        if(a<0.55 && a>=0.35 && b<0.65 && b>=0.45 && c<0.75 && c>=0.55 && d<0.85 && d>=0.65)
            factor.getAssessment().setName("Середній");
        if(a<0.75 && a>=0.55 && b<0.85 && b>=0.65 && c<1 && c>=0.75 && d<1 && d>=0.85)
            factor.getAssessment().setName("Високий");
        if(a>=0.75 && b>=0.85 && c>=1 && d>=1)
            factor.getAssessment().setName("Дуже високий");

        double v = 0;
        if(factor.getAssessment().getName().equals("Дуже низький")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[0].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[0].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[0].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[0].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Низький")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[1].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[1].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[1].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[1].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Середній")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[2].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[2].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[2].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[2].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Високий")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[3].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[3].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[3].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[3].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Дуже високий")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[4].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[4].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[4].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[4].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        return factor;
    }

    @Override
    public Factor calculateCompanyPoints(ArrayList<Factor> factors, ArrayList<String> factorDependencies){
        int[] r = new int[factors.size()];
        r[factors.size()-1] = 1;
        for(int i = factorDependencies.size(); i>0; i--){
            if(factorDependencies.get(i) == "="){
                r[i-1] = r[i];
            }
            else {
                r[i-1] = r[i]+1;
            }
        }

        int K = 0;
        for (int i = 0; i<factors.size(); i++){
            K = K+r[i];
        }

        double[] p = new double[factors.size()];
        for (int i = 0; i<factors.size(); i++){
            p[i] = r[i]/K;
        }

        Factor factor = new Factor();
        factor.setName("Стан підприємства");
        for(int i = 0; i<factors.size(); i++){
            factor.getAssessment().setA(factor.getAssessment().getA()+factors.get(i).getAssessment().getA()*p[i]);
            factor.getAssessment().setB(factor.getAssessment().getB()+factors.get(i).getAssessment().getB()*p[i]);
            factor.getAssessment().setC(factor.getAssessment().getC()+factors.get(i).getAssessment().getC()*p[i]);
            factor.getAssessment().setD(factor.getAssessment().getD()+factors.get(i).getAssessment().getD()*p[i]);
        }

        LinguisticAssessment[] linguisticAssessments = {new LinguisticAssessment("Дуже низький"), new LinguisticAssessment("Низький"), new LinguisticAssessment("Середній"), new LinguisticAssessment("Високий"), new LinguisticAssessment("Дуже високий")};
        double a = Math.min(Math.abs(factor.getAssessment().getA()-linguisticAssessments[0].getA()), Math.abs(factor.getAssessment().getA()-linguisticAssessments[1].getA()));
        double b = Math.min(Math.abs(factor.getAssessment().getB()-linguisticAssessments[0].getB()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[1].getB()));
        double c = Math.min(Math.abs(factor.getAssessment().getC()-linguisticAssessments[0].getC()), Math.abs(factor.getAssessment().getC()-linguisticAssessments[1].getC()));
        double d = Math.min(Math.abs(factor.getAssessment().getD()-linguisticAssessments[0].getD()), Math.abs(factor.getAssessment().getD()-linguisticAssessments[1].getD()));
        for(int i = 2; i<5; i++){
            a = Math.min(a, Math.abs(factor.getAssessment().getA()-linguisticAssessments[i].getA()));
            b = Math.min(b, Math.abs(factor.getAssessment().getB()-linguisticAssessments[i].getB()));
            c = Math.min(c, Math.abs(factor.getAssessment().getC()-linguisticAssessments[i].getC()));
            d = Math.min(d, Math.abs(factor.getAssessment().getD()-linguisticAssessments[i].getD()));
        }
        if(a<0.15 && a>=0 && b<0.25 && b>=0 && c<0.35 && c>0.15 && d<0.45 && d>0.25)
            factor.getAssessment().setName("Дуже низький");
        if(a<0.35 && a>=0.15 && b<0.45 && b>=0.25 && c<0.55 && c>=0.35 && d<0.65 && d>=0.45)
            factor.getAssessment().setName("Низький");
        if(a<0.55 && a>=0.35 && b<0.65 && b>=0.45 && c<0.75 && c>=0.55 && d<0.85 && d>=0.65)
            factor.getAssessment().setName("Середній");
        if(a<0.75 && a>=0.55 && b<0.85 && b>=0.65 && c<1 && c>=0.75 && d<1 && d>=0.85)
            factor.getAssessment().setName("Високий");
        if(a>=0.75 && b>=0.85 && c>=1 && d>=1)
            factor.getAssessment().setName("Дуже високий");

        double v = 0;
        if(factor.getAssessment().getName().equals("Дуже низький")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[0].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[0].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[0].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[0].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Низький")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[1].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[1].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[1].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[1].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Середній")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[2].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[2].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[2].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[2].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Високий")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[3].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[3].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[3].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[3].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Дуже високий")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[4].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[4].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[4].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[4].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        return factor;
    }
}
