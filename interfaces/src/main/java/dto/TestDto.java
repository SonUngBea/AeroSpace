package dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

/**
 * Created by coupang on 2017. 8. 20..
 */
@Data
@NoArgsConstructor
public class TestDto {
	@NonNull
	private String id;
	@Length(min = 2 , max = 5)
	private String recommender;
}
