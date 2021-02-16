package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

public class TExchangeRate {

    private int id;
    private LocalDate excRateDate;
    private float excRateEur;
    private float excRateUsd;
    private float excRateGbp;

    public  TExchangeRate(){

    }

    public int getId(){return  id;}
    public void setId(int id){this.id=id;}

    public LocalDate getExcRateDate(){return excRateDate;}
    public void setExcRateDate(LocalDate excRateDate){this.excRateDate=excRateDate;}

    public float getExcRateEur(){return excRateEur;}
    public void setExcRateEur(float excRateEur){this.excRateEur=excRateEur;}

    public float getExcRateUsd(){return excRateUsd;}
    public void setExcRateUsd(float excRateUsd){this.excRateUsd=excRateUsd;}

    public float getExcRateGbp(){return excRateGbp;}
    public void setExcRateGbp(float excRateGbp){this.excRateGbp=excRateGbp;}


}
