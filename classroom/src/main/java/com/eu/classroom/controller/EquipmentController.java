package com.eu.classroom.controller;

import com.eu.classroom.common.RestResponse;
import com.eu.classroom.entity.Equipment;
import com.eu.classroom.service.EquipmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aaron
 * @date 2021/3/10 22:57
 */
@RequestMapping("api/equipment")
@RestController
@Api(tags = "实验器材")
public class EquipmentController extends BaseController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping
    public ResponseEntity<RestResponse> saveOrUpdate(@RequestBody Equipment equipment) {
        return ResponseEntity.ok(equipmentService.saveOrUpdate(equipment));
    }

    @GetMapping("findByPage")
    public ResponseEntity<RestResponse> findByPage(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "20") Integer size
    ) {
        return ResponseEntity.ok(SUCCESS(equipmentService.findByPage(name, page, size), ""));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse> delete(@RequestParam(name = "id") Integer id) {
        return ResponseEntity.ok(equipmentService.delete(id));
    }
}
