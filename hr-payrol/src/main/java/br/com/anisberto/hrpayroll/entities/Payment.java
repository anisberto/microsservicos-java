package br.com.anisberto.hrpayroll.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private Double dailyIncome;
	private Integer days;
	
	public Double getTotal() {
		return this.getDays() * this.getDailyIncome();
	}
}
