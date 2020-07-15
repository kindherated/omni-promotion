package com.purcotton.omni.promotion.rule.feign;

import com.purcotton.omni.promotion.constant.SystemConstants;
import com.purcotton.omni.promotion.rule.admin.dto.ActivityDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = SystemConstants.OMNI_PROMOTION_RULE_SERVER)
@RequestMapping("/promotion/activity")
public interface PromotionActivityFeign {

    /**
     * 新建活动
     * @param activityDto
     * @return
     */
    @PostMapping(value = "/add")
    public int addActivity(@RequestBody ActivityDto activityDto);

    /**
     * 获取活动详情
     * @param activityId
     * @return
     */
    @GetMapping(value = "/detail/{activityId}")
    public ActivityDto getActivityDetail(@PathVariable(name = "activityId") Long activityId);

    /**
     * 活动更新
     * @param activityDto
     * @return
     */
    @PostMapping(value = "/update")
    public int updateActivity(@RequestBody ActivityDto activityDto);
}
