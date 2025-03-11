package dev.jpa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@Entity // JPA가 해당 클래스를 DBMS의 테이블의 형태로 관리하도록 명시, "해당 클래스는 Entity로 관리하겠다."
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String author;

	@Temporal(TemporalType.TIMESTAMP)
	private Date pubDate;
	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}

	/**
	 * 책 이름 갱신 메서드
	 * @param name
	 */
	public void updateBookName(String name) {
		this.name = name;
	}


}
