package dev.spring.petclinic.owner.dto;

import dev.spring.petclinic.owner.model.Owner;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerRequestDTO {

	@Schema(description = "Owner 성 (Last Name)", example = "Franklin")
	@NotBlank(message = "성을 입력해야 합니다.")
	private String lastName;

	@Schema(description = "Owner 이름 (First Name)", example = "George")
	@NotBlank(message = "이름을 입력해야 합니다.")
	private String firstName;

	@Schema(description = "Owner 주소", example = "110 W. Liberty St.")
	@NotBlank(message = "주소를 입력해야 합니다.")
	private String address;

	@Schema(description = "Owner 도시", example = "Madison")
	@NotBlank(message = "도시를 입력해야 합니다.")
	private String city;

	@Schema(description = "Owner 전화번호", example = "01012343502")
	@NotBlank(message = "전화번호를 입력해야 합니다.")
	@Pattern(regexp = "\\d{10}", message = "전화번호는 숫자 10자리여야 합니다.")
	private String telephone;


	public static Owner from(OwnerRequestDTO dto) {
		return Owner.builder()
			.firstName(dto.getFirstName())
			.lastName(dto.getLastName())
			.address(dto.getAddress())
			.city(dto.getCity())
			.telephone(dto.getTelephone())
			.build();
	}
}
