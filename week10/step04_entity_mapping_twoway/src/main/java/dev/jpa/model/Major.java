package dev.jpa.model;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Major {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToMany(mappedBy = "major")
	@Builder.Default
	private List<Student> students = new ArrayList<>();

	public void addStudent(Student student) {
		this.students.add(student);
	}
	@Override
	public String toString() {
		return "MajorData{" +
			"id=" + id +
			", name='" + name + '\'' +
			", students=" + students +
			'}';
	}
}
