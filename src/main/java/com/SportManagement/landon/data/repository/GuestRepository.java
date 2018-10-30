package com.SportManagement.landon.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.SportManagement.landon.data.entity.Guest;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {

//    Guest findOne(long guestId);
}