package com.folautech.springbootwithpostgres.address;

import java.util.List;

public interface AddressDAO {

    List<Address> getSurroundingHomesByLatLong(int radius, double lat, double lon);

}
