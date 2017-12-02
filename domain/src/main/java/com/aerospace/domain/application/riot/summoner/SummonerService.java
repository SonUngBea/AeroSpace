package com.aerospace.domain.application.riot.summoner;

import com.aerospace.domain.application.riot.summoner.dto.SummonerDto;
import com.aerospace.domain.application.riot.summoner.dto.SummonerStateDto;
import com.aerospace.domain.application.store.riot.summoner.SummonerStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by coupang on 2017. 12. 2..
 */
@Service
public class SummonerService {
	@Autowired
	private SummonerStore summonerStore;

	public SummonerDto findBySummonerName(String summonerName) {
		return summonerStore.findSummonerByName(summonerName);
	}

	public Boolean findSummonerIsPlaying(Long summonerId) {
		return summonerStore.findSummonerIsPlaying(summonerId);
	}

	public SummonerStateDto findSummonerState(String summonerName) {
		SummonerDto summonerDto = findBySummonerName(summonerName);
		Boolean isPlaying = findSummonerIsPlaying(summonerDto.getId());
		SummonerStateDto summonerStateDto = new SummonerStateDto();
		summonerStateDto.setName(summonerDto.getName());
		summonerStateDto.setIsPlaying(isPlaying);
		summonerStateDto.setSummonerLevel(summonerDto.getSummonerLevel());
		return summonerStateDto;
	}
}
