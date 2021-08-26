package br.com.matheuspadilha.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    
    private static final long serialVersionUID = 2432758857978247473L;
    
    private String name;
    private Double dailyIncome;
    private Integer days;
    
    public double getTotal() {
        return days * dailyIncome;
    }
}
