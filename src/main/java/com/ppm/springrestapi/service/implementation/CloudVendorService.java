package com.ppm.springrestapi.service.implementation;

import com.ppm.springrestapi.dto.CloudVendor.CloudVendorCreate;
import com.ppm.springrestapi.model.CloudVendor;
import com.ppm.springrestapi.repository.ICloudVendorRepository;
import com.ppm.springrestapi.service.interfaces.ICloudVendorService;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class CloudVendorService implements ICloudVendorService {

  ICloudVendorRepository cloudVendorRepository;

  public CloudVendorService(ICloudVendorRepository cloudVendorRepository) {
    this.cloudVendorRepository = cloudVendorRepository;
  }

  @Override
  public List<CloudVendor> getAll() {
    return this.cloudVendorRepository.findAll();
  }

  @Override
  public CloudVendor getById(UUID id) {
    return this.cloudVendorRepository.findById(id.toString()).get();
  }

  @Override
  public CloudVendor create(CloudVendorCreate cloudVendor) {
    CloudVendor _cloudVendor = new CloudVendor(UUID.randomUUID().toString(), cloudVendor.name, cloudVendor.address,
        cloudVendor.phoneNumber);
    return this.cloudVendorRepository.save(_cloudVendor);
  }

  @Override
  public CloudVendor update(UUID id, CloudVendorCreate cloudVendor) {
    CloudVendor _cloudVendor = new CloudVendor(id.toString(), cloudVendor.name, cloudVendor.address,
        cloudVendor.phoneNumber);
    return this.cloudVendorRepository.save(_cloudVendor);
  }

  @Override
  public String delete(UUID id) {
    this.cloudVendorRepository.deleteById(id.toString());
    return "Successfully deleted the vendor";
  }
}
