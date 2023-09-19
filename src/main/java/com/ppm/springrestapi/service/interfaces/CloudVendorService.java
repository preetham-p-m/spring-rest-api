package com.ppm.springrestapi.service.interfaces;

import com.ppm.springrestapi.dto.CloudVendor.CloudVendorCreate;
import com.ppm.springrestapi.model.CloudVendor;
import java.util.List;
import java.util.UUID;

public interface CloudVendorService {
  public List<CloudVendor> getAll();

  public CloudVendor getById(UUID id);

  public CloudVendor create(CloudVendorCreate cloudVendor);

  public CloudVendor update(UUID id, CloudVendorCreate cloudVendor);

  public String delete(UUID id);
}
