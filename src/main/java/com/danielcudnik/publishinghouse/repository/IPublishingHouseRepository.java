package com.danielcudnik.publishinghouse.repository;

import com.danielcudnik.publishinghouse.entity.PublishingHouse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bidzis on 7/17/2017.
 */
public interface IPublishingHouseRepository extends JpaRepository<PublishingHouse, Long> {
}
