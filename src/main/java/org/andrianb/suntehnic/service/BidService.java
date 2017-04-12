package org.andrianb.suntehnic.service;

import org.andrianb.suntehnic.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Andrianb on 4/12/2017.
 */
@Service
@Transactional
public class BidService {
    @Autowired
    BidRepository bidRepository;

    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }
}
