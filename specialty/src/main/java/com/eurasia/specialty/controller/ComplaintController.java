package com.eurasia.specialty.controller;

import com.eurasia.specialty.entity.Complaint;
import com.eurasia.specialty.service.ComplaintService;
import com.eurasia.specialty.utils.JsonData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aaron
 * @date 2020/6/8 - 20:44
 **/
@RestController
@RequestMapping("/api/complaint")
//@Api(tags = "投诉举报服务")
public class ComplaintController extends BaseController{
    @Autowired
    private ComplaintService complaintService;

    @PostMapping()
    @ApiOperation(value = "创建一个举报", notes = "status投诉状态后台处理，0：刚提交，1：正在处理，2：处理完成")
    public ResponseEntity<JsonData> save(@RequestBody Complaint complaint) {
        complaint.setUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(complaintService.save(complaint));
    }

    @GetMapping()
    @ApiOperation(value = "根据id查看投诉详情")
    public ResponseEntity<JsonData> findById(@ApiParam(required = true, value = "投诉id") @RequestParam(name = "id") Integer id){
        return ResponseEntity.ok(JsonData.buildSuccess(complaintService.findById(id),""));
    }

    @GetMapping("findByUserId")
    @ApiOperation(value = "根据userId查找所有投诉")
    public ResponseEntity<JsonData> findByUserId(){
        return ResponseEntity.ok(complaintService.findByUserId(userId));
    }

    @PutMapping()
    @ApiOperation(value = "更新一个举报", notes = "status投诉状态后台处理，0：刚提交，1：正在处理，2：处理完成")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true,paramType = "body"),
            @ApiImplicitParam(name = "content", value = "投诉内容", required = true,paramType = "body"),
            @ApiImplicitParam(name = "evidenceImages", value = "图片证据", required = true,paramType = "body"),
            @ApiImplicitParam(name = "status", value = "投诉处理状态", paramType = "body")
    })
    public ResponseEntity<JsonData> update(@RequestBody Complaint complaint) {
        complaint.setUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(complaintService.update(complaint));
    }

    @DeleteMapping()
    @ApiOperation(value = "根据id删除投诉")
    public ResponseEntity<JsonData> delete(@ApiParam(required = true, value = "投诉id") @RequestParam(name = "id") Integer id){
        return ResponseEntity.ok(complaintService.delete(id));
    }
}
