package com.company.project.controller;

import com.company.project.core.ResultResponse;
import com.eybond.quota.core.annotation.QuotaItemType;
import com.eybond.quota.core.annotation.QuotaLimited;
import com.eybond.quota.core.annotation.QuotaLimitedType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * {@code @author} fengdan80@outlook.com
 * {@code @time} 2023/04/07 22:27:52
 * {@code @version} 1.0.0
 * {@code @description} 测试
 */
@Slf4j
@RestController
@RequestMapping("/auth/web/user")
public class TestController {
    @PostMapping("/create")
    @QuotaLimited(value = QuotaItemType.PPR_CREATE_SUB_ACCOUNT, type = QuotaLimitedType.ADD)
    public ResultResponse createUser(@RequestBody UserDTO dto) {
        int a = 3 / 0;
        log.info("dto:[{}]", dto);
        return ResultResponse.success(dto);
    }

    @DeleteMapping("/delete/{id}")
    @QuotaLimited(value = QuotaItemType.PPR_CREATE_SUB_ACCOUNT, type = QuotaLimitedType.DELETE)
    public ResultResponse deleteUser(@PathVariable String id) {
        log.info("id:[{}]", id);
        return ResultResponse.success(id);
    }

}
