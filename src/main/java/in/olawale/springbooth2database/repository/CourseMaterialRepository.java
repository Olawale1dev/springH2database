package in.olawale.springbooth2database.repository;

import in.olawale.springbooth2database.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
