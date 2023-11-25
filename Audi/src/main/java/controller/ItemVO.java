package controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class ItemVO {
	
	@NotNull(message = "값을 대입하세요 ")
	@Range( message ="값의 범위는 1000과 1000000사에이 있어야 합니다", min=1000,max=1000000)
	private Integer price;
	
	@NotBlank(message = "공백일 수 없습니다.")
	private String name;
	
	@NotNull(message = "공백일 수 없습니다리.")
	@Max(value = 9999,message="최대값은 9999를 넘을 수 없습니다.")
	private Integer quen;
	
	public Integer getQuen() {
		return quen;
	}
	public void setQuen(Integer quen) {
		this.quen = quen;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
