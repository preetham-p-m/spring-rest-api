package com.ppm.springrestapi.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.ppm.springrestapi.response.Response;
import com.ppm.springrestapi.service.interfaces.CloudVendorService;

@RestController
@RequestMapping("/cloud-vendor")
public class CloudVendorController {

  CloudVendorService cloudVendorService;

  public CloudVendorController(CloudVendorService cloudVendorService) {
    this.cloudVendorService = cloudVendorService;
  }

  @GetMapping
  public ResponseEntity<Object> getAll() {
    return Response.build("Requested Vendor detail is given here", HttpStatus.OK, cloudVendorService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getById(@PathVariable("id") UUID id) {
    return Response.build("Requested Vendor detail is given here", HttpStatus.OK, cloudVendorService.getById(id));
  }

  @PostMapping
  public ResponseEntity<Object> create(@RequestBody CloudVendorCreate cloudVendor) {
    return Response.build("Requested Vendor detail is given here", HttpStatus.OK,
        cloudVendorService.create(cloudVendor));
  }

  @PutMapping("/{id}")
  public CloudVendor update(@PathVariable("id") UUID id, @RequestBody CloudVendorCreate cloudVendor) {
    return cloudVendorService.update(id, cloudVendor);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") UUID id) {
    return cloudVendorService.delete(id);
  }
}
