package com.Sena2.Majo.dto.response;

import com.Sena2.Majo.dto.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KingdomResponseDto {

    @JsonView(View.basic.class)
    private Integer id;

    @JsonView(View.basic.class)
    private String name;
}
