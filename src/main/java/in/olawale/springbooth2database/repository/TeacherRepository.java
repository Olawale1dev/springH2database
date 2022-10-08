package in.olawale.springbooth2database.repository;

import in.olawale.springbooth2database.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
