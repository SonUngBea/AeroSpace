package controller.riot;

import com.aerospace.domain.application.riot.summoner.SummonerService;
import com.aerospace.domain.application.riot.summoner.dto.SummonerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by woongs on 2017. 12. 2..
 */
@Controller
@RequestMapping("/riot")
public class UserController {
	@Autowired
	private SummonerService summonerService;

	@RequestMapping("/user")
	public ModelAndView summonerState() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("/riot/summonerstate");
		mnv.addObject("yongHyun", summonerService.findSummonerState("지울수없는"));
		mnv.addObject("jiYoung", summonerService.findSummonerState("박멩이"));
		mnv.addObject("junYoung", summonerService.findSummonerState("김종찬"));
		mnv.addObject("youngJu", summonerService.findSummonerState("띵오얀"));
		mnv.addObject("ungBea", summonerService.findSummonerState("쓰렉션"));
		return mnv;
	}

	@RequestMapping("/user/{summonerName}")
	@ResponseBody
	public SummonerDto getSummonerDtoByName(@PathVariable String summonerName) {
		return summonerService.findBySummonerName(summonerName);
	}

}
