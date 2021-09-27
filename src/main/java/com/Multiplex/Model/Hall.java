package com.Multiplex.Model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Hall")
public class Hall{
	
	@Id
	@Column(name = "Hall_ID")
	private int hallId;
	@Column(name = "Total_Capacity")
	private int totalCapacity;
	@Column(name = "Hall_Desc")
	private String hallDesc;
	@OneToMany(mappedBy = "hall",cascade = CascadeType.ALL)
	private List<Shows> show;
	@OneToMany(mappedBy = "hall",cascade = CascadeType.ALL)
	private List<HallCapacity> hallCapacity;
	public Hall() {
		super();
	}
	
	public int getHallId() {
		return hallId;
	}

	public void setHallId(int hallId) {
		this.hallId = hallId;
	}

	public int getTotalCapacity() {
		return totalCapacity;
	}
	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	public String getHallDesc() {
		return hallDesc;
	}
	public void setHallDesc(String hallDesc) {
		this.hallDesc = hallDesc;
	}
	public List<Shows> getShow() {
		return show;
	}
	public void setShow(List<Shows> show) {
		this.show = show;
	}

	public List<HallCapacity> getHallCapacity() {
		return hallCapacity;
	}

	public void setHallCapacity(List<HallCapacity> hallCapacity) {
		this.hallCapacity = hallCapacity;
	}

	@Override
	public String toString() {
		return "Hall [hallId=" + hallId + ", totalCapacity=" + totalCapacity + ", hallDesc=" + hallDesc + ", show="
				+ show + ", hallCapacity=" + hallCapacity + "]";
	}
	
}






