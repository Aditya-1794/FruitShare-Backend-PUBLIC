package com.FruitDistribution.FruitDistribution_API.service;

import com.FruitDistribution.FruitDistribution_API.domain.PickRequest;
import com.FruitDistribution.FruitDistribution_API.repository.PickRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PickRequestService {
    private final PickRequestRepository repository;

    public List<PickRequest> getAllPickRequests() {
        return repository.findAll();
    }

    public PickRequest createNewPickRequest(PickRequest req) {
        return repository.save(req);
    }

    public void deletePickRequest(String id) {
        repository.deleteById(id);
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

    public PickRequest getRequestsFromId(String id) {
        Optional<PickRequest> req = repository.findById(id);
        return req.orElse(null);


//
//        List<PickRequest> reqs = repository.findAll();
//        for(PickRequest req : reqs) {
//            if(req.getId() == id) {
//                return req;
//            }
//        }
//
//        return null;
//
    }
}
