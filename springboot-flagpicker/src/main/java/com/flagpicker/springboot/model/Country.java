package com.flagpicker.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Created by balaji ramakrishnan .
 */
@Entity
@Table(name = "country")
public class Country extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Lob
    private String name;
    @NotNull
    @Lob
    private String flag;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "continent_Id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Continent continent;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}


}
