package com.Sena2.Majo.dto.response;

import com.Sena2.Majo.dto.view.View;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BehaviorResponseDto {

    @JsonView(View.detail.class)
    private Integer id;

    @JsonView(View.detail.class)
    private String type;
}
