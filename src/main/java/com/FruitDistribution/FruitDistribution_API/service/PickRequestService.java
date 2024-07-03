package com.FruitDistribution.FruitDistribution_API.service;

import com.FruitDistribution.FruitDistribution_API.domain.PickRequest;
import com.FruitDistribution.FruitDistribution_API.repository.PickRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PickRequestService {
    private final PickRequestRepository repository;

    public List<PickRequest> getAllPickRequests() {
        return repository.findAll();
    }

    public PickRequest getPickRequestById(String id) {
        return repository.findByID(id).orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    public PickRequest createNewPickRequest(PickRequest req) {
        return repository.save(req);
    }

    public void deletePickRequest(PickRequest req) {
        repository.delete(req);
    }

    public List<PickRequest> getFinished() {
        List<PickRequest> allRequests = repository.findAll();
        List<PickRequest> returnList = null;
        for(PickRequest req : allRequests) {
            if(req.isCompleted()) {
                returnList.add(req);
            }
        }

        return returnList;
    }

    public List<PickRequest> getUnfinished() {
        List<PickRequest> allRequests = repository.findAll();
        List<PickRequest> returnList = null;
        for (PickRequest req : allRequests) {
            if (!req.isCompleted()) {
                returnList.add(req);
            }
        }

        return returnList;
    }
}
