package com.ppm.springrestapi.service.implementation;

import com.ppm.springrestapi.dto.CloudVendor.CloudVendorCreate;
import com.ppm.springrestapi.exception.NotFoundException;
import com.ppm.springrestapi.model.CloudVendor;
import com.ppm.springrestapi.repository.ICloudVendorRepository;
import com.ppm.springrestapi.service.interfaces.CloudVendorService;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

  ICloudVendorRepository cloudVendorRepository;

  public CloudVendorServiceImpl(ICloudVendorRepository cloudVendorRepository) {
    this.cloudVendorRepository = cloudVendorRepository;
  }

  @Override
  public List<CloudVendor> getAll() {
    return cloudVendorRepository.findAll();
  }

  @Override
  public CloudVendor getById(UUID id) {
    var cloudVendor = cloudVendorRepository.findById(id.toString());

    if (cloudVendor.isEmpty()) {
      throw new NotFoundException("Cloud Vendor Not Found");
    }

    return cloudVendor.get();
  }

  @Override
  public CloudVendor create(CloudVendorCreate cloudVendor) {
    CloudVendor _cloudVendor = new CloudVendor(UUID.randomUUID().toString(), cloudVendor.name, cloudVendor.address,
        cloudVendor.phoneNumber);

    return cloudVendorRepository.save(_cloudVendor);
  }

  @Override
  public CloudVendor update(UUID id, CloudVendorCreate cloudVendor) {
    CloudVendor _cloudVendor = new CloudVendor(id.toString(), cloudVendor.name, cloudVendor.address,
        cloudVendor.phoneNumber);

    return cloudVendorRepository.save(_cloudVendor);
  }

  @Override
  public String delete(UUID id) {
    cloudVendorRepository.findById(id.toString())
        .orElseThrow(() -> new NotFoundException("Cloud Vendor Not Found"));

    cloudVendorRepository.deleteById(id.toString());
    return "Successfully deleted the vendor";
  }
}
