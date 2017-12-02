package com.aerospace.domain.application.riot.summoner.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by coupang on 2017. 12. 3..
 */
@Getter
@Setter
public class SummonerStateDto {
	private Integer profileIconId;
	private String name;
	private Long summonerLevel;
	private Long revisionDate;
	private Long id;
	private Long accountId;
	private Boolean isPlaying;
}
