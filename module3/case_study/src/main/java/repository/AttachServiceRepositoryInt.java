package repository;

import model.AttachFacility;

import java.util.List;

public interface AttachServiceRepositoryInt {
    List<AttachFacility> selectAllAttachService();
}
