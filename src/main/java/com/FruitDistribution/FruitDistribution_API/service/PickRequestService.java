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

    public List<PickRequest> deleteAllRequests() {
        repository.deleteAll();
        return repository.findAll();
    }

    public List<PickRequest> getFinished(String userId) {
        List<PickRequest> allRequests = repository.findAll();
        List<PickRequest> userReqs = null;
        for(PickRequest req : allRequests) {
            if(req.getUserId() == userId) {
                userReqs.add(req);
            }
        }
        List<PickRequest> returnList = null;
        for(PickRequest req : userReqs) {
            if(req.isCompleted()) {
                returnList.add(req);
            }
        }

        return returnList;
    }

    public List<PickRequest> getUnfinished(String userId) {
        List<PickRequest> allRequests = repository.findAll();
        List<PickRequest> userReqs = null;
        for(PickRequest req : allRequests) {
            if(req.getUserId() == userId) {
                userReqs.add(req);
            }
        }
        List<PickRequest> returnList = null;
        for(PickRequest req : userReqs) {
            if(!req.isCompleted()) {
                returnList.add(req);
            }
        }

        return returnList;
    }

    public PickRequest getRequestsFromId(String id) {
        Optional<PickRequest> req = repository.findById(id);
        return req.orElse(null);
    }

    public List<PickRequest> getUserRequests(String userId) {
        List<PickRequest> allreqs = repository.findAll();
        List<PickRequest> goodreqs = null;
        for(PickRequest req : allreqs) {
            if(req.getUserId() == userId) {
                goodreqs.add(req);
            }
        }

        return goodreqs;
    }

    public PickRequest updateRequestsStatus(String id, Boolean status) {
        Optional<PickRequest> req = repository.findById(id);
        if(req.isPresent()) {
            PickRequest newReq = req.get();
            newReq.setCompleted(status);
            return repository.save(newReq);
        }
        else {
            throw new RuntimeException("Pick request not found with id: " + id);
        }
    }
}
