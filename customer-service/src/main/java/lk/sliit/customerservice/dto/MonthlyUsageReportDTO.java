package lk.sliit.customerservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonthlyUsageReportDTO {
    private String date;
    private Long numberOfUnit;
}
