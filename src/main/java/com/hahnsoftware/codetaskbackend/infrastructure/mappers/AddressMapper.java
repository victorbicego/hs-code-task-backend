package com.hahnsoftware.codetaskbackend.infrastructure.mappers;

import com.hahnsoftware.codetaskbackend.domain.Address;
import com.hahnsoftware.codetaskbackend.infrastructure.entities.AddressEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    public AddressEntity toAddressEntity(Address address) {
        AddressEntity entity = new AddressEntity();
        BeanUtils.copyProperties(address, entity);
        return entity;
    }

    public Address toAddress(AddressEntity entity) {
        Address address = new Address();
        BeanUtils.copyProperties(entity, address);
        return address;
    }
}
