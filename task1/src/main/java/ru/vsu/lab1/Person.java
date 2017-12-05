package ru.vsu.lab1;
import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Person {
	private String name;
	private Integer id;
	private LocalDate birthDate;
	public int showAge() {
		return Years.yearsBetween(LocalDate.now(), birthDate).getYears();
	}

    public Person(String name,int id,LocalDate birthDay) {
	    this.name = name;
	    this.id = id;
	    this.birthDate = birthDay;
    }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}
