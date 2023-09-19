package com.ppm.springrestapi.controller;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppm.springrestapi.dto.CloudVendor.CloudVendorCreate;
import com.ppm.springrestapi.model.CloudVendor;
import com.ppm.springrestapi.service.interfaces.ICloudVendorService;

@RestController
@RequestMapping("/cloud-vendor")
public class CloudVendorController {

  ICloudVendorService cloudVendorService;

  public CloudVendorController(ICloudVendorService cloudVendorService) {
    this.cloudVendorService = cloudVendorService;
  }

  @GetMapping
  public List<CloudVendor> getAll() {
    return this.cloudVendorService.getAll();
  }

  @GetMapping("/{id}")
  public CloudVendor getById(@PathVariable("id") UUID id) {
    return this.cloudVendorService.getById(id);
  }

  @PostMapping
  public CloudVendor create(@RequestBody CloudVendorCreate cloudVendor) {
    return this.cloudVendorService.create(cloudVendor);
  }

  @PutMapping("/{id}")
  public CloudVendor update(@PathVariable("id") UUID id, @RequestBody CloudVendorCreate cloudVendor) {
    return this.cloudVendorService.update(id, cloudVendor);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") UUID id) {
    return this.cloudVendorService.delete(id);
  }
}