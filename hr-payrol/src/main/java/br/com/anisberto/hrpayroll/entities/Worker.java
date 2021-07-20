package br.com.anisberto.hrpayroll.entities;

public class Worker {

	private Long id;
	private String name;
	private Double dailyIcome;

	public Worker() {

	}

	public Worker(Long id, String name, Double dailyIcome) {
		super();
		this.id = id;
		this.name = name;
		this.dailyIcome = dailyIcome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIcome() {
		return dailyIcome;
	}

	public void setDailyIcome(Double dailyIcome) {
		this.dailyIcome = dailyIcome;
	}

}
