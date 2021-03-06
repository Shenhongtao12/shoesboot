package com.sht.vehicle.controller;

import com.sht.vehicle.common.RestResponse;
import com.sht.vehicle.dto.UserDto;
import com.sht.vehicle.entity.User;
import com.sht.vehicle.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aaron
 * @date 2021/2/12 12:37
 */
@RestController
@RequestMapping("api/user")
@Validated
@Api(tags = "用户管理")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity<RestResponse> login(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.login(new User(user)));
    }

    @PostMapping
    public ResponseEntity<RestResponse> registerOrUpdate(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.save(new User(user)));
    }

    @GetMapping("refresh-token")
    public ResponseEntity<RestResponse> refreshToken() {
        return ResponseEntity.ok(SUCCESS(userService.refreshToken(userId), ""));
    }

    @GetMapping
    public ResponseEntity<RestResponse> findByPage(
            @RequestParam(name = "driver", required = false) String driver,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "rows", defaultValue = "20") Integer size
    ) {
        return ResponseEntity.ok(SUCCESS(userService.findByPage(driver, page, size), ""));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse> batchDelete(@RequestParam(name = "ids") List<Integer> ids) {
        return ResponseEntity.ok(userService.batchDelete(ids));
    }

}
