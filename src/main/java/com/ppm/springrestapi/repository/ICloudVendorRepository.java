package com.ppm.springrestapi.repository;

import com.ppm.springrestapi.model.CloudVendor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICloudVendorRepository extends JpaRepository<CloudVendor, String> {
}
