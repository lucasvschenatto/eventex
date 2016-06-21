package main.domain.certificate;

import main.domain.Date;
import main.domain.Entity;
import main.domain.Quantity;
import main.domain.Text;

public class Certificate extends Entity {
	protected Text name;
	protected Text course;
	protected Quantity hours;
	protected Date date;
	protected Quantity score;
	
	public Certificate() {
		this("", Text.EMPTY, Text.EMPTY, Quantity.ZERO, Date.MIN, Quantity.ZERO);
	}

	protected Certificate(String id, Text name, Text course, Quantity hours, Date date, Quantity score) {
        super(id);
        this.name = name;
        this.course = course;
        this.hours = hours;
        this.date = date;
        this.score = score;
    }

	public Certificate copy(){
		return new Certificate(id, name, course, hours, date, score);
	}

	public Text getName() {
		return name;
	}

	public void setName(Text name) {
		this.name = name;
	}

	public Text getCourse() {
		return course;
	}

	public void setCourse(Text course) {
		this.course = course;
	}

	public Quantity getHours() {
		return hours;
	}

	public void setHours(Quantity hours) {
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Quantity getScore() {
		return score;
	}

	public void setScore(Quantity score) {
		this.score = score;
	}

}