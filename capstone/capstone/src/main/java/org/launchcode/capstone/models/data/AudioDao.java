package org.launchcode.capstone.models.data;


import org.launchcode.capstone.models.Audio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AudioDao extends CrudRepository<Audio, Integer> {
}
