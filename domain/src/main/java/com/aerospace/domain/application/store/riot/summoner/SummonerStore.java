package com.aerospace.domain.application.store.riot.summoner;

import com.aerospace.domain.application.riot.summoner.dto.SummonerDto;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by coupang on 2017. 12. 2..
 */
@Component
@Slf4j
public class SummonerStore {
	//TODO:woongs API 콜 구조화
	public static final String API_KEY = "RGAPI-4d65f4b1-25cf-4ae5-828d-86b5c1a26301";

	private ObjectMapper objectMapper = new ObjectMapper();

	public SummonerDto findSummonerByName(String summonerName) {
		RestTemplate restTemplate = new RestTemplate();
		String summonerDtoString = restTemplate.getForObject("https://kr.api.riotgames.com/lol/summoner/v3/summoners/by-name/" + summonerName + "/?api_key=" + API_KEY, String.class);
		SummonerDto summonerDto = new SummonerDto();
		try {
			summonerDto = objectMapper.readValue(summonerDtoString, SummonerDto.class);
		} catch(Exception e) {
			log.error("fail to convert");
		}
		return summonerDto;
	}

	public Boolean findSummonerIsPlaying(Long summonerId) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			String isPlayingString =
				restTemplate.getForObject("https://kr.api.riotgames.com/lol/spectator/v3/active-games/by-summoner/"
					+ summonerId.toString()
					+ "/?api_key=" + API_KEY, String.class);
//			objectMapper.readValue(isPlayingString, String.class);
			return Boolean.TRUE;
		} catch(HttpClientErrorException e) {
			return Boolean.FALSE;
		}
	}
}
