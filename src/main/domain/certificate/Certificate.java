package main.domain.certificate;

import main.domain.Date;
import main.domain.Entity;
import main.domain.Quantity;
import main.domain.Text;
import main.domain.activity.Minutes;

public class Certificate extends Entity {
	protected Text name;
	protected Text course;
	protected Minutes duration;
	protected Date courseDate;
	protected Quantity score;
	protected Date certificateDate;
	
	public Certificate() {
		this("", Text.EMPTY, Text.EMPTY, Minutes.ZERO, Date.MIN, Quantity.ZERO, Date.MIN);
	}

	protected Certificate(String id, Text name, Text course, Minutes duration, Date date, Quantity score, Date certificateDate) {
        super(id);
        this.name = name;
        this.course = course;
        this.duration = duration;
        this.courseDate = date;
        this.score = score;
        this.certificateDate = certificateDate;
    }

	public Certificate copy(){
		return new Certificate(id, name, course, duration, courseDate, score, certificateDate);
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

	public Minutes getDuration() {
		return duration;
	}

	public void setDuration(Minutes duration) {
		this.duration = duration;
	}

	public Date getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(Date date) {
		this.courseDate = date;
	}
	
	public Date getCertificateDate() {
		return courseDate;
	}

	public void setCertificateDate(Date date) {
		this.courseDate = date;
	}

	public Quantity getScore() {
		return score;
	}

	public void setScore(Quantity score) {
		this.score = score;
	}

}