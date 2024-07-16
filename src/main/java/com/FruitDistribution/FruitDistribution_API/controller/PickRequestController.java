package com.FruitDistribution.FruitDistribution_API.controller;

import com.FruitDistribution.FruitDistribution_API.domain.PickRequest;
import com.FruitDistribution.FruitDistribution_API.service.PickRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PickRequestController {
    private final PickRequestService service;

    @GetMapping("/getRequestById/{id}")
    public PickRequest getById(@PathVariable String id) {
        return service.getRequestsFromId(id);
    }

    @GetMapping("/getUserRequests/{userId}")
    public List<PickRequest> getUserRequests(@PathVariable String userId) {
        return getUserRequests(userId);
    }

    @GetMapping("getAllPickRequests")
    public List<PickRequest> getAllPickRequests() {
        return service.getAllPickRequests();
    }

    @PostMapping("addNewPickRequest")
    public PickRequest createNewPickRequest(@RequestBody PickRequest req) {
        return service.createNewPickRequest(req);
    }

    @DeleteMapping("/deletePickRequest/{id}")
    public void deletePickRequest(@PathVariable String id) {
        service.deletePickRequest(id);
    }

    @DeleteMapping("deleteAllRequests")
    public List<PickRequest> deleteAllRequests() {
        return service.deleteAllRequests();
    }

    //these 2 aren't working
    @GetMapping("getFinishedRequests")
    public List<PickRequest> getFinished() {
        return service.getFinished();
    }

    @GetMapping("getUnfinishedRequests")
    public List<PickRequest> getUnfinished() {
        return service.getUnfinished();
    }

    @PutMapping("/updateStatus/{id}")
    public PickRequest updateRequestsStatus(@PathVariable String id, @RequestBody Boolean status) {
        return service.updateRequestsStatus(id, status);
    }
}
