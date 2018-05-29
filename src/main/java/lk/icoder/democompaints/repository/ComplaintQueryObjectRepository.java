package lk.icoder.democompaints.repository;

import lk.icoder.democompaints.entity.ComplaintQueryObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Project demo-compaints
 * @Author DILAN on 5/13/2018
 */
@Repository
public interface ComplaintQueryObjectRepository extends JpaRepository<ComplaintQueryObject, String> {
}
